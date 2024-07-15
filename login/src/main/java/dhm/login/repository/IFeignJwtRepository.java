package dhm.login.repository;

import dhm.login.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jwt")
public interface IFeignJwtRepository {
    @RequestMapping(method = RequestMethod.GET,value="/jwt/token")
    String getToken(@RequestParam String username);
}
