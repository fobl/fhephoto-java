package no.fhe.gui;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import no.fhe.gui.resource.ImageResource;
import no.fhe.gui.resource.ImageView;
import org.apache.http.client.HttpClient;
import org.skife.jdbi.v2.DBI;

public class GuiApplication extends Application<GuiConfiguration> {

    public static void main(String ... args) throws Exception {
        new GuiApplication().run(args);
    }

    @Override
    public void run(GuiConfiguration config, Environment environment) throws Exception {
        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "database");

        ImageResource resource = new ImageResource(jdbi);
        environment.jersey().register(resource);
    }

    @Override
    public void initialize(Bootstrap<GuiConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets", "main.css"));
    }
}
