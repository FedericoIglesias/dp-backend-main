package dmh.registerService.service;


import dmh.registerService.config.AuthResponse;
import dmh.registerService.config.LoginRequest;
import dmh.registerService.config.RegisterRequest;
import dmh.registerService.model.Users;

import java.util.ArrayList;
import java.util.List;

public interface IUsersService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);
    List<Users> getListUsers();

    Users getUser(Integer id);

    void saveUser(Users user);

    void deleteUser(Integer id);

    Users modifyUser(Users user);
}
