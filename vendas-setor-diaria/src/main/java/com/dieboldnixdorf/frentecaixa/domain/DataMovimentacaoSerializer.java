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

/**
 * The Class DataMovimentacaoSerializer.
 */
public class DataMovimentacaoSerializer extends JsonSerializer<Calendar> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void serialize(final Calendar value, final JsonGenerator jgen, final SerializerProvider provider)
			throws IOException, JsonProcessingException {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE_TIME).parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(value.get(Calendar.YEAR),value.get(Calendar.MONTH) + 1, value.get(Calendar.DAY_OF_MONTH), value.get(Calendar.HOUR_OF_DAY), value.get(Calendar.MINUTE), 0);
		jgen.writeString(localDateTime.format(formatter));
	}

}
