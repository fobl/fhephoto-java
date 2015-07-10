<#-- @ftlvariable name="" type="no.fhe.gui.add.AddView" -->
<#include "/common/header.ftl"/>

<?php if(empty($_REQUEST['new']) && empty($_REQUEST['customer_id'])){ ?>
<form class="form-box" id="searchForm" action="add.php">
    <label for="search">Find existing customer, or add a new</label>
    <input type="text" name="search" />
    <input type="submit" name="submitSearch" value="Search">
    <input type="submit" name="new" value="New customer">
</form>

<?php if(!empty($action->search_row) && sizeof($action->search_row) > 0){?>
<table class="hoverTable">
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Mobile</th>
    </tr>
    <?php foreach($action->search_row as $customer){?>
    <tr onclick="location.href='add.php?customer_id=<?=$customer['customer_id']?>'">
        <td><?=$customer['firstname']?></a></td>
        <td><?=$customer['lastname']?></a></td>
        <td><?=$customer['email']?></a></td>
        <td><?=$customer['mobilephone']?></a></td>
    </tr>
    <?php } ?>
</table>
<?php } ?>
<?php } else { ?>
<form class="form-box" action="add.php?customer_id=<?=$_REQUEST['customer_id']?>" method="post">
    <ul>
        <li>
            <label for="firstname">Firstname</label>
            <input type="text" value="<?=$action->customerDao->firstname?>" name="firstname"/>
            <input type="hidden" value="<?=$action->customerDao->customer_id?>" name="customer_id"/>
        </li>
        <li>
            <label for="lastname">Lastname</label>
            <input type="text" value="<?=$action->customerDao->lastname?>" name="lastname"/>
        </li>
        <li>
            <label for="email">Email</label>
            <input type="text" value="<?=$action->customerDao->email?>" name="email"/>
        </li>
        <li>
            <label for="mobilephone">Mobilephone</label>
            <input type="text" value="<?=$action->customerDao->mobilephone?>" name="mobilephone"/>
        </li>
        <li>
            <label for="price">Price (<?=CURRENCY?>)</label>
            <input type="text" value="<?=$action->customerDao->price?>" name="price"/>
        </li>
    </ul>

    <input type="submit" name="save" value="Save"">
    <input type="button" value="Search for customer" onclick="location.href='add.php'">
    <input type="button" value="New customer" onclick="location.href='add.php?new=New+customer'">

    <div id="addPhoto">
        <?php
            if(!empty($_REQUEST['customer_id'])) {
                echo '<h3>Add or remove galleries</h3>';

        $i = 0;
        if (!empty($action->galleries)) {
        foreach ($action->galleries as $galleryVo) {
        if ($galleryVo['bought'] != '1') {
        if ($galleryVo['customer_id'] == $action->customerDao->customer_id) {
        echo '<input type="checkbox" id="image_' . $galleryVo['image_id'] . '" name="image_' . $galleryVo['image_id'] . '" checked="checked">';
        } else {
        echo '<input type="checkbox" id="image_' . $galleryVo['image_id'] . '" name="image_' . $galleryVo['image_id'] . '">';
        }
        echo '<label for="image_' . $galleryVo['image_id'] . '">';
        echo '<img src="galleries/' . $galleryVo['thumbnail'] . '" \>';
        echo '</label>';
        $i++;
        }
        }
        }
        if ($i == 0) {
        echo '<h5>No galleries to add, please upload galleries.</h5>';
        }

        echo '<h3>Customer already bought</h3>';

        $i = 0;
        if (!empty($action->galleries)) {
        foreach ($action->galleries as $galleryVo) {
        if ($galleryVo['bought'] == '1') {
        echo '<img src="galleries/' . $galleryVo['thumbnail'] . '" \>';
        $i++;
        }
        }
        }
        if ($i == 0) {
        echo '<h5>Customer have not bought any galleries.</h5>';
        }
        }
        ?>
    </div>
</form>
<?php } ?>

<?php include_once(COMMON  . "footer.php") ?>

<#include "/common/footer.ftl" />
