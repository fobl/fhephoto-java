package no.fhe.gui.imageServlet;

import org.skife.jdbi.v2.DBI;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

    private ImageDao imageDao;

    public ImageServlet(DBI jdbi){
        imageDao = jdbi.onDemand(ImageDao.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("image/jpeg");
            String imageId = req.getParameter("image_id");
            String imageType = req.getParameter("image_type");

            byte[] bdata = image(imageId, imageType);
            resp.setContentLength(bdata.length);
            resp.getOutputStream().write(bdata);
            resp.getOutputStream().close();
        } catch(Exception e){
           throw new RuntimeException(e);
        }
    }

    private byte[] image(String imageId, String imageType) throws Exception {
        ImageVo image = imageDao.findImageById(imageId);

        switch(imageType){
           case "fullsize":
               return image.getFullsize().getBytes(1, (int) image.getFullsize().length());
           case "watermarked":
               return image.getWatermarked().getBytes(1, (int) image.getWatermarked().length());
           default:
               return image.getThumbnail().getBytes(1, (int) image.getThumbnail().length());
        }
    }

}
