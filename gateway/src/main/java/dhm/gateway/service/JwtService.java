package dhm.gateway.service;

import dhm.gateway.repository.IFeignJwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    IFeignJwtRepository feignJwt;

    public Boolean validateToken(String token){
        return feignJwt.validateToken(token);
    }

    public String getIdFromToken(String token){
        return feignJwt.getIdFromToken(token);
    }

}
