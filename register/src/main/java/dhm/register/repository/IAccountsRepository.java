package dhm.register.repository;

import dhm.register.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountsRepository extends JpaRepository<Accounts, Integer> {
    Accounts findByUsername(String username);
}
