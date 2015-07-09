package no.fhe.gui.login;

import org.joda.time.LocalDate;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements ResultSetMapper<LoginVo> {
    @Override
    public LoginVo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return LoginVo.builder()
                .email(r.getString("email"))
                .firstname(r.getString("firstname"))
                .lastname(r.getString("lastname"))
                .loginAttempts(r.getInt("login_attempts"))
                .loginDate(new LocalDate(r.getDate("login_date")))
                .loginKey(r.getString("login_key"))
                .mobilephone(r.getString("mobilephone"))
                .password(r.getString("password"))
                .role(r.getString("role"))
                .build();
    }
}
