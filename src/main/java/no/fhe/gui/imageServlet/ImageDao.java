package no.fhe.gui.imageServlet;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ImageMapper.class)
public interface ImageDao {

    @SqlQuery("select * from image where image_id = :image_id")
    ImageVo findImageById(@Bind("image_id") String imageId);
}
