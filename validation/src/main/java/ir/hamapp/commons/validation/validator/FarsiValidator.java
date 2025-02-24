package ir.hamapp.commons.validation.validator;

import ir.hamapp.commons.validation.Farsi;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FarsiValidator implements ConstraintValidator<Farsi, String> {

    private static final String REGEX = "^[\\u0600-\\u06FF\\uFB8A\\u067E\\u0686\\u06AF7\\u200C\\u200F ]+$";

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        return input == null || input.isBlank() || input.trim().matches(REGEX);
    }
}
