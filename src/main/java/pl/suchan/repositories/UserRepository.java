package pl.suchan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.suchan.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
