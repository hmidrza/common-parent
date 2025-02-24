package ir.hamapp.commons.validator;

import ir.hamapp.commons.utils.test.JunitNameConvention;
import ir.hamapp.commons.validation.IpAddress;
import ir.hamapp.commons.validation.validator.IpAddressValidator;
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
public class IpAddressTest {

    @Mock
    private IpAddress ipAddress;

    @Mock
    private ConstraintValidatorContext constraintContext;

    IpAddressValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new IpAddressValidator();
        validator.initialize(ipAddress);
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.1.100", "0.0.0.0", "255.255.255.255"})
    public void Given_ValidInput_When_Verify_Then_Pass(String input) {
        assertTrue(validator.isValid(input, constraintContext));
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.1.256", "", " "})
    public void Given_InvalidInput_When_Verify_Then_Fail(String input) {
        assertFalse(validator.isValid(input, constraintContext));
    }

}
