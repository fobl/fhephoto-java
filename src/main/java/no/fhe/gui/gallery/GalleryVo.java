package no.fhe.gui.gallery;

import lombok.Builder;
import lombok.Data;

public @Data
@Builder
class GalleryVo {

    private String imageId;
    private String orderlineId;
    private String watermarked;
    private String fullsize;
    private String thumbnail;
    private String bought;
    private String customerId;
    private String url;
    private String imageZip;
}
