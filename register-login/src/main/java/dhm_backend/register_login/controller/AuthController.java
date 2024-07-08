package dhm_backend.register_login.controller;

import dhm_backend.register_login.auth.AuthResponse;
import dhm_backend.register_login.auth.LoginRequest;
import dhm_backend.register_login.auth.RegisterRequest;
import dhm_backend.register_login.dto.UsersRegister;
import dhm_backend.register_login.service.AuthService;
import jakarta.persistence.PostRemove;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UsersRegister> register(@RequestBody RegisterRequest request){
        authService.register(request);
        UsersRegister user = authService.getUser(request.getEmail());
        if(user == null){
            return null;
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader Header header){
        List<String> listValues = header.getValues();

        return  null;


    }
}
