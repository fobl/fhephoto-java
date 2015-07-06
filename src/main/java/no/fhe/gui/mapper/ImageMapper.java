package no.fhe.gui.mapper;

import no.fhe.gui.vo.Image;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements ResultSetMapper<Image> {
    @Override
    public Image map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Image image = new Image();
        image.setBought(r.getString("bought"));
        image.setCustomerId(r.getString("customer_id"));
//        image.setFullsize(r.getString("fullsize"));
        image.setImage(r.getString("image"));
        image.setImageId(r.getString("image_id"));
        image.setImageZip(r.getString("image_zip"));
        image.setOrderlineId(r.getString("orderline_id"));
        image.setThumbnail(r.getString("thumbnail"));
        image.setUrl(r.getString("url"));
        return image;
    }
}
