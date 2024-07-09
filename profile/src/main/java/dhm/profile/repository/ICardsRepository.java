package dhm.profile.repository;

import dhm.profile.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardsRepository extends JpaRepository<Cards,Integer> {
}
