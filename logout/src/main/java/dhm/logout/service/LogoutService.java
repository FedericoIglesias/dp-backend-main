package dhm.logout.service;

import dhm.logout.model.Users;
import dhm.logout.repository.IFeignJwtRepository;
import dhm.logout.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {

    @Autowired
    IUsersRepository repoUsers;

    @Autowired
    IFeignJwtRepository feignJwt;

    public String invalidateToken(String token) {
        String username = feignJwt.getUsernameFromToken(token);

        Users user = repoUsers.findByUsername(username);

        if (user == null || user.getToken() == null || !user.getToken().equals(token)) {
            return "Token doesn't belong to a user ";
        }
        user.setToken(null);
        repoUsers.save(user);
        return "Token invalidated";
    }
}
