package no.fhe.gui.search;

import no.fhe.gui.vo.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(SearchMapper.class)
public interface SearchDao {
    @SqlQuery("select * from user where email like :search or firstname like :search or lastname like :search")
    List<SearchVo> search(@Bind("search") String search);

}
