package org.oberon.oss.demos.reg.usr.utils.test;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static org.oberon.oss.demos.reg.usr.appl.ValidatorEnum.BSN;

/**
 * Data generators for testing purposes.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@Log4j2
public class Generators {
    public static final int MIN_BSN_NUMBER = 10_000_000;
    public static final int MAX_BSN_NUMBER = 999_999_999;

    @Getter
    private final ElevenProofGenerator<String, Integer> bsnNumberGenerator;

    {
        bsnNumberGenerator = new DefaultElevenProofGenerator(MIN_BSN_NUMBER, MAX_BSN_NUMBER, BSN.getValidator());
    }

}
