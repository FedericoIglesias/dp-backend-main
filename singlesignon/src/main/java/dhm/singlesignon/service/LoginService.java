package dhm.singlesignon.service;

import dhm.singlesignon.dto.LoginRequestDTO;
import dhm.singlesignon.dto.LoginResponseDTO;
import dhm.singlesignon.model.Users;
import dhm.singlesignon.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    IUsersRepository repoUser;

    @Autowired
    JwtService serviJwt;

    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        Users user = repoUser.findByUsername(requestDTO.getEmail());
        if(passwordEncoder().matches(requestDTO.getPassword(), user.getPassword())){
            String token = serviJwt.getToken(user);
            user.setToken(token);
            repoUser.save(user);
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
