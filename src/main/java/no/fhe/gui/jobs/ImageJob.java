package no.fhe.gui.jobs;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import no.fhe.gui.Paths;
import org.apache.commons.io.FileUtils;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collection;

@Path("/imageJob")
@Produces(MediaType.TEXT_HTML)
public class ImageJob {

    private final ImageJobDao imageJobDao;
    private final Paths paths;

    public ImageJob(DBI jdbi, Paths paths) {
        imageJobDao = jdbi.onDemand(ImageJobDao.class);
        this.paths = paths;
    }

//    public static void main(String[] args) throws InterruptedException, IOException {
//        new ImageJob().createThumbnail("C:\\elise3.jpg", 200, 200, 100, "C:\\elise3_thumb.jpg");
//    }

    @GET
    private void importFiles(){
        File dir = new File(paths.getImageFiles());
        Collection<File> files = FileUtils.listFiles(dir, null, true);

    }

    private void createThumbnail(String filename, int thumbWidth, int thumbHeight, int quality, String outFilename)
            throws InterruptedException, FileNotFoundException, IOException
    {
//        // load image from filename
//        Image image = Toolkit.getDefaultToolkit().getImage(filename);
//        MediaTracker mediaTracker = new MediaTracker(new Container());
//        mediaTracker.addImage(image, 0);
//        mediaTracker.waitForID(0);
//        // use this to test for errors at this point: System.out.println(mediaTracker.isErrorAny());
//
//        // determine thumbnail size from WIDTH and HEIGHT
//        double thumbRatio = (double)thumbWidth / (double)thumbHeight;
//        int imageWidth = image.getWidth(null);
//        int imageHeight = image.getHeight(null);
//        double imageRatio = (double)imageWidth / (double)imageHeight;
//        if (thumbRatio < imageRatio) {
//            thumbHeight = (int)(thumbWidth / imageRatio);
//        } else {
//            thumbWidth = (int)(thumbHeight * imageRatio);
//        }
//
//        // draw original image to thumbnail image object and
//        // scale it to the new size on-the-fly
//        BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics2D = thumbImage.createGraphics();
//        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
//
//        // save thumbnail image to outFilename
//        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);
//        quality = Math.max(0, Math.min(quality, 100));
//        param.setQuality((float)quality / 100.0f, false);
//        encoder.setJPEGEncodeParam(param);
//        encoder.encode(thumbImage);
//
//
//        out.close();
//

   // load image from filename
        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        mediaTracker.waitForID(0);
        // use this to test for errors at this point: System.out.println(mediaTracker.isErrorAny());

        // determine thumbnail size from WIDTH and HEIGHT
        double thumbRatio = (double)thumbWidth / (double)thumbHeight;
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double imageRatio = (double)imageWidth / (double)imageHeight;
        if (thumbRatio < imageRatio) {
            thumbHeight = (int)(thumbWidth / imageRatio);
        } else {
            thumbWidth = (int)(thumbHeight * imageRatio);
        }

        // draw original image to thumbnail image object and
        // scale it to the new size on-the-fly
        BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumbImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

        // save thumbnail image to outFilename
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);
        quality = Math.max(0, Math.min(quality, 100));
        param.setQuality((float)quality / 100.0f, false);
        encoder.setJPEGEncodeParam(param);
        encoder.encode(thumbImage);


        out.close();
    }
}
