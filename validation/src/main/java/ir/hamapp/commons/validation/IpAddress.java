package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.IpAddressValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IpAddressValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IpAddress {
    String message() default "ip address is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
