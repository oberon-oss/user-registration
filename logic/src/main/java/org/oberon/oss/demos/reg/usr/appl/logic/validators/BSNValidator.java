package org.oberon.oss.demos.reg.usr.appl.logic.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.oberon.oss.demos.reg.usr.appl.ValidatorEnum;

/**
 * Performs validation of BSN (burger service nummer) fields.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public class BSNValidator implements ConstraintValidator<BSN, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidatorEnum.BSN.isValid(value);
    }
}
