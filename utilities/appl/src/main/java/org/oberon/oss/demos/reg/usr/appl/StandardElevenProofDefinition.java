package org.oberon.oss.demos.reg.usr.appl;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.demos.reg.usr.utils.common.BaseValidator;

import java.util.List;

@Getter
public class StandardElevenProofDefinition<I> implements ElevenProofDefinition<String, I> {
    private final I definitionID;
    private final BaseValidator<String> validator;
    private final List<Integer> weightTable;


    private static final ElevenProofComplianceValidator<String> DEFAULT_ELEVEN_PROOF_COMPLIANCE_VALIDATOR = (source, weightTable) -> {
        if (source == null) {
            throw new NullPointerException("source cannot be null");
        }

        if (source.length() != weightTable.size()) {
            throw new IllegalArgumentException(source.length() + " is invalid, expected length=" + weightTable.size());
        }
        int sum = 0;
        for (int i = 0; i < source.length(); i++) {
            int digit = Integer.parseInt(source.substring(i, i + 1));
            sum += (digit * weightTable.get(i));
        }
        return sum % 11 == 0;
    };

    /**
     * Creates an instance of the {@link ElevenProofComplianceValidator} interface using a user provided
     * {@link ElevenProofComplianceValidator}.
     *
     * @param definitionID        The ID to associate with
     * @param weightTable         The weight table to use when validating input data.
     * @param complianceValidator The user provided complianceValidator to be used.
     *
     * @since 1.0.0
     */
    public StandardElevenProofDefinition(@NotNull I definitionID, @NotNull List<Integer> weightTable, @NotNull ElevenProofComplianceValidator<String> complianceValidator) {
        this.definitionID = definitionID;
        this.weightTable = List.copyOf(weightTable);
        validator = source -> complianceValidator.isElevenProofCompliant(source, this.weightTable);
    }

    /**
     * Creates an instance of the {@link ElevenProofComplianceValidator} interface using a default
     * {@link ElevenProofComplianceValidator} instance.
     *
     * @param definitionID The ID to associate with
     * @param weightTable  The weight table to use when validating input data.
     *
     * @since 1.0.0
     */
    public StandardElevenProofDefinition(@NotNull I definitionID, @NotNull List<Integer> weightTable) {
        this(definitionID, weightTable, DEFAULT_ELEVEN_PROOF_COMPLIANCE_VALIDATOR);
    }

    @Override
    public int getMaximumLength() {
        return weightTable.size();
    }
}
