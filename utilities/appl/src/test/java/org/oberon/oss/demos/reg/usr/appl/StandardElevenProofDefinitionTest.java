package org.oberon.oss.demos.reg.usr.appl;

import org.junit.jupiter.api.Test;
import org.oberon.oss.demos.reg.usr.utils.test.DefaultElevenProofGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardElevenProofDefinitionTest {

    @Test
    void testConstructorWithStandardElevenProofComplianceValidator() {
        var definition = new StandardElevenProofDefinition<>("test-1", List.of(5, 4, 3, 2, 1));
        assertEquals(5,definition.getWeightTable().size());
        assertEquals(5,definition.getMaximumLength());
        assertEquals(List.of(5,4,3,2,1),definition.getWeightTable());

    }

    void testConstructorWithUserSuppliedElevenProofComplianceValidator() {
        ElevenProofComplianceValidator<String> validator = new ElevenProofComplianceValidator<>() {
            @Override
            public boolean isElevenProofCompliant(String source, List<Integer> weightTable) {
                return false;
            }
        };

        var definition = new StandardElevenProofDefinition<>("test-1", List.of(5, 4, 3, 2, 1), validator);
        assertEquals(5,definition.getWeightTable().size());
        assertEquals(5,definition.getMaximumLength());
        assertEquals(List.of(5,4,3,2,1),definition.getWeightTable());
    }
}