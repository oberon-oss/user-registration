package org.oberon.oss.demos.reg.usr.utils.test;

import lombok.extern.log4j.Log4j2;
import org.oberon.oss.demos.reg.usr.utils.common.BaseValidator;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Default {@link ElevenProofGenerator} implementation, using {@link Integer} to describe the boundaries, and generates
 * objects of type {@link String}
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@Log4j2
public class DefaultElevenProofGenerator implements ElevenProofGenerator<String, Integer> {
    private final int lowerBound;
    private final int upperBound;
    private final BaseValidator<String> validator;
    private final Random random;

    /**
     * Constructs a new generator using a user supplied randomGenerator generator.
     *
     * @param randomGenerator The user supplied generator
     * @param lowerBound      The lower bound (inclusive) of the generated data.
     * @param upperBound      The upper bound (inclusive) of the generated data.
     * @param validator       The validator to use to determine if generated value(s) are valid or not.
     *
     * @since 1.0.0
     */
    public DefaultElevenProofGenerator(Random randomGenerator, int lowerBound, int upperBound, BaseValidator<String> validator) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.validator = validator;
        this.random = randomGenerator;
    }

    /**
     * Constructs a new generator using an instance of {@link SecureRandom} generator.
     *
     * @param lowerBound The lower bound (inclusive) of the generated data.
     * @param upperBound The upper bound (inclusive) of the generated data.
     * @param validator  The validator to use to determine if generated value(s) are valid or not.
     *
     * @since 1.0.0
     */
    public DefaultElevenProofGenerator(int lowerBound, int upperBound, BaseValidator<String> validator) {
        this(new SecureRandom(), lowerBound, upperBound, validator);
    }

    @Override
    public Integer getLowerBound() {
        return lowerBound;
    }

    @Override
    public Integer getUpperBound() {
        return upperBound;
    }

    @Override
    public String generateSingleValue(boolean generateValidItem) {
        String bsn;
        do {
            bsn = String.format("%09d", random.nextInt(lowerBound, upperBound + 1));
        } while ((generateValidItem != validator.isValid(bsn)));

        LOGGER.debug("{} bsn: {}", generateValidItem ? "valid" : "invalid", bsn);
        return bsn;
    }

    @Override
    public List<String> generateValueList(int count, boolean generateValidItems) {
        List<String> result = new ArrayList<>();

        while (result.size() != count) {
            result.add(generateSingleValue(generateValidItems));
        }
        return result;
    }
}
