package ir.hamapp.commons.utils.test;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JunitNameConvention extends DisplayNameGenerator.Standard {

    private String splitToParts(String input) {
        var methodNameParts = getTestNameParts(input);
        JunitNameFormatter nameFormatter = SimpleJunitNameFormatter.from(methodNameParts);
        try {
            return nameFormatter.format();
        } catch (IllegalArgumentException e) {
            return input;
        }
    }

    private List<String> getTestNameParts(String input) {

        List<String> stringParts = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {

            char ch = input.charAt(i);

            if (ch == '(') {
                break;
            }

            if (ch == '_') {
                stringParts.add(sb.toString());
                sb.setLength(0);
            } else if (Character.isUpperCase(ch) && stringParts.size() > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }
        stringParts.add(sb.toString());

        return stringParts;
    }


    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return splitToParts(
                super.generateDisplayNameForMethod(testClass, testMethod)
        );
    }

}
