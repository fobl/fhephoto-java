<#-- @ftlvariable name="" type="no.fhe.gui.view.ImageView" -->
<#include "/common/header.ftl"/>

<form id="loginForm" class="login" action="/" method="post">
    <ul>
        <ul>
            <label for="email">Username (email)</label>
            <input type="text" name="email" id="email">
        </ul>
        <ul>
            <label for="password">Password</label>
            <input type="password" name="password">
        </ul>
    </ul>
    <input type="hidden" name="passwordRequest" id="passwordRequest">
    <input type="submit" value="Login" name="login"/>

    <a href="javascript:passwordRequest();">Request new password</a>
</form>


<script>
    function passwordRequest(){
        email = $('#email').val();
        if(email == ""){
            $('#error').val('You need to enter email to request password');
        } else {
            $('#passwordRequest').val('true');
            document.for
        }
        $('#loginForm').submit();
    }
</script>

<#include "/common/footer.ftl" />