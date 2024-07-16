package dhm.account.repository;

import dhm.account.model.Transactions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "transactions")
public interface IFeignTransactionsRepository {

    @RequestMapping(method = RequestMethod.GET,value="/transaction")
    List<Transactions> getTransaction(@RequestParam Integer idAccount);
}
