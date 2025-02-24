package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.VersionNumber;
import ir.hamapp.commons.validation.validator.VersionNumberValidator;
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
public class VersionNumberTest {

    @Mock
    private VersionNumber versionNumber;

    @Mock
    private ConstraintValidatorContext constraintContext;

    VersionNumberValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new VersionNumberValidator();
        validator.initialize(versionNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.0.1", "1.0.0", "121212121.123213213.123123123"})
    public void Given_ValidInput_When_Verify_Then_Pass(String input) {
        assertTrue(validator.isValid(input, constraintContext));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.1", "1", " ", "", ".", ".."})
    public void Given_InvalidInput_When_Verify_Then_Fail(String input) {
        assertFalse(validator.isValid(input, constraintContext));
    }

}
