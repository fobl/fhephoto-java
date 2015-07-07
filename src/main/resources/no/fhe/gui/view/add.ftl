<#-- @ftlvariable name="" type="no.fhe.gui.view.AddView" -->
<#include "/common/header.ftl"/>

<form class="form-box" action="" method="post">
    <ul>
        <li>
            <label for="firstname">Firstname</label>
            <input type="text" value="${(getCustomer().getFirstname())!}" name="firstname"/>
            <input type="hidden" value="<?=$action->customerDao->customer_id?>" name="customer_id"/>
        </li>
        <li>
            <label for="lastname">Lastname</label>
            <input type="text" value="${(getCustomer().getLastname())!}" name="lastname"/>
        </li>
        <li>
            <label for="email">Email</label>
            <input type="text" value="${(getCustomer().getEmail())!}" name="email"/>
        </li>
        <li>
            <label for="mobilephone">Mobilephone</label>
            <input type="text" value="${(getCustomer().getMobilephone())!}" name="mobilephone"/>
        </li>
        <li>
            <label for="price">Price (TODO CURRENCY})</label>
            <input type="text" value="${(getCustomer().getPrice())!}" name="price"/>
        </li>
    </ul>

    <input type="submit" name="save" value="Save"">
    <input type="button" value="Search for customer" onclick="location.href='search'">
    <input type="button" value="New customer" onclick="location.href=''">
</form>
<#include "/common/footer.ftl" />