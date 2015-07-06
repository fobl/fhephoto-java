package no.fhe.gui.dao;

import no.fhe.gui.mapper.ImageMapper;
import no.fhe.gui.vo.Image;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ImageMapper.class)
public interface ImageDao {
    @SqlQuery("select i.image_id, o.orderline_id, i.image, i.fullsize, i.thumbnail, i.bought, i.customer_id, i.url, c.image_zip" +
            " from image i left join orderline o on i.image_id = o.image_id" +
            " left join customer c on c.customer_id = i.customer_id" +
            " where i.customer_id = :customerId")
    List<Image> imagesForCustomer(@Bind("customerId") String customerId);

}


//@RegisterMapper(CategoryMapper.class)
//public interface CategoryDao {
//
//    @SqlUpdate("insert into category (title, password, customerId) values(:title, :password, :customerId)")
//    @GetGeneratedKeys
//    String insert(@Bind("title")String title, @Bind("password")String password, @Bind("customerId") String customerId);
//
//    @SqlUpdate("update category set title=:title:, password=:password, customerId=:customerId where categoryId=categoryId;")
//    void update(@Bind("categoryId")String categoryId, @Bind("title")String title, @Bind("password")String password, @Bind("customerId") String customerId);
//
//    @SqlQuery("select * from category where categoryId = :categoryId")
//    Category retrieve(@Bind("categoryId") String categoryId);
//}
//
