package pl.gpiwosz.estate.Resolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.User;
import pl.gpiwosz.estate.repository.UserRepository;

import java.util.List;


@RequiredArgsConstructor
@Component
public class UserQuery implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    public User getUser(String name) {
        return userRepository.findByUsername(name).get();
    }
}