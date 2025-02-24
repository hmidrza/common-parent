package ir.hamapp.commons.validation;

import ir.hamapp.commons.validation.validator.PortValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PortValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Port {
    String message() default "port is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
