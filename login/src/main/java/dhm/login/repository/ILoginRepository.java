package dhm.login.repository;


import dhm.login.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends JpaRepository<Accounts, Integer> {
    Accounts findByUsername(String username);
}
