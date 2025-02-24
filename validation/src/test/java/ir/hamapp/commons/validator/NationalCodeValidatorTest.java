package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.NationalCode;
import ir.hamapp.commons.validation.validator.NationalCodeValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(JunitNameConvention.class)
class NationalCodeValidatorTest {

    @Mock
    private NationalCode nationalCode;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    public void Given_ValidInput_When_Validate_Then_Valid() {
        // Arrange
        NationalCodeValidator nationalCodeValidator = new NationalCodeValidator();
        nationalCodeValidator.initialize(nationalCode);
        // Act & Assert
        assertTrue(nationalCodeValidator.isValid("0021320675", constraintValidatorContext));
        assertTrue(nationalCodeValidator.isValid("6840001709", constraintValidatorContext));
        assertTrue(nationalCodeValidator.isValid("0017101700", constraintValidatorContext));
    }

    @Test
    public void Given_InValidInput_When_Validate_Then_InValid() {
        // Arrange
        NationalCodeValidator nationalCodeValidator = new NationalCodeValidator();
        nationalCodeValidator.initialize(nationalCode);
        // Act & Assert
        assertFalse(nationalCodeValidator.isValid("003121320675", constraintValidatorContext));    // 12 digits, invalid
        assertFalse(nationalCodeValidator.isValid("1111111111", constraintValidatorContext));     // All same digits, invalid
        assertFalse(nationalCodeValidator.isValid(" ", constraintValidatorContext));              // Space only, invalid
        assertFalse(nationalCodeValidator.isValid(null, constraintValidatorContext));            // null, invalid
        assertFalse(nationalCodeValidator.isValid("09121234567", constraintValidatorContext));  // 11 digits, invalid
        assertFalse(nationalCodeValidator.isValid("9999999999", constraintValidatorContext));
        assertFalse(nationalCodeValidator.isValid("0000000000", constraintValidatorContext));
    }
}