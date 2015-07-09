package no.fhe.gui.mapper;

import no.fhe.gui.vo.Customer;
import org.joda.time.LocalDate;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements ResultSetMapper<Customer>  {
    @Override
    public Customer map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(r.getString("customer_id"));
        customer.setEmail(r.getString("email"));
        customer.setFirstname(r.getString("firstname"));
        customer.setLastname(r.getString("lastname"));
        customer.setImageZip(r.getString("image_zip"));
        customer.setLoginAttempts(r.getInt("login_attempts"));
        customer.setLoginDate(new LocalDate(r.getDate("login_date")));
        customer.setLoginKey(r.getString("login_key"));
        customer.setMobilephone(r.getString("mobilephone"));
        customer.setPassword(r.getString("password"));
        customer.setPrice(r.getInt("price"));
        customer.setRole(r.getString("role"));
        return customer;
    }
}
