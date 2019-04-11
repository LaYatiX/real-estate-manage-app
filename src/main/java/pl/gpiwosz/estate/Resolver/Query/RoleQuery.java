package pl.gpiwosz.estate.Resolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.repository.RoleRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RoleQuery implements GraphQLQueryResolver {
    private final RoleRepository repository;

    public Role getRole(Long id) {
        return repository.findById(id).get();
    }

    public List<Role> getRoles() {
        return repository.findAll();
    }
}
