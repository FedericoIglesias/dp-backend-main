package dmh.registerService.service;

import dmh.registerService.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class JwtService {
    public String getToken(UserDetails user) {
return getToken(new HashMap<>(),user);
    }

    private String getToken(HashMap<String, Objects> extraClaims, UserDetails user) {
        return Jwts
    }
}
