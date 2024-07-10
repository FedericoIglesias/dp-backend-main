package dhm.singlesignon.service;

import dhm.singlesignon.model.Users;
import dhm.singlesignon.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {

    @Autowired
    IUsersRepository repoUsers;

    @Autowired
    JwtService serviJwt;

    public String invalidateToken(String token) {
        String username = serviJwt.getUsernameFromToken(token);

        Users user = repoUsers.findByUsername(username);

        if (user == null || user.getToken() == null || !user.getToken().equals(token)) {
            return "Token doesn't belong to a user ";
        }
        user.setToken(null);
        repoUsers.save(user);
        return "Token invalidated";
    }
}