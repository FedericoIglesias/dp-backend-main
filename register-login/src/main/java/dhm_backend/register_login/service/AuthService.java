package dhm_backend.register_login.service;

import dhm_backend.register_login.auth.AuthResponse;
import dhm_backend.register_login.auth.LoginRequest;
import dhm_backend.register_login.auth.RegisterRequest;
import dhm_backend.register_login.model.Role;
import dhm_backend.register_login.model.Users;
import dhm_backend.register_login.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository repoUser;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        Users user = Users.builder()
                .username(request.getEmail())
                .password(passwordEncoder().encode(request.getPassword()))
                .name(request.getName())
                .phone(request.getPhone())
                .lastname(request.getLastname())
                .role(Role.USER)
                .build();
        repoUser.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = repoUser.findByUsername(request.getEmail()).orElseThrow();
        String token= jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

