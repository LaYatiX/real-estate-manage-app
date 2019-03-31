package pl.gpiwosz.estate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.gpiwosz.estate.model.User;
import pl.gpiwosz.estate.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/api/users")
    public List<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @PostMapping("/api/users")
    public User createUser(@Valid @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
