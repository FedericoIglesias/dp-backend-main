package dmh.registerService.controller;

import dmh.registerService.auxiliar.Auxiliar;
import dmh.registerService.model.Users;
import dmh.registerService.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService serviUsers;

    @GetMapping
    public ResponseEntity<List<Users>> getListUsers(){
        return new ResponseEntity<>(serviUsers.getListUsers(),HttpStatus.OK);
    }

    @GetMapping("/:id")
    public ResponseEntity<Users>  getUser(@PathVariable Integer id){
        return  new ResponseEntity<>(serviUsers.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user){
        BigInteger cvu = new Auxiliar().generateCVU();
        user.setCvu(cvu);
        user.setAlias(new Auxiliar().generateAlias());
       // user.setPassword(new Auxiliar().bCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println(user.getName());
        serviUsers.saveUser(user);

        Users resUser = serviUsers.getUser(user.getId());
        // resUser.setPassword(null);
        return new ResponseEntity<>(resUser,HttpStatus.CREATED);
    }

    @DeleteMapping("/:id")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        serviUsers.deleteUser(id);
        return new ResponseEntity<>("Success to delete user", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Users> modifyUser(Users user){
        serviUsers.modifyUser(user);
        Users user1 = serviUsers.getUser(user.getId());
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

}
