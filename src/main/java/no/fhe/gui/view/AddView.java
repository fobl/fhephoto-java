package no.fhe.gui.view;

import io.dropwizard.views.View;
import no.fhe.gui.vo.Customer;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_HTML)
public class AddView extends View {

    private Customer customer;

    public AddView() {
        super("add.ftl");
    }

    public AddView(Customer customer) {
        super("add.ftl");
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
