package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.IsoDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsoDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsoDate {
    String message() default "date is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
