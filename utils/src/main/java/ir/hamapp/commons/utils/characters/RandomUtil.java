package ir.hamapp.commons.utils.characters;

import java.util.Random;

public final class RandomUtil {

    public static String generateRandomNumbersByLength(int length) {
        String characters = "0123456789";
        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return stringBuilder.toString();
    }

}
