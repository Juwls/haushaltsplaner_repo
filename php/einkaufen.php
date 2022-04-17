
<?php

    if(isset($_POST['idHaushalt'])){
    require_once "connection.php";
    require_once "validate.php";
    
    $idHaushalt = validate($_POST['idHaushalt']);

    $sql = "SELECT idHaushalt, posEinkauf, einkaufsobjekt FROM einkauf WHERE idHaushalt ='$idHaushalt';";
    
    $stmt = $connection->prepare($sql);
    $stmt->execute();
    $stmt->bind_result($idHaushalt, $posEinkauf, $einkaufsobjekt);

    $einkaufsliste = array();

    while($stmt->fetch()){
        $column['idHaushalt'] = $idHaushalt;
        $column['posEinkauf'] = $posEinkauf;
        $column['einkaufsobjekt'] = $einkaufsobjekt;
        array_push($einkaufsliste, $column);
        
    }
    
    echo json_encode($einkaufsliste);
    $connection->close();
}
?>