<?php

if(isset($_POST['idHaushalt'])){
    require_once "connection.php";
    require_once "validate.php";
    $idHaushalt = validate($_POST['idHaushalt']);
    $sql = "SELECT bezeichnung FROM haushalt WHERE id='$idHaushalt';";

    $result = $connection->query($sql);
    $bezeichnung = mysqli_fetch_assoc($result);

    if($result->num_rows > 0){
        echo $bezeichnung['bezeichnung'];
    }
    else{
        echo 'failure';
    }
}
?>