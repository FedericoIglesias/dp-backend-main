package dhm.account.repository;

import dhm.account.model.Cards;
import dhm.account.model.Transactions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "card")
public interface IFeignCardsRepository {

    @RequestMapping(method = RequestMethod.GET,value="/api/cards/account")
    List<Cards> getCards(@RequestParam Integer idUser);

    @RequestMapping(method = RequestMethod.GET,value="/api/cards/{id}")
    Cards getCard(@PathVariable Integer id);

}
