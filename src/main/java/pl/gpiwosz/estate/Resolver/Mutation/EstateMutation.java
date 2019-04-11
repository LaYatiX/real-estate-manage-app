package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.EstateInput;
import pl.gpiwosz.estate.mappers.EstateMapper;
import pl.gpiwosz.estate.model.Estate;
import pl.gpiwosz.estate.repository.EstateRepository;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class EstateMutation implements GraphQLMutationResolver {
    private final EstateRepository repository;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public Estate createEstate(final EstateInput systemEstate) {
        return repository.save(EstateMapper.toEntity(systemEstate));
    }

    public Estate updateEstate(final Long id, final EstateInput systemEstate) {
        return repository.findById(id).map(estate ->
                repository.save(EstateMapper.toEntity(systemEstate))
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteEstate(final Long id) {
        final Estate estate = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(estate);
        return id;
    }
}
