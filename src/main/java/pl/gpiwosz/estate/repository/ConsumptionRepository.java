package pl.gpiwosz.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gpiwosz.estate.model.Consumption;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}
