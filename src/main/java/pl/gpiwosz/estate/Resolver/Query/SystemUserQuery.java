package pl.gpiwosz.estate.Resolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.SystemUser;
import pl.gpiwosz.estate.repository.SystemUserRepository;

import java.util.List;


@RequiredArgsConstructor
@Component
public class SystemUserQuery implements GraphQLQueryResolver {
    private final SystemUserRepository repository;

    public SystemUser getSystemUser(Long id) {
        return repository.findById(id).get();
    }

    public List<SystemUser> getSystemUsers() {
        return repository.findAll();
    }
}