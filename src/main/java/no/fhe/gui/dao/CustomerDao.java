package no.fhe.gui.dao;

import no.fhe.gui.mapper.CustomerMapper;
import no.fhe.gui.vo.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(CustomerMapper.class)
public interface CustomerDao {




    @SqlQuery("select * from customer where email like :search")
    List<Customer> search(@Bind("search") String search);

    @SqlQuery("select * from customer where customer_id like :customer_id")
    Customer fetchById(@Bind("customer_id") String customerId);

    @SqlUpdate("insert into customer (firstname, lastname, mobilephone, email, password, role, price)" +
            " values(:firstname,:lastname, :mobilephone, :email, :password, 'c', :price)")
    Integer insert(@Bind("firstname") String firstname,@Bind("lastname") String lastname,
                  @Bind("mobilephone") String mobilephone, @Bind("email") String email,
                  @Bind("password") String password, @Bind("price") int price);


    @SqlUpdate("update customer set firstname=:firstname, lastname=:lastname, mobilephone=:mobilephone," +
            " email=:email, password=:password, price=:price" +
            " where customer_id = :customer_id")
    void update(@Bind("customer_id") String customerId, @Bind("firstname") String firstname, @Bind("lastname") String lastname,
                @Bind("mobilephone") String mobilephone, @Bind("email") String email,
                @Bind("password") String password, @Bind("price") int price);
}
