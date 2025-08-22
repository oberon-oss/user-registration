package org.oberon.oss.demos.reg.usr.appl;

import java.util.List;

/**
 * Validates the provided data to be compliant with the eleven proof.
 *
 * @param <S> The type of object that contains the data to be validated
 *
 * @author TigerLilly64
 * @since 0.0.1
 */
@FunctionalInterface
public interface ElevenProofComplianceValidator<S> {
    /**
     * Validates the provided 'source' and returns a boolean indicating if it was valid or not.
     *
     * @param source      The source data to be validated
     * @param weightTable array containing the weight table to apply when validating
     *
     * @return <b>True</b> if the data is valid, or <b>false</b> if not.
     *
     * @since 1.0.0
     */
    boolean isElevenProofCompliant(String source, final List<Integer> weightTable);
}
