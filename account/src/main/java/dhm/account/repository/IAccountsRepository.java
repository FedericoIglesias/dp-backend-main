package dhm.account.repository;

import dhm.account.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountsRepository extends JpaRepository<Accounts,Integer> {
}
