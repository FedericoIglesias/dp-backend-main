package dhm.card.repository;

import dhm.card.model.Transference;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name="transference")
public interface IFeignTransferenceRepository {

    @RequestMapping(method = RequestMethod.GET,value="/api/cards/account")
    List<Transference> getListTransference(@RequestParam Integer idUser);

    @RequestMapping(method = RequestMethod.POST,value = "/api")
    void saveTransference(@RequestBody Transference transference);
}
