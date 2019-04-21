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
import pl.gpiwosz.estate.repository.RoleRepository;
import pl.gpiwosz.estate.repository.SystemUserRepository;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class SystemUserMutation implements GraphQLMutationResolver {
    private final SystemUserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public SystemUser createSystemUser(SystemUserInput systemUser) {
        return repository.save(new SystemUser(
                UserMapper.toEntity(systemUser.getUser()),
                systemUser.getUsername(),
                passwordEncoder.encode(systemUser.getPassword()),
                systemUser.getActive(),
                RoleMapper.map(systemUser.getRoles(), Role.class)
        ));
    }

    public SystemUser updateSystemUser(final Long id, final SystemUserInput systemUserInput) {
        systemUserInput.setPassword(passwordEncoder.encode(systemUserInput.getPassword()));
        return repository.findById(id).map(systemUser -> {
                    SystemUserMapper.update(systemUser, systemUserInput);
                    systemUser.setRoles(systemUserInput.getRoles().stream().map(roleRepository::getOne).collect(Collectors.toList()));
                    return repository.save(systemUser);
                }
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteSystemUser(final Long id) {
        final SystemUser user = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(user);
        return id;
    }
}