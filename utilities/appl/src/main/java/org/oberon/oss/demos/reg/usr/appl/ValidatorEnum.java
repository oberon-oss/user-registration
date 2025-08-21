package org.oberon.oss.demos.reg.usr.appl;

import java.util.List;

/**
 * Provides validations.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public enum ValidatorEnum implements ElevenProofDefinition<String, ValidatorEnum> {
    BSN(new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1});

    private final ElevenProofDefinition<String, ValidatorEnum> definition;

    ValidatorEnum(int[] weightTable) {
        definition = new ElevenProofDefinitionImpl<>(this, weightTable);
    }

    @Override
    public ValidatorEnum getDefinitionID() {
        return this;
    }

    @Override
    public List<Integer> getWeighTable() {
        return definition.getWeighTable();
    }

    @Override
    public int getMaximumLength() {
        return definition.getMaximumLength();
    }

    @Override
    public ElevenProofValidator<String> getValidator() {
        return definition.getValidator();
    }
}
