package dhm_backend.register_login.repository;

import dhm_backend.register_login.dto.UsersRegister;
import dhm_backend.register_login.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
