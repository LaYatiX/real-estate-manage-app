package pl.gpiwosz.estate.Resolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.repository.ApartmentRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ApartmentQuery implements GraphQLQueryResolver {
    private final ApartmentRepository repository;

    public Apartment getApartment(Long id) {
        return repository.findById(id).get();
    }

    public List<Apartment> getApartments() {
        return repository.findAll();
    }
}
