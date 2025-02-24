package ir.hamapp.commons.utils.characters;

import java.util.HashMap;
import java.util.Map;

public final class PersianToEnglishConverter {

    public static String convertCharacters(String input) {
        Map<Character, Character> persianToEnglishMap = getCharacterCharacterMap();

        StringBuilder converted = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (persianToEnglishMap.containsKey(c)) {
                converted.append(persianToEnglishMap.get(c));
            } else {
                converted.append(c);
            }
        }

        return converted.toString();
    }

    private static Map<Character, Character> getCharacterCharacterMap() {
        Map<Character, Character> persianToEnglishMap = new HashMap<>();
        persianToEnglishMap.put('۰', '0');
        persianToEnglishMap.put('۱', '1');
        persianToEnglishMap.put('۲', '2');
        persianToEnglishMap.put('۳', '3');
        persianToEnglishMap.put('۴', '4');
        persianToEnglishMap.put('۵', '5');
        persianToEnglishMap.put('۶', '6');
        persianToEnglishMap.put('۷', '7');
        persianToEnglishMap.put('۸', '8');
        persianToEnglishMap.put('۹', '9');
        return persianToEnglishMap;
    }
}
