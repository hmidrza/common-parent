package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.Port;
import ir.hamapp.commons.validation.validator.PortValidator;
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
public class PortTest {

    @Mock
    private Port port;

    @Mock
    private ConstraintValidatorContext constraintContext;

    PortValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PortValidator();
        validator.initialize(port);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 65_535, 80})
    public void Given_ValidInput_When_Verify_Then_Pass(Integer input) {
        assertTrue(validator.isValid(input, constraintContext));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 65_536})
    public void Given_InvalidInput_When_Verify_Then_Fail(Integer input) {
        assertFalse(validator.isValid(input, constraintContext));
    }

}
