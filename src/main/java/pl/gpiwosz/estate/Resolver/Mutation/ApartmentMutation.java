package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.ApartmentInput;
import pl.gpiwosz.estate.mappers.ApartmentMapper;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.repository.ApartmentRepository;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ApartmentMutation implements GraphQLMutationResolver {
    private final ApartmentRepository repository;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public Apartment createApartment(final ApartmentInput systemApartment) {
        return repository.save(ApartmentMapper.toEntity(systemApartment));
    }

    public Apartment updateApartment(final Long id, final ApartmentInput systemApartment) {
        return repository.findById(id).map(apartment ->
                repository.save(ApartmentMapper.toEntity(systemApartment))
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteApartment(final Long id) {
        final Apartment apartment = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(apartment);
        return id;
    }
}
