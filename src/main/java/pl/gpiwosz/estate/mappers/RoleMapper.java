package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.RoleInput;
import pl.gpiwosz.estate.model.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {
    public static Role toEntity(final RoleInput input) {
        if (input == null) {
            return null;
        }

        Role entity = new Role();
        entity.setName(input.getName());
        return entity;
    }

    public static List<Role> map(final List<Long> roleIds){
        if (roleIds == null) {
            return null;
        }
        return roleIds.stream().map(id -> {
            Role role = new Role();
            role.setId(id);
            return role;
        }).collect(Collectors.toList());
    }
}
