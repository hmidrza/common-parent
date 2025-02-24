package ir.hamapp.commons.validation.validator;

import ir.hamapp.commons.validation.Port;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PortValidator implements ConstraintValidator<Port, Integer> {

    private static final String REGEX = "^([1-9][0-9]{0,3}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$";

    @Override
    public boolean isValid(Integer input, ConstraintValidatorContext constraintValidatorContext) {
        if (input != null)
            return input.toString().matches(REGEX);
        return true;
    }
}
