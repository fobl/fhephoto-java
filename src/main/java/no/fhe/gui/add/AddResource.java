package no.fhe.gui.add;

import com.codahale.metrics.annotation.Timed;
import no.fhe.gui.dao.CustomerDao;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/add")
@Produces(MediaType.TEXT_HTML)
public class AddResource {
    private final CustomerDao customerDao;
    private final AddDao addDao;

    public AddResource(DBI jdbi) {
        addDao = jdbi.onDemand(AddDao.class);
        customerDao = jdbi.onDemand(CustomerDao.class);
    }

    @GET
    @Timed
    @Path("/{customerId}")
    public AddView add(@PathParam("customerId") String customerId){
        return new AddView(customerDao.fetchById(customerId), addDao.imagesToSelect(customerId));
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
        return new AddView(customerDao.fetchById(customerId), addDao.imagesToSelect(customerId));
    }
    
    @POST
    @Timed
    public AddView insertUser(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,
                                @FormParam("mobilephone") String mobilephone, @FormParam("email") String email,
                                @FormParam("password") String password, @FormParam("price") int price){
        String customerId = customerDao.insert(firstname, lastname, mobilephone, email, password, price)+"";
        return new AddView(customerDao.fetchById(customerId), addDao.imagesToSelect(customerId));
    }
}
