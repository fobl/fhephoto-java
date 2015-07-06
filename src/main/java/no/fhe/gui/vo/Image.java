package no.fhe.gui.vo;

public class Image {

    private String imageId;
    private String orderlineId;
    private String image;
    private String fullsize;
    private String thumbnail;
    private String bought;
    private String customerId;
    private String url;
    private String imageZip;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(String orderlineId) {
        this.orderlineId = orderlineId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullsize() {
        return fullsize;
    }

    public void setFullsize(String fullsize) {
        this.fullsize = fullsize;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBought() {
        return bought;
    }

    public void setBought(String bought) {
        this.bought = bought;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageZip() {
        return imageZip;
    }

    public void setImageZip(String imageZip) {
        this.imageZip = imageZip;
    }
}
