package dhm.login.repository;


import dhm.login.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
