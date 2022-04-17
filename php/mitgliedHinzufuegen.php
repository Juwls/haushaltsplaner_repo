<?php

if(isset($_POST['idHaushalt']) && $_POST['mitgliedHinzufuegen']){
    require_once "connection.php";
    require_once "validate.php";
    $idHaushalt = validate($_POST['idHaushalt']);
    $mitgliedHinzufuegen = validate($_POST['mitgliedHinzufuegen']);
    $sql = "INSERT INTO mitgliederliste(idHaushalt, email) VALUES('$idHaushalt', '$mitgliedHinzufuegen')";
    if(!$connection->query($sql)){
        echo "failure";
    }else
        echo "success";
}


?>