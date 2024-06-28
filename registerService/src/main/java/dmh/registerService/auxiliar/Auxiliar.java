package dmh.registerService.auxiliar;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Auxiliar {

    public BigInteger generateCVU(){

        SecureRandom random = new SecureRandom();

        // Generate a random BigInteger with 73 bits (which is just over 22 decimal digits)
        BigInteger bigInteger = new BigInteger(73, random);

        return bigInteger;
    }

    public String generateAlias(){
        String filePath = "C:\\Users\\Portatil\\Desktop\\DH\\digitalMoneyHouse\\dp-backend-main\\registerService\\src\\main\\java\\dmh\\registerService\\auxiliar\\alias.txt";
        String alias = "";
        Random random = new Random();
        Integer number1 = random.nextInt(400) + 1;
        Integer number2 = random.nextInt(400) + 1;
        Integer number3 = random.nextInt(400) + 1;

        try {
            List<String> file = Files.readAllLines(Paths.get(filePath));
            alias += file.get(number1) + '.';
            alias += file.get(number2) + '.';
            alias += file.get(number3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alias;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
