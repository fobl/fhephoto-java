package no.fhe.gui.imageJob;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.sql.Blob;

public interface ImageJobDao {

    @SqlUpdate("insert into image (thumbnail) values(:thumbnail)")
    Integer insertImage(@Bind("thumbnail") Blob thumbnail);

    @SqlQuery("select * from image where image_id = :image_id")
    ImageVo selectImage(@Bind("image_id") String imageId);

}
