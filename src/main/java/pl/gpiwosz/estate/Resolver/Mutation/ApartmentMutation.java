package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.ApartmentInput;
import pl.gpiwosz.estate.mappers.ApartmentMapper;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.repository.ApartmentRepository;
import pl.gpiwosz.estate.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class ApartmentMutation implements GraphQLMutationResolver {
    private final ApartmentRepository repository;
    private final UserRepository userRepository;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public Apartment createApartment(final ApartmentInput systemApartment) {
        return repository.save(ApartmentMapper.toEntity(systemApartment));
    }

    public Apartment updateApartment(final Long id, final ApartmentInput apartmentInput) {
        return repository.findById(id).map(apartment -> {
                    ApartmentMapper.update(apartment, apartmentInput);
                    apartment.setResidents(apartmentInput.getResidents().stream().map(userRepository::getOne).collect(Collectors.toList()));
                    return repository.save(apartment);
                }
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteApartment(final Long id) {
        final Apartment apartment = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(apartment);
        return id;
    }
}
