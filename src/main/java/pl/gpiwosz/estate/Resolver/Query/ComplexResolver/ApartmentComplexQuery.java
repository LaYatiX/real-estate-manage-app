package pl.gpiwosz.estate.Resolver.Query.ComplexResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.model.User;
import pl.gpiwosz.estate.repository.ApartmentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApartmentComplexQuery implements GraphQLResolver<Apartment> {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public List<User> residents(Apartment apartment){
        return apartmentRepository.findById(apartment.getId()).get().getResidents();
    }
}
