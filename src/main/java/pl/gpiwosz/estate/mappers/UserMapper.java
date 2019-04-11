package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.UserInput;
import pl.gpiwosz.estate.model.User;

public class UserMapper {
    public static User toEntity(final UserInput input) {
        if (input == null) {
            return null;
        }
        User entity = new User();
        return update(entity, input);
    }

    public static User update(final User entity, final UserInput input) {
        entity.setPesel(input.getPesel());
        entity.setName(input.getName());
        entity.setSurname(input.getSurname());
        entity.setAddress(input.getAddress());
        entity.setEmail(input.getEmail());
        entity.setPhone(input.getPhone());
        entity.setBankAccount(input.getBankAccount());

        return entity;
    }
}
