package dhm.jwt.controller;

import dhm.jwt.dto.Users;
import dhm.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    JwtService serviJwt;

    @GetMapping("/token")
    public String getToken(@RequestParam String username){
        System.out.println("pegada a jwt");
        return serviJwt.getToken(username);
    }

}
