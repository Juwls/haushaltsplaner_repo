<?php

if(isset($_POST['vorname']) && isset($_POST['nachname']) && isset($_POST['email']) && isset($_POST['passwort']) &&  isset($_POST['benutzername'])){
    require_once "connection.php";
    require_once "validate.php";
    $vorname = validate($_POST['vorname']);
    $nachname = validate($_POST['nachname']);
    $email = validate($_POST['email']);
    $passwort = validate($_POST['passwort']);
    $benutzername = validate($_POST['benutzername']);
    $sql = "insert into benutzerkonto values('$email','$benutzername','$vorname','$nachname','". md5($passwort) . "')";
    if(!$connection->query($sql)){
        echo "failure";
    }else
        echo "success";
}


?>