package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.exception.ApiException;
import pl.gpiwosz.estate.inputs.UserInput;
import pl.gpiwosz.estate.mappers.UserMapper;
import pl.gpiwosz.estate.model.User;
import pl.gpiwosz.estate.repository.UserRepository;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {
    private final UserRepository repository;

    private final String NOT_FOUND = "Obiekt o podanym id nie istnieje.";

    public User createUser(final UserInput systemUser) {
        return repository.save(UserMapper.toEntity(systemUser));
    }

    public User updateUser(final Long id, final UserInput userInput) {
        return repository.findById(id).map(user -> {
                    UserMapper.update(user, userInput);
                    return repository.save(user);
                }
        ).orElseThrow(() -> new ApiException(NOT_FOUND));
    }

    public Long deleteUser(final Long id) {
        final User user = repository.findById(id).orElseThrow(() -> new ApiException(NOT_FOUND));
        repository.delete(user);
        return id;
    }
}
