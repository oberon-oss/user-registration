package org.oberon.oss.demos.reg.usr.appl.logic.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {BSNValidator.class})
public @interface BSN {
    String message() default "Invalid BSN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
