package dhm.singlesignon.repository;

import dhm.singlesignon.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
