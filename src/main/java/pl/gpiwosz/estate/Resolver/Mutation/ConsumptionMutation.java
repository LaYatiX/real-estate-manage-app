package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.ConsumptionInput;
import pl.gpiwosz.estate.mappers.ConsumptionMapper;
import pl.gpiwosz.estate.model.Consumption;
import pl.gpiwosz.estate.repository.ConsumptionRepository;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ConsumptionMutation implements GraphQLMutationResolver {
    private final ConsumptionRepository repository;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public Consumption createConsumption(final ConsumptionInput systemConsumption) {
        return repository.save(ConsumptionMapper.toEntity(systemConsumption));
    }

    public Consumption updateConsumption(final Long id, final ConsumptionInput systemConsumption) {
        return repository.findById(id).map(consumption ->
                repository.save(ConsumptionMapper.toEntity(systemConsumption))
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteConsumption(final Long id) {
        final Consumption consumption = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(consumption);
        return id;
    }
}
