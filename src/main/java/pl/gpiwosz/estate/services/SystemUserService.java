package pl.gpiwosz.estate.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gpiwosz.estate.model.SystemUser;
import pl.gpiwosz.estate.repository.SystemUserRepository;

@Service
@RequiredArgsConstructor
public class SystemUserService {
    private final SystemUserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public void save(SystemUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

}