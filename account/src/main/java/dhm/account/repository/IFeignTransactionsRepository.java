package dhm.account.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(name = "transactions")
public interface IFeignTransactionsRepository {

    @RequestMapping(method = RequestMethod.GET,value="/")
    String getToken(@RequestParam String username);
}
