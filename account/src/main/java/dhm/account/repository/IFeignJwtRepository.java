package dhm.account.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jwt")
public interface IFeignJwtRepository {

    @RequestMapping(method = RequestMethod.GET,value="/jwt/id")
    String getIdFromToken(@RequestParam String token);

}
