package no.fhe.gui.resource;

import com.codahale.metrics.annotation.Timed;
import no.fhe.gui.dao.ImageDao;
import no.fhe.gui.vo.Image;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class ImageResource {

    private ImageDao imageDao;

    public ImageResource(DBI jdbi) {
        imageDao = jdbi.onDemand(ImageDao.class);
    }

    @GET
    @Timed
    @Path("{customerId}")
    public ImageView images(@PathParam("customerId") String customerId){
        List<Image> images = imageDao.imagesForCustomer(customerId);
        return new ImageView(images);
    }

}
