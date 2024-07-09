package dhm.logout.repository;

import dhm.logout.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
