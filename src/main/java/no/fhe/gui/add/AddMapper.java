package no.fhe.gui.add;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMapper implements ResultSetMapper<AddVo> {
    @Override
    public AddVo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new AddVo(r.getString("image_id"), r.getString("thumbnail"));
    }
}
