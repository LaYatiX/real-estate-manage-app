package pl.gpiwosz.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gpiwosz.estate.model.Estate;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {
}
