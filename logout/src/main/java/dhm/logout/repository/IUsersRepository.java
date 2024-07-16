package dhm.logout.repository;

import dhm.logout.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Accounts,Integer> {
    Accounts findByUsername(String username);
}
