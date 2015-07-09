package no.fhe.gui.gallery;

import com.codahale.metrics.annotation.Timed;
import no.fhe.gui.dao.ImageDao;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class GalleryResource {

    private ImageDao imageDao;

    public GalleryResource(DBI jdbi) {
        imageDao = jdbi.onDemand(ImageDao.class);
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
        List<GalleryVo> galleries = imageDao.imagesForCustomer(customerId);
        return new GalleryView(galleries);
    }


}
