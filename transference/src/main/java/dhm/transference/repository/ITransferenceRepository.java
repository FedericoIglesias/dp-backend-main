package dhm.transference.repository;

import dhm.transference.model.Transference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransferenceRepository extends JpaRepository<Transference,Integer> {
    List<Transference> findByAccount(Integer account_id);
}
