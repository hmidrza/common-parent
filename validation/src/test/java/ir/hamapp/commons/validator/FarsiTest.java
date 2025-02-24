package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.Farsi;
import ir.hamapp.commons.validation.validator.FarsiValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(JunitNameConvention.class)
public class FarsiTest {

    @Mock
    private Farsi farsi;

    @Mock
    private ConstraintValidatorContext constraintContext;

    FarsiValidator farsiValidator;

    @BeforeEach
    public void setUp() {
        farsiValidator = new FarsiValidator();
        farsiValidator.initialize(farsi);
    }

    @ParameterizedTest
    @ValueSource(strings = {"سلام", "سلام خوبی", "", " "})
    public void Given_ValidInput_When_Verify_Then_Pass(String input) {
        assertTrue(farsiValidator.isValid(input, constraintContext));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello های", "1234", "سلام123"})
    public void Given_InvalidInput_When_Verify_Then_Fail(String input) {
        assertFalse(farsiValidator.isValid(input, constraintContext));
    }

}
