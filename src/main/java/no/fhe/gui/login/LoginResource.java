package no.fhe.gui.login;

import com.codahale.metrics.annotation.Timed;
import no.fhe.gui.login.LoginView;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.TEXT_HTML)
public class LoginResource {
    public LoginResource(DBI jdbi) {

    }

    @GET
    @Timed
    public LoginView showLogin(){
        return new LoginView();
    }

    @POST
    @Timed
    public LoginView doLogin(){
        return new LoginView();
    }

}
