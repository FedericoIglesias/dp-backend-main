package dhm_backend.register_login.service;

import dhm_backend.register_login.auth.AuthResponse;
import dhm_backend.register_login.auth.LoginRequest;
import dhm_backend.register_login.auth.RegisterRequest;
import dhm_backend.register_login.dto.UsersRegister;
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

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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
                .cvu(createCVU())
                .alias(createAlias())
                .role(Role.USER)
                .build();
        repoUser.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = repoUser.findByUsername(request.getEmail());
        String token= jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String createCVU(){
        String cvu = new BigInteger(73,new Random()).toString();
        return cvu;
    }

    public String createAlias(){
        String alias = "";
        String filePath = "C:\\Users\\Portatil\\Desktop\\myFolder\\myProject\\digitalMoneyHouse\\dp-backend-main\\register-login\\src\\main\\java\\dhm_backend\\register_login\\service\\alias.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            alias = alias + lines.get(new Random().nextInt(100)) + ".";
            alias = alias + lines.get(new Random().nextInt(100)) + ".";
            alias = alias + lines.get(new Random().nextInt(100));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alias;
    }

    public UsersRegister getUser(String email) {
        Users users = repoUser.findByUsername(email);
        UsersRegister regUser = null;
        if (users == null) {
        }
        regUser = UsersRegister.builder()
                .email(users.getUsername())
                .name(users.getName())
                .lastname(users.getLastname())
                .phone(users.getPhone())
                .cvu(users.getCvu())
                .alias(users.getAlias())
                .name(users.getName())
                .build();

        return regUser;
    }
}

