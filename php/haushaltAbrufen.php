<?php

if(isset($_POST['email'])){
    require_once "connection.php";
    require_once "validate.php";
    $email = validate($_POST['email']);
    $sql = "SELECT idHaushalt FROM mitgliederliste WHERE email='$email';";

    $result = $connection->query($sql);
    $idHaushalt = mysqli_fetch_assoc($result);

    if($result->num_rows > 0){
        echo $idHaushalt['idHaushalt'];
    }
    else{
        echo 'failure';
    }
}
?>