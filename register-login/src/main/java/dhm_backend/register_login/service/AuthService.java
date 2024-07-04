package dhm_backend.register_login.service;

import dhm_backend.register_login.auth.AuthResponse;
import dhm_backend.register_login.auth.LoginRequest;
import dhm_backend.register_login.auth.RegisterRequest;
import dhm_backend.register_login.model.Role;
import dhm_backend.register_login.model.User;
import dhm_backend.register_login.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository repoUser;
    private final JwtService jwtService;
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();
        repoUser.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
return null;
    }
}
