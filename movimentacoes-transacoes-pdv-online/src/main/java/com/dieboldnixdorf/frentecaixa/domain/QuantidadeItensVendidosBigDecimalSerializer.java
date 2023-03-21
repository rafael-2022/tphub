package com.dieboldnixdorf.frentecaixa.domain;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * The Class QuantidadeItensVendidosBigDecimalSerializer.
 */
public class QuantidadeItensVendidosBigDecimalSerializer extends JsonSerializer<BigDecimal> {

	/** The Constant CONTEXT. */
	public static final MathContext CONTEXT = new MathContext(10, RoundingMode.DOWN);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void serialize(final BigDecimal value, final JsonGenerator jgen, final SerializerProvider provider)
			throws IOException, JsonProcessingException {
    	final BigDecimal newValue = new BigDecimal(value.toString(), CONTEXT);
    	final DecimalFormat formatter = new DecimalFormat("#0.000");
		jgen.writeString(formatter.format(newValue.longValue()/1000.00));
	}

}