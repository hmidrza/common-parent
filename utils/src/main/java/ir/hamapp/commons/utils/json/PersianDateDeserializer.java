package ir.hamapp.commons.utils.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ir.hamapp.commons.time.PersianDate;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class PersianDateDeserializer extends JsonDeserializer<String> {

    private static final String DATE_FORMAT = "yyyy/MM/dd";

    private static final ZoneOffset ZONE = ZoneOffset.UTC;

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            long milliseconds = p.getLongValue();

            Instant instant = Instant.ofEpochMilli(milliseconds);

            LocalDate gregorianDate = instant.atZone(ZONE).toLocalDate();

            PersianDate persianDate = PersianDate.fromGregorian(gregorianDate);

            return persianDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (Exception e) {
            return p.getValueAsString();
        }
    }

}
