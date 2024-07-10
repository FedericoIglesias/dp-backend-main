package dhm.profile.service;

import dhm.profile.model.Users;
import dhm.profile.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    IUsersRepository repoUser;
    public Users getUser(Integer id) {
        return repoUser.findById(id).orElse(null);
    }

    public Users modifyUser(Users newUser, Integer id) {

        Users user = getUser(id);
        if(!user.getUsername().equals(user.getUsername())){
            return null;
        }
        newUser.setId(id);
        newUser.setPassword(user.getPassword());
        newUser.setToken(user.getToken());
        repoUser.save(newUser);
        return getUser(id);
    }
}
