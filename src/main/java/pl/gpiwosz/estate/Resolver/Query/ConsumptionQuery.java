package pl.gpiwosz.estate.Resolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.Consumption;
import pl.gpiwosz.estate.repository.ConsumptionRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConsumptionQuery implements GraphQLQueryResolver {
    private final ConsumptionRepository repository;

    public Consumption getConsumption(Long id) {
        return repository.findById(id).get();
    }

    public List<Consumption> getConsumptions() {
        return repository.findAll();
    }
}
