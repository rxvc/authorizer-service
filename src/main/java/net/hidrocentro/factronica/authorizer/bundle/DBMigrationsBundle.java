package net.hidrocentro.factronica.authorizer.bundle;

import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.hidrocentro.factronica.authorizer.configuration.ServiceConfiguration;
import org.flywaydb.core.Flyway;

public class DBMigrationsBundle implements ConfiguredBundle<ServiceConfiguration> {
    @Override
    public void run(ServiceConfiguration configuration, Environment environment) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(configuration.getDataSourceFactory().getUrl(), configuration.getDataSourceFactory().getUser(), configuration.getDataSourceFactory().getPassword());
        flyway.setSchemas(configuration.getDefaultSchema());
        flyway.migrate();
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        // Do nothing.
    }
}
