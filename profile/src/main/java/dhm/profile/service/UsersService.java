package dhm.profile.service;

import dhm.profile.model.Users;
import dhm.profile.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    IUsersRepository repoUser;
    public Users getUser(Integer id) {
        return repoUser.findById(id).orElse(null);
    }

    public Users modifyUser(Users user, Integer id) {
        if(!getUser(id).getUsername().equals(user.getUsername())){
            return null;
        };
        repoUser.save(user);
        return getUser(id);
    }
}
