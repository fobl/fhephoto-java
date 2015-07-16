package no.fhe.gui.gallery;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GalleryMapper implements ResultSetMapper<GalleryVo> {
    @Override
    public GalleryVo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return GalleryVo.builder()
                .bought(r.getString("bought"))
                .customerId(r.getString("customer_id"))
                .fullsize(r.getString("fullsize"))
                .watermarked(r.getString("watermarked"))
                .imageId(r.getString("image_id"))
                .imageZip(r.getString("image_zip"))
                .orderlineId(r.getString("orderline_id"))
                .thumbnail(r.getString("thumbnail"))
                .build();
    }
}
