package dhm.card.repository;

import dhm.card.model.Cards;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardsRepository extends JpaRepository<Cards, Integer> {
}
