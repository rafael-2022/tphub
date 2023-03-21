package com.dieboldnixdorf.frentecaixa.domain;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * The Class XMLGregorianCalendarSerializer.
 */
public class XMLGregorianCalendarSerializer extends JsonSerializer<XMLGregorianCalendar> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void serialize(XMLGregorianCalendar value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseStrict().toFormatter();
		final LocalDateTime localDateTime = LocalDateTime.parse(value.toXMLFormat(), DateTimeFormatter.ISO_DATE_TIME);
		jgen.writeString(localDateTime.format(formatter));
	}

}
