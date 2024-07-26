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
    public String getToken(@RequestParam String username,@RequestParam Integer id){
        return serviJwt.getToken(username, id);
    }

    @GetMapping("/username")
    public String getUsernameFromToken(@RequestParam String token){
        return serviJwt.getUsernameFromToken(token);
    }

    @GetMapping("/id")
    public String getIdFromToken(@RequestParam String token){
        return serviJwt.getIdFromToken(token);
    }

    @GetMapping("/validate")
    public Boolean isValidate(@RequestParam String token){
        return serviJwt.isTokenExpired(token);
    }
}
