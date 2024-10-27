package dhm.login.service;

import dhm.login.dto.LoginRequestDTO;
import dhm.login.dto.LoginResponseDTO;
import dhm.login.model.Accounts;
import dhm.login.repository.IFeignJwtRepository;
import dhm.login.repository.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    ILoginRepository repoLogin;

    @Autowired
    IFeignJwtRepository feignJwt;


    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        Accounts user = repoLogin.findByUsername(requestDTO.getEmail());
        if(user != null && passwordEncoder().matches(requestDTO.getPassword(), user.getPassword())){
            String token = feignJwt.getToken(user.getUsername(), user.getId());
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
