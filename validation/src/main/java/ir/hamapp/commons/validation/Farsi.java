package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.FarsiValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FarsiValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Farsi {
    String message() default "only farsi characters allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
