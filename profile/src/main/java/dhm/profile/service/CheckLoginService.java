package dhm.profile.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class CheckLoginService {

    @Autowired
    UsersService serviUsers;

    @Autowired
    JwtService serviJwt;

    public Boolean checkLogin(HttpServletRequest request, Integer idUser) {
        String token = request.getHeader(AUTHORIZATION).substring(7);
        if(!serviUsers.getUser(idUser).getUsername().equals(serviJwt.getUsernameFromToken(token))){
            return false;
        }
        return true;
    }
}
