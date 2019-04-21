package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.model.AuditModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public abstract class AbstractMapper{
    public static <T extends AuditModel> List<T> map(final List<Long> ids, final Class<T> clazz){
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            T object = null;
            try {
                Constructor<?> ctor = clazz.getConstructor();
                object = (T)ctor.newInstance();
                object.setId(id);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            return object;
        }).collect(Collectors.toList());
    }
}
