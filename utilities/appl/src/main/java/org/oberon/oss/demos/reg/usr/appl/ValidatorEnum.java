package org.oberon.oss.demos.reg.usr.appl;

import org.oberon.oss.demos.reg.usr.utils.common.BaseValidator;

import java.util.List;

/**
 * Provides validations.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public enum ValidatorEnum implements BaseValidator<String> {
    BSN(List.of(9, 8, 7, 6, 5, 4, 3, 2, -1));

    private final StandardElevenProofDefinition<ValidatorEnum> definition;

    ValidatorEnum(List<Integer> weightTable) {
        definition = new StandardElevenProofDefinition<>(this, weightTable);
    }

    @Override
    public boolean isValid(String source) {
        return definition.getValidator().isValid(source);
    }
}
