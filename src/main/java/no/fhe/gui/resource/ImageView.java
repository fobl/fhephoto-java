package no.fhe.gui.resource;

import io.dropwizard.views.View;
import no.fhe.gui.vo.Image;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class ImageView extends View {

    private List<Image> images;

    public ImageView(List<Image> images) {
        super("images.ftl");
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }
}
