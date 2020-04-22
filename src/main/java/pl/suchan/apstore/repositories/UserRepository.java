package pl.suchan.apstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.suchan.apstore.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
