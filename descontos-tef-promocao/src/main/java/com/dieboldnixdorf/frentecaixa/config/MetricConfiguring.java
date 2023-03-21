package com.dieboldnixdorf.frentecaixa.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.CsvReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

/**
 * The Class MetricConfiguring.
 */
@Configuration
@EnableMetrics
public class MetricConfiguring extends MetricsConfigurerAdapter {
	
	/** The output reporter. */
	@Value("${metrics.outputReporter}")
	private String outputReporter;

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void configureReporters(final MetricRegistry metricRegistry) {
    	final Path path = Paths.get(outputReporter);
    	if (Files.notExists(path)) {
    		final Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwx--x");
    		final FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions.asFileAttribute(perms);    		
    		try {
				Files.createDirectories(path, fileAttributes);
			} catch (final IOException ioex) {
				ioex.printStackTrace();
			}
    	}
        final CsvReporter reporter = CsvReporter.forRegistry(metricRegistry)
                .formatFor(Locale.US)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build(path.toFile());
        reporter.start(1, TimeUnit.MINUTES);  
    }
    
}
