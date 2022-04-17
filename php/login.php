<?php

if(isset($_POST['email']) && isset($_POST['passwort'])){
    require_once "connection.php";
    require_once "validate.php";
    $email = validate($_POST['email']);
    $passwort = validate($_POST['passwort']);
    $sql = "select * from benutzerkonto where email='$email' and passwort='" . md5($passwort) . "'";
    $result = $connection->query($sql);
    if($result->num_rows > 0){
        echo "success";
    }
    else{
        echo "failure";
    }

        
}   
    

?>