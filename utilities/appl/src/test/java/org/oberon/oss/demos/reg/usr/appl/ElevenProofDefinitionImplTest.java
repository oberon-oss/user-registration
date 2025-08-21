package org.oberon.oss.demos.reg.usr.appl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.oberon.oss.demos.reg.usr.appl.ElevenProofDefinitionImplTest.TestValidatorEnum.TEST_1;

class ElevenProofDefinitionImplTest {
    private static final int[] array = new int[]{56, 77, 33, -1, -20};

    private ElevenProofDefinitionImpl<TestValidatorEnum> definition;

    @BeforeEach
    void setUp() {
        definition = new ElevenProofDefinitionImpl<>(TEST_1, array);
    }

    @Test
    void testConstructorWithNull() {
        assertThrows(NullPointerException.class, () -> new ElevenProofDefinitionImpl<>(null, array));
    }

    @Test
    void testConstructorWithNullArray() {
        assertThrows(NullPointerException.class, () -> new ElevenProofDefinitionImpl<>(TEST_1, null));
    }

    @Test
    void testValidatorIsPresent() {
        ElevenProofValidator<String> validator = definition.getValidator();
        assertNotNull(validator);
    }

    @Test
    void testValidatorWithNull() {
        ElevenProofValidator<String> validator = definition.getValidator();
        Exception exception = assertThrows(NullPointerException.class, () -> validator.isValid(null));
        assertEquals("source cannot be null", exception.getMessage());
    }

    @Test
    void testValidatorWithInvalidArgument() {
        ElevenProofValidator<String> validator = definition.getValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValid("1"));
        assertEquals(1 + " is invalid, expected length=" + array.length, exception.getMessage());
    }


    enum TestValidatorEnum implements ElevenProofDefinition<String, ValidatorEnum> {
        TEST_1();

        @Override
        public ValidatorEnum getDefinitionID() {
            return null;
        }

        @Override
        public List<Integer> getWeighTable() {
            return List.of();
        }

        @Override
        public int getMaximumLength() {
            return 0;
        }

        @Override
        public ElevenProofValidator<String> getValidator() {
            return null;
        }
    }
}