package no.fhe.gui.gallery;

import io.dropwizard.views.View;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.TEXT_HTML)
public class GalleryView extends View {

    private List<GalleryVo> galleryVos;

    public GalleryView(List<GalleryVo> galleries) {
        super("galleryVos.ftl");
        this.galleryVos = galleries;
    }

    public List<GalleryVo> getGalleryVos() {
        return galleryVos;
    }
}
