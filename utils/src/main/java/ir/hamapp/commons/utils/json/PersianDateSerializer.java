package ir.hamapp.commons.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ir.hamapp.commons.time.PersianDate;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static ir.hamapp.commons.utils.characters.PersianToEnglishConverter.convertCharacters;

public class PersianDateSerializer extends JsonSerializer<String> {

    private static final String DATE_FORMAT = "yyyy/MM/dd";

    private static final ZoneOffset ZONE = ZoneOffset.UTC;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null || value.isEmpty()) {
            gen.writeNull();
            return;
        }

        PersianDate persianDate = PersianDate.parse(convertCharacters(value), DateTimeFormatter.ofPattern(DATE_FORMAT));
        LocalDate gregorianDate = persianDate.toGregorian();

        Instant instant = gregorianDate.atStartOfDay(ZONE).toInstant();

        long milliseconds = instant.toEpochMilli();

        gen.writeNumber(milliseconds);
    }
}
