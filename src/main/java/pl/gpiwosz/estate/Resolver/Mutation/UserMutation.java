package pl.gpiwosz.estate.Resolver.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.model.User;

@Component
public class UserMutation implements GraphQLMutationResolver {

    public User createUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }
}