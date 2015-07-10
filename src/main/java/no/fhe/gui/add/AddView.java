package no.fhe.gui.add;

import io.dropwizard.views.View;
import no.fhe.gui.vo.Customer;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.TEXT_HTML)
public class AddView extends View {

    private List<AddVo> images;
    private Customer customer;

    public AddView() {
        super("add.ftl");
    }

    public AddView(Customer customer, List<AddVo> images) {
        super("add.ftl");
        this.customer = customer;
        this.images = images;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<AddVo> getImages() {
        return images;
    }
}
