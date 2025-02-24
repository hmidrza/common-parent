package ir.hamapp.commons.utils.test;

import java.util.List;
import java.util.Optional;

public class SimpleJunitNameFormatter implements JunitNameFormatter {

    private final List<String> methodNameParts;

    private String output;

    private SimpleJunitNameFormatter(List<String> methodNameParts) {
        this.methodNameParts = methodNameParts;
    }

    public static SimpleJunitNameFormatter from(List<String> methodNameParts) {
        return new SimpleJunitNameFormatter(methodNameParts);
    }

    @Override
    public String format() {
        return createNameByParts().orElse("");
    }

    private Optional<String> createNameByParts() {
        switch (methodNameParts.size()) {
            case 4: formatFourPartsName(); break;
            case 6: formatSixPartsName(); break;
            default: throw new IllegalArgumentException("Format is not supported.");
        }
        return Optional.of(output);
    }

    private void formatSixPartsName() {
        var format = "(%s) -> [%s] => <%s>";
        output = String.format(format,
                methodNameParts.get(1),
                methodNameParts.get(3),
                methodNameParts.get(5));
    }

    private void formatFourPartsName() {
        var format = "[%s] => <%s>";
        output = String.format(format,
                methodNameParts.get(1),
                methodNameParts.get(3),
                methodNameParts.get(1));
    }

}
