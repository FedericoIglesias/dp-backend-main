package dhm.singlesignon.controller;

import dhm.singlesignon.dto.UsersResponse;
import dhm.singlesignon.model.RequestUsers;
import dhm.singlesignon.model.Role;
import dhm.singlesignon.model.Users;
import dhm.singlesignon.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UsersService serviUser;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("STATUS OK");
    }
    @PostMapping("/user")
    public ResponseEntity<UsersResponse> register(@RequestBody RequestUsers request){
        Users user = Users.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .username(request.getEmail())
                .lastname(request.getLastname())
                .password(request.getPassword())
                .role(Role.USER)
                .build();
        UsersResponse resUser = serviUser.registerUser(user);
        return ResponseEntity.ok(resUser);
    }
}
