package no.fhe.gui;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GuiConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty
    private Paths paths = new Paths();


    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public Paths getPaths() {
        return paths;
    }
}
