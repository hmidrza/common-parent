
package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.NationalCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = NationalCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NationalCode {
    String message() default "should contain 10 digits and be in the correct format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}