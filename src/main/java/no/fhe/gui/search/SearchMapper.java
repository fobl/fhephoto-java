package no.fhe.gui.search;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchMapper implements ResultSetMapper<SearchVo> {
    @Override
    public SearchVo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return SearchVo.builder()
                .userId(r.getString("user_id"))
                .email(r.getString("email"))
                .firstname(r.getString("firstname"))
                .lastname(r.getString("lastname"))
                .mobilephone(r.getString("mobilephone"))
                .build();
    }
}
