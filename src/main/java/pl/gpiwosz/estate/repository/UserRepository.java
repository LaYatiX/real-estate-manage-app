package pl.gpiwosz.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.model.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM apartment" +
//            "LEFT JOIN ")
//    Set<User> findResidentsByApartment(Apartment apartment);
}
