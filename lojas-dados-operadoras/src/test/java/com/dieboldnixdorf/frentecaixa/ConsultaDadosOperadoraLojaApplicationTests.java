package com.dieboldnixdorf.frentecaixa;

import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The Class ConsultaDadosOperadoraLojaApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = { "spring.jmx.enabled:true",
		"spring.datasource.jmx-enabled:true" })
@ActiveProfiles("scratch")
public class ConsultaDadosOperadoraLojaApplicationTests {

	/** The context. */
	@Autowired
	private WebApplicationContext context;

	/** The mvc. */
	private MockMvc mvc;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	/**
	 * Test jmx.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testJmx() throws Exception {
		assertThat(ManagementFactory.getPlatformMBeanServer()
				.queryMBeans(new ObjectName("com.dieboldnixdorf.frentecaixa.domain:type=ConnectionPool,*"), null))
						.hasSize(1);
	}

}
