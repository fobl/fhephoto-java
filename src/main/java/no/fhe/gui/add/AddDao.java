package no.fhe.gui.add;

import no.fhe.gui.add.AddMapper;
import no.fhe.gui.add.AddResource;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(AddMapper.class)
public interface AddDao {
    @SqlQuery("select i.image_id, i.thumbnail from image i order by created_date")
    List<AddVo> imagesToSelect(@Bind("customerId") String customerId);
}
