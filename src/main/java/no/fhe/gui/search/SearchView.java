package no.fhe.gui.search;

import io.dropwizard.views.View;
import no.fhe.gui.vo.Customer;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.TEXT_HTML)
public class SearchView extends View {

    private final List<SearchVo> result;

    public SearchView(List<SearchVo> result) {
        super("search.ftl");
        this.result = result;
    }

    public SearchView() {
        super("search.ftl");
        this.result = new ArrayList();
    }

    public List<SearchVo> getResult() {
        return result;
    }
}
