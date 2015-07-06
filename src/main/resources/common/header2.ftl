<!doctype html>
<html lang="no" ng-app>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="assets/main.css??v=<?=time();?>" />
    <script src="assets/jquery-1.11.3.min.js"></script>
    <script src="assets/photo.js"></script>
    <title><?=SITE_TITLE?></title>
</head>

<div class="header">
    <a href="index.php"><img src="assets/logo.png" title="Fhe foto, Frank Hammerbekk Evensen" /></a>
    <div class="main_menu">
        <a href="about.php">About</a>


        <?php if(!empty($action->customer_id)) {?>
        <?php if($action->role == 'a') {?>
        | <a href="add.php">Add photos</a>
        <?php } ?>
        | <a href="?logout=true">Logout</a>
        <?php } else { ?>
        | <a href="login.php">Login</a>
        <?php } ?>
        | <a href="cart.php">Cart(<?=$action->numberOfItemsInCart?>)</a>
        <a class="cart" href="cart.php"><img style="z-index: 100;" src="assets/cart.png" /></a>
    </div>
</div>
