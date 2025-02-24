package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.IranMobileNumber;
import ir.hamapp.commons.validation.validator.IranMobileNumberValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(JunitNameConvention.class)
public class IranMobileNumberTest {

    @Mock
    private IranMobileNumber iranMobileNumber;

    @Mock
    private ConstraintValidatorContext constraintContext;

    IranMobileNumberValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new IranMobileNumberValidator();
        validator.initialize(iranMobileNumber);
    }

    @Test
    public void Given_ValidInput_When_Verify_Then_Pass() {
        assertTrue(validator.isValid("09123108587", constraintContext));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "+989121234567", "00989123108587", "9123108587"})
    public void Given_InvalidInput_When_Verify_Then_Fail(String input) {
        assertFalse(validator.isValid(input, constraintContext));
    }

}
