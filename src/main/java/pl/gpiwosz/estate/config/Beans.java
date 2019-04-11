package pl.gpiwosz.estate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.gpiwosz.estate.exception.UserFoundExeption;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.model.SystemUser;
import pl.gpiwosz.estate.model.User;
import pl.gpiwosz.estate.repository.SystemUserRepository;
import pl.gpiwosz.estate.services.SystemUserService;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Beans {
    private final SystemUserRepository userRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner setupDefaultUser(SystemUserService service) {
        return args -> {
            if(userRepository.findAll().size()>0) return;
            try {
                service.save(new SystemUser(
                        new User("97022809074","Grzegorz","Piwosz","Wyciaska 79", "gpiwosz@gmail.com", 664682428L, "62 1140 2004 0000 3802 7644 0998"),
                        "user8", //username
                        "user8", //password
                        true,
                        Arrays.asList(new Role("ADMIN"))
                ));
            }
            catch(UserFoundExeption ex){

            }
        };
    }

}
