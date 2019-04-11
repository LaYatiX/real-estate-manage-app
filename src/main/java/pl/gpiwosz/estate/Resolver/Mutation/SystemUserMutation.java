package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.SystemUserInput;
import pl.gpiwosz.estate.mappers.RoleMapper;
import pl.gpiwosz.estate.mappers.SystemUserMapper;
import pl.gpiwosz.estate.mappers.UserMapper;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.model.SystemUser;
import pl.gpiwosz.estate.repository.SystemUserRepository;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class SystemUserMutation implements GraphQLMutationResolver {
    private final SystemUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public SystemUser createSystemUser(SystemUserInput systemUser) {
        return repository.save(new SystemUser(
                UserMapper.toEntity(systemUser.getUser()),
                systemUser.getUsername(),
                passwordEncoder.encode(systemUser.getPassword()),
                systemUser.getActive(),
                RoleMapper.map(systemUser.getRoles())
        ));
    }

    public SystemUser updateSystemUser(final Long id, final SystemUserInput systemUserInput) {
        systemUserInput.setPassword(passwordEncoder.encode(systemUserInput.getPassword()));
        return repository.findById(id).map(user ->
                repository.save(SystemUserMapper.toEntity(systemUserInput))
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteSystemUser(final Long id) {
        final SystemUser user = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(user);
        return id;
    }
}