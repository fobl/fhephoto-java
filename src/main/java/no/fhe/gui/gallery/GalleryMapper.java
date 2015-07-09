package no.fhe.gui.gallery;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GalleryMapper implements ResultSetMapper<GalleryVo> {
    @Override
    public GalleryVo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        GalleryVo galleryVo = new GalleryVo();
        galleryVo.setBought(r.getString("bought"));
        galleryVo.setCustomerId(r.getString("customer_id"));
//        galleryVo.setFullsize(r.getString("fullsize"));
        galleryVo.setImage(r.getString("image"));
        galleryVo.setImageId(r.getString("image_id"));
        galleryVo.setImageZip(r.getString("image_zip"));
        galleryVo.setOrderlineId(r.getString("orderline_id"));
        galleryVo.setThumbnail(r.getString("thumbnail"));
        galleryVo.setUrl(r.getString("url"));
        return galleryVo;
    }
}
