package pl.gpiwosz.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gpiwosz.estate.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
