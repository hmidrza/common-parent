package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.IranMobileNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IranMobileNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IranMobileNumber {
    String message() default "mobile number is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
