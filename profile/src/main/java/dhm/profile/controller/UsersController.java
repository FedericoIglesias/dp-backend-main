package dhm.profile.controller;

import dhm.profile.dto.UsersResponse;
import dhm.profile.model.Users;
import dhm.profile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    UsersService serviUser;
    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("STATUS OK");
    }
    @GetMapping("/users/:id")
    public ResponseEntity<UsersResponse> getUser(@PathVariable Integer id){
        Users user = serviUser.getUser(id);

        if(user == null){
            return null;
        }

        return ResponseEntity.ok(UsersResponse.builder()
                        .name(user.getName())
                        .lastname(user.getLastname())
                        .email(user.getUsername())
                        .phone(user.getPhone())
                        .cvu(user.getCvu())
                        .alias(user.getAlias())
                .build());
    }

    @PutMapping("/users/:id")
    public ResponseEntity<UsersResponse> modifyUser(@RequestBody Users user, @PathVariable Integer id){
        Users newUser = serviUser.modifyUser(user, id);
        if(newUser == null){
            return null;
        }
        return ResponseEntity.ok(UsersResponse.builder()
                .name(newUser.getName())
                .lastname(newUser.getLastname())
                .email(newUser.getUsername())
                .phone(newUser.getPhone())
                .cvu(newUser.getCvu())
                .alias(newUser.getAlias())
                .build());
    }

}
