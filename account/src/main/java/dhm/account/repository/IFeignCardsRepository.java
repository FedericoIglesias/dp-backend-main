package dhm.account.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;

@Repository
@FeignClient(name = "cards")
public interface IFeignCardsRepository {
}
