package com.dieboldnixdorf.frentecaixa.domain;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * The Class DataAtualSerializer.
 */
public class DataAtualSerializer extends JsonSerializer<Calendar> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void serialize(final Calendar value, final JsonGenerator jgen, final SerializerProvider provider)
			throws IOException, JsonProcessingException {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE_TIME).parseStrict().toFormatter();
		//final LocalDateTime localDateTime =LocalDateTime.of(value.get(Calendar.YEAR),value.get(Calendar.MONTH), value.get(Calendar.DAY_OF_MONTH), value.get(Calendar.HOUR_OF_DAY), value.get(Calendar.MINUTE), value.get(Calendar.SECOND));
		 TimeZone tz2 = Calendar.getInstance().getTimeZone();
        ZoneId zid = tz2 == null ? ZoneId.systemDefault() : tz2.toZoneId();
                jgen.writeString(LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), zid).toString());
	}

}
