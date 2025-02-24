
package ir.hamapp.commons.validation.validator;

import ir.hamapp.commons.validation.NationalCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 * Validates if only 10 digits are exist.
 * null is invalid.
 * must be in a correct format.
 *
 * @author mahdi safari
 */
public class NationalCodeValidator implements ConstraintValidator<NationalCode, String> {
    private static final String NATIONAL_CODE_REGEX = "^(?!.*(\\d)\\1{9})\\d{10}$";
    @Override
    public void initialize(NationalCode nationalCode) {
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext cxt) {
        if (input != null) return input.matches(NATIONAL_CODE_REGEX);
        return false;
    }
}