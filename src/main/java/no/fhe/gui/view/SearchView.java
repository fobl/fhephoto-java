package no.fhe.gui.view;

import io.dropwizard.views.View;
import no.fhe.gui.vo.Customer;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.TEXT_HTML)
public class SearchView extends View {

    private final List<Customer> customers;

    public SearchView(List<Customer> customers) {
        super("search.ftl");
        this.customers = customers;
    }

    public SearchView() {
        super("search.ftl");
        this.customers = new ArrayList();
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
