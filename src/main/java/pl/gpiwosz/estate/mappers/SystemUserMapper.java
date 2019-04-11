package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.SystemUserInput;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.model.SystemUser;
import pl.gpiwosz.estate.model.User;

import java.util.stream.Collectors;

public class SystemUserMapper {
    public static SystemUser toEntity(final SystemUserInput input) {
        if (input == null) {
            return null;
        }
        SystemUser entity = new SystemUser();
        entity.setUser(UserMapper.toEntity(input.getUser()));
        entity.setUsername(input.getUsername());
        entity.setPassword(input.getPassword());
        entity.setRoles(input.getRoles().stream().map(id -> {
            Role role = new Role();
            role.setId(id);
            return role;
        }).collect(Collectors.toList()));

        return entity;
    }
}
