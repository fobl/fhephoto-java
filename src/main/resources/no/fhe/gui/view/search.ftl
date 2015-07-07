<#-- @ftlvariable name="" type="no.fhe.gui.view.SearchView" -->
<#include "/common/header.ftl"/>

<form class="form-box" id="searchForm" action="search" method="post">
    <label for="search">Find existing customer, or add a new</label>
    <input type="text" name="search" />
    <input type="submit" name="submitSearch" value="Search">
    <input type="button" name="new" value="New customer">
</form>

<#--<#if getCustomers().size() > 0>-->
<table class="hoverTable">
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Mobile</th>
    </tr>
<#list getCustomers() as customer>
    <tr onclick="location.href='add/${customer.getCustomerId()}'">
        <td>${customer.getFirstname()}</a></td>
        <td>${customer.getLastname()}</a></td>
        <td>${customer.getEmail()}</a></td>
        <td>${customer.getMobilephone()}</a></td>
    </tr>
</#list>
</table>
<#--</#if>-->

<#include "/common/footer.ftl" />