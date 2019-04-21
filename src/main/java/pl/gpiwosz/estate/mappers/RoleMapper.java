package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.RoleInput;
import pl.gpiwosz.estate.model.Role;

public class RoleMapper extends AbstractMapper{
    public static Role toEntity(final RoleInput input) {
        if (input == null) {
            return null;
        }

        Role entity = new Role();
        update(entity, input);
        return entity;
    }

    public static Role update(final Role entity, final RoleInput input) {
        entity.setName(input.getName());
        return entity;
    }

//    public static List<Role> map(final List<Long> roleIds){
//        if (roleIds == null) {
//            return null;
//        }
//        return roleIds.stream().map(id -> {
//            Role role = new Role();
//            role.setId(id);
//            return role;
//        }).collect(Collectors.toList());
//    }
}
