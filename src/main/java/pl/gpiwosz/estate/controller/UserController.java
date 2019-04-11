package pl.gpiwosz.estate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.gpiwosz.estate.model.SystemUser;
import pl.gpiwosz.estate.repository.SystemUserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final SystemUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

//    @GetMapping("/api/users")
//    public List<SystemUser> getUsers(Pageable pageable) {
//        return userRepository.findAll(pageable).getContent();
//    }
//
//    @PostMapping("/api/users")
//    public SystemUser createUser(@Valid @RequestBody SystemUser user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
}
