package no.fhe.gui.search;

import com.codahale.metrics.annotation.Timed;
import no.fhe.gui.dao.CustomerDao;
import no.fhe.gui.search.SearchView;
import no.fhe.gui.vo.Customer;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/search")
@Produces(MediaType.TEXT_HTML)
public class SearchResource {

    private SearchDao searchDao;

    public SearchResource(DBI jdbi) {
        searchDao = jdbi.onDemand(SearchDao.class);
    }

    @GET
    @Timed
    public SearchView showForm(){
        return new SearchView();
    }

    @POST
    @Timed
    public SearchView search(@FormParam("search") String search){
        if(null == search || "".equals(search)){
            return new SearchView();
        } else {
            List<SearchVo> result = searchDao.search('%'+search+'%');
            return new SearchView(result);
        }
    }
}
