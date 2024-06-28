package dmh.registerService.service;

import dmh.registerService.model.Users;
import dmh.registerService.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService implements IUsersService{

    @Autowired
    IUsersRepository repoUser;

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
