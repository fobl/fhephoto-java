package no.fhe.gui.login;

import no.fhe.gui.vo.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(LoginMapper.class)
public interface LoginDao {

    @SqlUpdate("update user set login_attempts = login_attempts + 1, login_date = now()")
    void updateFailedLogin();

    @SqlUpdate("update user set login_date = now(), login_key = :login_key")
    void updateLoginKey(@Bind("login_key") String loginKey);

    @SqlQuery("select * from user where login_key = :login_key and email = :email")
    LoginVo isLoggedIn(@Bind("login_key") String key, @Bind("email") String email);

    @SqlQuery("select * from user where email=:email and password=:password")
    LoginVo login(@Bind("email") String email, @Bind("password") String password);
}
