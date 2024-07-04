package dmh.registerService.repository;

import dmh.registerService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsername(String email);
}
