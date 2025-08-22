package org.oberon.oss.demos.reg.usr.appl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.oberon.oss.demos.reg.usr.utils.test.ElevenProofGenerator;
import org.oberon.oss.demos.reg.usr.utils.test.Generators;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class GeneratorsTest {
    public static final int MIN_BSN_NUMBER = 10_000_000;
    public static final int MAX_BSN_NUMBER = 999_999_999;

    private static SecureRandom random;
    private static final int LOW_BOUND = 30;
    private static final int HIGH_BOUND = 60;

    @BeforeAll
    static void setup() {
        random = new SecureRandom();
        random.setSeed(System.currentTimeMillis());
        Generators.registerGenerator("BSN", MIN_BSN_NUMBER, MAX_BSN_NUMBER, ValidatorEnum.BSN);
    }

    private static Stream<Arguments> getArguments(boolean generateValidNumber) {
        ElevenProofGenerator<String, Integer> generator = Generators.getGenerator("BSN");
        List<String> strings = generator.generateValueList(random.nextInt(LOW_BOUND, HIGH_BOUND), generateValidNumber);

        assertTrue(strings.size() >= LOW_BOUND && strings.size() <= HIGH_BOUND);

        List<Arguments> arguments = new ArrayList<>();
        for (String bsn : strings) {
            arguments.add(Arguments.of(bsn));
        }
        return arguments.stream();
    }

    private static Stream<Arguments> testValidGeneratedNumbers() {
        return getArguments(true);
    }

    private static Stream<Arguments> testInvalidGeneratedNumbers() {
        return getArguments(false);
    }


    @ParameterizedTest
    @MethodSource
    void testValidGeneratedNumbers(String bsnNumber) {
        assertTrue(ValidatorEnum.BSN.isValid(bsnNumber));
    }

    @ParameterizedTest
    @MethodSource
    void testInvalidGeneratedNumbers(String bsnNumber) {
        assertFalse(ValidatorEnum.BSN.isValid(bsnNumber));
    }
}