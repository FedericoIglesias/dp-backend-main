package dhm.account.service;

import dhm.account.repository.IFeignJwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    IFeignJwtRepository feignJwt;

    public String getIdFromToken(String token){
        return feignJwt.getIdFromToken(token);
    }
}
