package no.fhe.gui.imageServlet;

import lombok.Builder;
import lombok.Data;

import java.sql.Blob;

public @Data @Builder
class ImageVo {
    private Blob thumbnail;
    private Blob fullsize;
    private Blob watermarked;

}
