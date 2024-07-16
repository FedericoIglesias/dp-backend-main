package dhm.transacctions.repository;

import dhm.transacctions.model.Accounts;
import dhm.transacctions.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionsRepository extends JpaRepository<Transactions,Integer> {
    List<Transactions> findByAccount(Integer account_id);
}
