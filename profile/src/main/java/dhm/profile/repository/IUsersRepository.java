package dhm.profile.repository;

import dhm.profile.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IUsersRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
