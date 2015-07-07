package no.fhe.gui.resource;

import com.codahale.metrics.annotation.Timed;
import no.fhe.gui.dao.CustomerDao;
import no.fhe.gui.dao.ImageDao;
import no.fhe.gui.view.AddView;
import no.fhe.gui.vo.Customer;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/add")
@Produces(MediaType.TEXT_HTML)
public class AddResource {
    private final CustomerDao customerDao;
    private ImageDao imageDao;

    public AddResource(DBI jdbi) {
        imageDao = jdbi.onDemand(ImageDao.class);
        customerDao = jdbi.onDemand(CustomerDao.class);
    }

    @GET
    @Timed
    @Path("/{customerId}")
    public AddView add(@PathParam("customerId") String customerId){
        Customer customer = customerDao.fetchById(customerId);
        return new AddView(customer);
    }

    @GET
    @Timed
    public AddView add(){
        return new AddView();
    }

    @POST
    @Timed
    @Path("/{customerId}")
    public AddView updateUser(@PathParam("customerId") String customerId, @FormParam("firstname") String firstname,
                               @FormParam("lastname") String lastname,
                                @FormParam("mobilephone") String mobilephone, @FormParam("email") String email,
                                @FormParam("password") String password, @FormParam("price") int price){
        customerDao.update(customerId, firstname, lastname, mobilephone, email, password, price);
        return new AddView(customerDao.fetchById(customerId));
    }
    
    @POST
    @Timed
    public AddView insertUser(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,
                                @FormParam("mobilephone") String mobilephone, @FormParam("email") String email,
                                @FormParam("password") String password, @FormParam("price") int price){
        String customerId = customerDao.insert(firstname, lastname, mobilephone, email, password, price)+"";
        return new AddView(customerDao.fetchById(customerId));
    }
}
