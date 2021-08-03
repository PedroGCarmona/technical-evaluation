package br.com.pedrocarmona.testbackend.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimestampDeserializer extends JsonDeserializer<LocalDateTime>{

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String unixTimestamp = parser.getText().trim();
        Date dateValue = new Date(TimeUnit.SECONDS.toMillis(Long.valueOf(unixTimestamp)));
        LocalDateTime localDateTimeValue = dateValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTimeValue;
    }

}
