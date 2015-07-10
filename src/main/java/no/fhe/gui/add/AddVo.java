package no.fhe.gui.add;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class AddVo {
    private String imageId;
    private String thumbnail;
}