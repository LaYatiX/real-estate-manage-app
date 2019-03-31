package pl.gpiwosz.estate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.gpiwosz.estate.exception.UserFoundExeption;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.model.User;
import pl.gpiwosz.estate.repository.UserRepository;
import pl.gpiwosz.estate.services.UserService;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Beans {
    private final UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            if(userRepository.findAll().size()>0) return;
            try {
                service.save(new User(
                        "user8", //username
                        "user8", //password
                        Arrays.asList(new Role("ADMIN")),
                        true,
                        "xxx","xxx","xx","xxx"
                ));
            }
            catch(UserFoundExeption ex){

            }
        };
    }
}
