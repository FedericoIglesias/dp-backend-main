package dhm.register.controller;

import dhm.register.dto.UsersResponse;
import dhm.register.model.RequestUsers;
import dhm.register.model.Accounts;
import dhm.register.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    AccountsService serviAccount;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("STATUS OK");
    }
    @PostMapping("/user")
    public ResponseEntity<UsersResponse> register(@RequestBody RequestUsers request){
        Accounts user = Accounts.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .username(request.getEmail())
                .lastname(request.getLastname())
                .password(request.getPassword())
                .amount(0.0)
                .build();
        UsersResponse resUser = serviAccount.registerUser(user);
        return ResponseEntity.ok(resUser);
    }
}
