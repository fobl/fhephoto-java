package no.fhe.gui.imageJob;

import com.codahale.metrics.annotation.Timed;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import no.fhe.gui.Paths;
import org.apache.commons.io.FileUtils;
import org.skife.jdbi.v2.DBI;

import javax.sql.rowset.serial.SerialBlob;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collection;
import java.util.UUID;

@Path("/imageJob")
@Produces(MediaType.TEXT_HTML)
public class ImageJobResource {

    private final ImageJobDao imageJobDao;
    private final Paths paths;

    public ImageJobResource(DBI jdbi, Paths paths) {
        imageJobDao = jdbi.onDemand(ImageJobDao.class);
        this.paths = paths;
    }

//    public static void main(String[] args) throws InterruptedException, IOException {
//        new ImageJob().createThumbnail("C:\\elise3.jpg", 200, 200, 100, "C:\\elise3_thumb.jpg");
//    }

    @GET
    @Timed
    public String importFiles() {
        try {
            File dir = new File(paths.getImageFiles());
            Collection<File> files = FileUtils.listFiles(dir, null, true);


            for(File file : files){
                String tmpfile = UUID.randomUUID().toString()+".jpg";
                createThumbnail(file.getAbsolutePath(), 100, 100, 100, paths.getTmpFiles() + tmpfile);
                byte[] content = FileUtils.readFileToByteArray(new File(paths.getTmpFiles() + tmpfile));
                imageJobDao.insertImage(new SerialBlob(content));
            }
            return "Ok";
        } catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    private void createThumbnail(String filename, int thumbWidth, int thumbHeight, int quality, String outFilename)
            throws InterruptedException, FileNotFoundException, IOException
    {

        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        mediaTracker.waitForID(0);

        double thumbRatio = (double)thumbWidth / (double)thumbHeight;
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double imageRatio = (double)imageWidth / (double)imageHeight;
        if (thumbRatio < imageRatio) {
            thumbHeight = (int)(thumbWidth / imageRatio);
        } else {
            thumbWidth = (int)(thumbHeight * imageRatio);
        }

        BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumbImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

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
