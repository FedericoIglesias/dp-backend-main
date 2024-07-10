package dhm.singlesignon.service;

import dhm.singlesignon.dto.UsersResponse;
import dhm.singlesignon.model.Users;
import dhm.singlesignon.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UsersService {
    @Autowired
    IUsersRepository repoUsers;

    public UsersResponse registerUser(Users user){
        user.setAlias(createAlias());
        user.setCvu(createCVU());
        user.setPassword(passwordEncoder().encode(user.getPassword()));

        repoUsers.save(user);
        Users userResponse = repoUsers.findByUsername(user.getUsername());
        return UsersResponse.builder()
                .name(userResponse.getName())
                .lastname(userResponse.getLastname())
                .phone(userResponse.getPhone())
                .email(userResponse.getUsername())
                .cvu(userResponse.getCvu())
                .alias(userResponse.getAlias())
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
}
