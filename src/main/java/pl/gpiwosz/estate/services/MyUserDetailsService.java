package pl.gpiwosz.estate.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.gpiwosz.estate.repository.UserRepository;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByUsername(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getUsername(),
                        u.getPassword(),
                        u.getActive(),
                        u.getActive(),
                        u.getActive(),
                        u.getActive(),
                        AuthorityUtils.createAuthorityList(
                                u.getRoles()
                                        .stream()
                                        .map(r -> "ROLE_" + r.getName().toUpperCase())
                                        .collect(Collectors.toList())
                                        .toArray(new String[]{}))))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }
}
