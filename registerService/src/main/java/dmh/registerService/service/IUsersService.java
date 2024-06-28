package dmh.registerService.service;


import dmh.registerService.model.Users;

import java.util.ArrayList;
import java.util.List;

public interface IUsersService {

    List<Users> getListUsers();

    Users getUser(Integer id);

    void saveUser(Users user);

    void deleteUser(Integer id);

    Users modifyUser(Users user);
}
