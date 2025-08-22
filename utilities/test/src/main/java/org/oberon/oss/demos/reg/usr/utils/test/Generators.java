package org.oberon.oss.demos.reg.usr.utils.test;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.oberon.oss.demos.reg.usr.utils.common.BaseValidator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    private static final Map<String,ElevenProofGenerator<String,Integer>> GENERATOR_MAP = new ConcurrentHashMap<>();

    public static void registerGenerator(@NotNull String id, int lowerBound, int higherBound, BaseValidator<String> validator) {
        GENERATOR_MAP.putIfAbsent(id, new DefaultElevenProofGenerator(lowerBound, higherBound, validator));
    }

    public static @Nullable ElevenProofGenerator<String,Integer> getGenerator(@NotNull String id) {
        return GENERATOR_MAP.get(id);
    }

}
