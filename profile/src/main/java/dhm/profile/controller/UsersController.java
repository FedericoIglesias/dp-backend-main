package dhm.profile.controller;

import dhm.profile.dto.UsersResponse;
import dhm.profile.model.Users;
import dhm.profile.service.JwtService;
import dhm.profile.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class UsersController {

    @Autowired
    UsersService serviUser;

    @Autowired
    JwtService serviJwt;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("STATUS OK");
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UsersResponse> getUser(@PathVariable("id") Integer id){
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

    @PutMapping("/users/{id}")
    public ResponseEntity<UsersResponse> modifyUser(@RequestBody Users user, @PathVariable("id") Integer id, HttpServletRequest request){
        String token = request.getHeader(AUTHORIZATION).substring(7);
        if(!serviJwt.getUsernameFromToken(token).equals(user.getUsername())){
            System.out.println("username and user are not some");
            return null;
        };

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
