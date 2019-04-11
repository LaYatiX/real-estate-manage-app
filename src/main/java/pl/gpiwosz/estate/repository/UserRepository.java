package pl.gpiwosz.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gpiwosz.estate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
