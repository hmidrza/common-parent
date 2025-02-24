package ir.hamapp.commons.validation.validator;


import ir.hamapp.commons.validation.IranMobileNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IranMobileNumberValidator implements ConstraintValidator<IranMobileNumber, String> {

    private static final String REGEX = "^09\\d{9}$";

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if (input != null)
            return input.matches(REGEX);
        return true;
    }
}
