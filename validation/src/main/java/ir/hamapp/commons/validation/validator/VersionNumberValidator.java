package ir.hamapp.commons.validation.validator;

import ir.hamapp.commons.validation.VersionNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VersionNumberValidator implements ConstraintValidator<VersionNumber, String> {

    private static final String REGEX = "^(\\d+\\.)(\\d+\\.)(\\*|\\d+)$";

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if (input != null)
            return input.matches(REGEX);
        return true;
    }
}
