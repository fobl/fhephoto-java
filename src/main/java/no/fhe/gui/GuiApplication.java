package no.fhe.gui;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import no.fhe.gui.login.LoginFilter;
import no.fhe.gui.resource.AddResource;
import no.fhe.gui.gallery.GalleryResource;
import no.fhe.gui.login.LoginResource;
import no.fhe.gui.search.SearchResource;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class GuiApplication extends Application<GuiConfiguration> {

    public static void main(String ... args) throws Exception {
        new GuiApplication().run(args);
    }

    @Override
    public void run(GuiConfiguration config, Environment environment) throws Exception {
        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "database");

        GalleryResource imageResource = new GalleryResource(jdbi);
        environment.jersey().register(imageResource);

        AddResource addResource = new AddResource(jdbi);
        environment.jersey().register(addResource);

        LoginResource loginResource = new LoginResource(jdbi);
        environment.jersey().register(loginResource);

        SearchResource searchResource = new SearchResource(jdbi);
        environment.jersey().register(searchResource);

        environment.servlets().addFilter("LoginFilter", new LoginFilter(jdbi))
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    @Override
    public void initialize(Bootstrap<GuiConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets", "main.css"));
    }
}
