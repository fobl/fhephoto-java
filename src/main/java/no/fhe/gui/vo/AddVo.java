package no.fhe.gui.vo;

public class AddVo {

    private String imageId;
    private String thumbnail;

    public AddVo(String imageId, String thumbnail) {
        this.imageId = imageId;
        this.thumbnail = thumbnail;
    }

    public String getImageId() {
        return imageId;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
