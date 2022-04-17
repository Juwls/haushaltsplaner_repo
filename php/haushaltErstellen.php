<?php

if(isset($_POST['erstelleHaushaltName']) && isset($_POST['email_extra'])){
    require_once "connection.php";
    require_once "validate.php";
    $erstelleHaushaltName = validate($_POST['erstelleHaushaltName']);
    $email = validate($_POST['email_extra']);
    $sqlHaushalt = "INSERT INTO haushalt(bezeichnung, admin) VALUES('$erstelleHaushaltName', '$email')";

    
    if($connection->query($sqlHaushalt)){
     
        $sqlFindeHaushaltID = "SELECT id FROM haushalt WHERE admin='$email'";
        $result = $connection->query($sqlFindeHaushaltID);
        $haushalt = mysqli_fetch_assoc($result);
        if($result->num_rows > 0){
            $idHaushalt = $haushalt['id'];
        }
        $sqlMitglieder = "INSERT INTO mitgliederliste(idHaushalt, email) VALUES('$idHaushalt', '$email')";
        $mitgliederINSERT = $connection->prepare($sqlMitglieder);
        $mitgliederINSERT->execute();
        echo $idHaushalt;
    }else{
        echo "failure";
    }
}



?>