package pl.gpiwosz.estate.Resolver.Query;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.Estate;
import pl.gpiwosz.estate.repository.EstateRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EstateQuery implements GraphQLQueryResolver {
    private final EstateRepository repository;

    public Estate getEstate(Long id) {
        return repository.findById(id).get();
    }

    public List<Estate> getEstates() {
        return repository.findAll();
    }
}