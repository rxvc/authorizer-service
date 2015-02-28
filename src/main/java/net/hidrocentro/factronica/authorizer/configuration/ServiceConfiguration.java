package net.hidrocentro.factronica.authorizer.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServiceConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private final DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    @JsonProperty("celConfiguration")
    private final CelConfiguration celConfiguration = new CelConfiguration();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public String getDefaultSchema() {
        return database.getProperties().get("hibernate.default_schema");
    }


}
