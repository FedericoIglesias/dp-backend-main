package dhm.login.service;

import dhm.login.dto.LoginRequestDTO;
import dhm.login.dto.LoginResponseDTO;
import dhm.login.model.Users;
import dhm.login.repository.ILoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    ILoginRepository repoLogin;

    @Autowired
    JwtService serviJwt;

    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        Users user = repoLogin.findByUsername(requestDTO.getEmail());
        if(passwordEncoder().matches(requestDTO.getPassword(), user.getPassword())){
            String token = serviJwt.getToken(user);
            user.setToken(token);
            repoLogin.save(user);
            return LoginResponseDTO.builder()
                    .token(token)
                    .build();
        }
        return null;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
