package dmh.registerService.service;

import dmh.registerService.config.AuthResponse;
import dmh.registerService.config.LoginRequest;
import dmh.registerService.config.RegisterRequest;
import dmh.registerService.model.Role;
import dmh.registerService.model.Users;
import dmh.registerService.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService{


    @Autowired
    IUsersRepository repoUser;

    @Autowired
    JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        Users user = Users.builder()
                .name(request.getName())
                .password(request.getPassword())
                .dni(request.getDni())
                .email(request.getEmail())
                .phone(request.getPhone())
                .role(Role.USER)
                .build();

        repoUser.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    @Override
    public List<Users> getListUsers() {
        return repoUser.findAll();
    }

    @Override
    public Users getUser(Integer id) {
        return repoUser.findById(id).orElse(null);
    }

    @Override
    public void saveUser(Users user) {
    repoUser.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
    repoUser.deleteById(id);
    }

    @Override
    public Users modifyUser(Users user) {
        repoUser.save(user);
        return repoUser.findById(user.getId()).orElse(null);
    }
 }
