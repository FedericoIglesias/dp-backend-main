package dhm.singlesignon.controller;

import dhm.singlesignon.dto.LoginRequestDTO;
import dhm.singlesignon.dto.LoginResponseDTO;
import dhm.singlesignon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService serviLogin;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("STATUS OK");
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO requestDTO){
        LoginResponseDTO res = serviLogin.login(requestDTO);
        if(res == null){
            return ResponseEntity.badRequest().body("Invalid User or Password");
        }
        return ResponseEntity.ok(res.getToken());
    }
}
