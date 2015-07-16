package no.fhe.gui.gallery;

import com.codahale.metrics.annotation.Timed;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class GalleryResource {

    private GalleryDao imageDao;

    public GalleryResource(DBI jdbi) {
        imageDao = jdbi.onDemand(GalleryDao.class);
    }

    @GET
    @Timed
    public GalleryView images(@QueryParam("customerId") String customerId){
        List<GalleryVo> galleries = imageDao.imagesForCustomer(customerId);
        return new GalleryView(galleries);
    }

    @POST
    @Timed
    public GalleryView imagesPost(@QueryParam("customerId") String customerId){
       // List<GalleryVo> galleries = imageDao.imagesForCustomer(customerId);
       // return new GalleryView(galleries);
        return new GalleryView(new ArrayList<GalleryVo>());
    }


}
