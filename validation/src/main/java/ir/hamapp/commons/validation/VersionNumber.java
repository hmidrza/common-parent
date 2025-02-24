package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.VersionNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VersionNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionNumber {
    String message() default "version format is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
