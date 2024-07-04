package dmh.registerService.controller;

import dmh.registerService.config.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsersController {

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login(){
        return  ResponseEntity.ok(new AuthResponse());
    }

    @PostMapping("/auth/register")
    public ResponseEntity<AuthResponse> register(){
        return ResponseEntity.ok(new AuthResponse());
    }

    @PostMapping("/demo")
    public String demo(){
        return "Welcome form  secrure endpoint";
    }

    /*
    @Autowired
    UsersService serviUsers;
    @Autowired
    JWTUtil jwt;

    @GetMapping
    public ResponseEntity<List<Users>> getListUsers(){
        return new ResponseEntity<>(serviUsers.getListUsers(),HttpStatus.OK);
    }

    @GetMapping("/:name")
    public String  getJWT(@PathVariable String name){
        return  jwt.generateToken(name);
    }
    @GetMapping("/:id")
    public ResponseEntity<Users>  getUser(@PathVariable Integer id){
        return  new ResponseEntity<>(serviUsers.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Users> saveUser(@RequestBody Users user){
        BigInteger cvu = new Auxiliar().generateCVU();
        user.setCvu(cvu);
        user.setAlias(new Auxiliar().generateAlias());
        user.setPassword(new Auxiliar().bCryptPasswordEncoder().encode(user.getPassword()));
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
 */
}
