package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.RoleInput;
import pl.gpiwosz.estate.mappers.RoleMapper;
import pl.gpiwosz.estate.mappers.UserMapper;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.repository.RoleRepository;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class RoleMutation implements GraphQLMutationResolver {
    private final RoleRepository repository;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public Role createRole(final RoleInput systemRole) {
        return repository.save(RoleMapper.toEntity(systemRole));
    }

    public Role updateRole(final Long id, final RoleInput systemRole) {
        return repository.findById(id).map(role -> {
                    RoleMapper.update(role, systemRole);
                    return repository.save(role);
                }
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteRole(final Long id) {
        final Role role = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(role);
        return id;
    }
}
