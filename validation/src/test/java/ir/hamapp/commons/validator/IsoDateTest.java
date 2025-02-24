package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.IsoDate;
import ir.hamapp.commons.validation.validator.IsoDateValidator;
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
public class IsoDateTest {

    @Mock
    private IsoDate isoDate;

    @Mock
    private ConstraintValidatorContext constraintContext;

    IsoDateValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new IsoDateValidator();
        validator.initialize(isoDate);
    }

    @Test
    public void Given_ValidInput_When_Verify_Then_Pass() {
        assertTrue(validator.isValid("2024-09-09", constraintContext));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2024/04/04", "2024/04/04T10:55", "2024/04/04T10:55:55", " ", ""})
    public void Given_InvalidInput_When_Verify_Then_Fail(String input) {
        assertFalse(validator.isValid(input, constraintContext));
    }

}
