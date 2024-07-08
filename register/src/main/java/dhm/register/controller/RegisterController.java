package dhm.register.controller;

import dhm.register.dto.UsersResponse;
import dhm.register.model.RequestUsers;
import dhm.register.model.Users;
import dhm.register.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UsersService serviUser;

    @PostMapping("/user")
    public ResponseEntity<UsersResponse> register(@RequestBody RequestUsers request){
        Users user = Users.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .username(request.getEmail())
                .lastname(request.getLastname())
                .password(request.getPassword())
                .build();
        UsersResponse resUser = serviUser.registerUser(user);
        return ResponseEntity.ok(resUser);
    }
}
