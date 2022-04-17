
<?php

if(isset($_POST['idHaushalt']) && isset($_POST['einkaufenEingabe'])){
    require_once "connection.php";
    require_once "validate.php";
    $idHaushalt = validate($_POST['idHaushalt']);
    $einkaufenEingabe = validate($_POST['einkaufenEingabe']);
    $sqlSELECT = "SELECT max(posEinkauf) AS 'posEinkauf' FROM einkauf WHERE idHaushalt='$idHaushalt';";
    
   if($connection->query($sqlSELECT)){

    $result = $connection->query($sqlSELECT);
    $getPos = mysqli_fetch_assoc($result);  
    $pos = $getPos['posEinkauf'];
    
    if($result->num_rows < 1){
        $posNew=1;
    }else{  
        $posNew = $pos + 1;
    }

    $sqlINSERT = "INSERT INTO einkauf(idHaushalt, posEinkauf, einkaufsobjekt) VALUES('$idHaushalt', '$posNew', '$einkaufenEingabe');";

    if(!$connection->query($sqlINSERT)){
        echo 'failure';
    }else {
        echo 'success';
    }

   }else {
       echo 'failure';
   }

}

?>