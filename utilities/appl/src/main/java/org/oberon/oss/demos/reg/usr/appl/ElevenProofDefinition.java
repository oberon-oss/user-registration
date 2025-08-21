package org.oberon.oss.demos.reg.usr.appl;

import java.util.List;

/**
 * Defines the operational attributes for any eleven test based validation
 *
 * @param <S> The type of object that contains the data to be validated
 * @param <E> The enum who's members will act as IDs
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface ElevenProofDefinition<S, E extends Enum<E>> {
    /**
     * Returns the ID for an eleven proof definition
     *
     * @return the ID for the instance.
     *
     * @since 1.0.0
     */
    E getDefinitionID();

    /**
     * Returns the weight table used by the eleven proof definition.
     *
     * @return The weight table, as an array of integers
     *
     * @since 1.0.0
     */
    List<Integer> getWeighTable();

    /**
     * returns the maximum length of the data object that can be analyzed.
     *
     * @return The maximum data length allowed.
     *
     * @since 1.0.0
     */
    int getMaximumLength();

    /**
     * Returns a validator that can be used to validate data to be valid according to the implemented eleven proof.
     *
     * @return An instance of the {@link ElevenProofValidator} interface to be used for validation.
     *
     * @since 1.0.0
     */
    ElevenProofValidator<S> getValidator();
}
