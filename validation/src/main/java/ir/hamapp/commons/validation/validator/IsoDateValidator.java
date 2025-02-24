package ir.hamapp.commons.validation.validator;


import ir.hamapp.commons.validation.IsoDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsoDateValidator implements ConstraintValidator<IsoDate, String> {

    private static final String REGEX = "^(\\d{4})-(\\d{2})-(\\d{2})$";

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if (input != null)
            return input.matches(REGEX);
        return true;
    }
}
