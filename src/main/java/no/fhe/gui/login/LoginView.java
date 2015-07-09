package no.fhe.gui.login;

import io.dropwizard.views.View;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_HTML)
public class LoginView extends View {
    public LoginView() {
        super("login.ftl");
    }
}
