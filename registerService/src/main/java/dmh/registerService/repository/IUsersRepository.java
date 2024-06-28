package dmh.registerService.repository;

import dmh.registerService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer> {
}
