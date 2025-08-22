package org.oberon.oss.demos.reg.usr.appl;

import org.jetbrains.annotations.Nullable;
import org.oberon.oss.demos.reg.usr.utils.common.BaseValidator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseValidatorRegistry {
    private static final Map<String, BaseValidator<String>> validators = new ConcurrentHashMap<>();

    public static <E extends Enum<E> & BaseValidator<String>> void registerBaseValidator(List<E> validatorList) {
        for (E validator : validatorList) {
            registerBaseValidator(validator.name(), validator);
        }
    }

    public static void registerBaseValidator(String id, BaseValidator<String> validator) {
        if (validators.containsKey(id)) {
            throw new IllegalArgumentException("Entry " + id + " is already registered");
        }
        validators.put(id, validator);
    }

    public static @Nullable BaseValidator<String> getBaseValidator(String id) {
        return validators.get(id);
    }

    static {
        for (ValidatorEnum enumeration : ValidatorEnum.values()) {
            registerBaseValidator(enumeration.name(), enumeration);
        }
    }
}
