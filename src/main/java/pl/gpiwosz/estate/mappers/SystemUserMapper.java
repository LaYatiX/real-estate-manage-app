package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.SystemUserInput;
import pl.gpiwosz.estate.model.Role;
import pl.gpiwosz.estate.model.SystemUser;

public class SystemUserMapper extends AbstractMapper{
    public static SystemUser toEntity(final SystemUserInput input) {
        if (input == null) {
            return null;
        }
        SystemUser entity = new SystemUser();
        return update(entity, input);
    }

    public static SystemUser update(final SystemUser entity, final SystemUserInput input) {
        entity.setUser(UserMapper.toEntity(input.getUser()));
        entity.setUsername(input.getUsername());
        entity.setPassword(input.getPassword());

        return entity;
    }
    
//    public static List<SystemUser> map(final List<Long> systemUserIds){
//        if (systemUserIds == null) {
//            return null;
//        }
//        return systemUserIds.stream().map(id -> {
//            SystemUser systemUser = new SystemUser();
//            systemUser.setId(id);
//            return systemUser;
//        }).collect(Collectors.toList());
//    }
}
