package org.oberon.oss.demos.reg.usr.appl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ElevenProofDefinitionImpl<E extends Enum<E>> implements ElevenProofDefinition<String, E> {
    private final E definitionID;
    private final ElevenProofValidator<String> validator;
    private final List<Integer> storedWeightTable;

    public ElevenProofDefinitionImpl(E definitionID, int[] weightTable) {
        if (definitionID == null) {
            throw new NullPointerException("parameter definitionID: cannot be null");
        }

        if (weightTable == null) {
            throw new NullPointerException("parameter weightTable: cannot be null");
        }

        this.definitionID = definitionID;
        storedWeightTable = Arrays.stream(weightTable).boxed().collect(Collectors.toList());

        validator = ( source) -> {
            if (source == null) {
                throw new NullPointerException("source cannot be null");
            }

            if (source.length() != weightTable.length) {
                throw new IllegalArgumentException(source.length() + " is invalid, expected length=" + weightTable.length);
            }
            int sum = 0;
            for (int i = 0; i < source.length(); i++) {
                int digit = Integer.parseInt(source.substring(i, i + 1));
                sum += (digit * weightTable[i]);
            }
            return sum % 11 == 0;
        };
    }

    @Override
    public E getDefinitionID() {
        return definitionID;
    }

    @Override
    public List<Integer> getWeighTable() {
        return storedWeightTable;
    }

    @Override
    public int getMaximumLength() {
        return storedWeightTable.size();
    }

    @Override
    public ElevenProofValidator<String> getValidator() {
        return validator;
    }
}
