package dhm.account.repository;

import dhm.account.model.Cards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@FeignClient(name = "card")
public interface IFeignCardsRepository {

    @RequestMapping(method = RequestMethod.GET,value="/api/cards/account")
    List<Cards> getCards(@RequestParam Integer idUser);

    @RequestMapping(method = RequestMethod.GET,value="/api/cards/{id}")
    Cards getCard(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST,value = "/api/cards/save")
    Integer saveCard(@RequestBody Cards card);

    @RequestMapping(method = RequestMethod.DELETE,value = "/api/cards/delete")
    Integer deleteCard(@RequestParam Integer id);
}
