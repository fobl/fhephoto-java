package no.fhe.gui.view;

import io.dropwizard.views.View;
import no.fhe.gui.vo.Image;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
