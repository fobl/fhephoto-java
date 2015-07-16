package no.fhe.gui.imageServlet;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements ResultSetMapper<ImageVo> {
    @Override
    public ImageVo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return ImageVo.builder()
                .thumbnail(r.getBlob("thumbnail"))
                .fullsize(r.getBlob("fullsize"))
                .watermarked(r.getBlob("watermarked"))
                .build();
    }
}
