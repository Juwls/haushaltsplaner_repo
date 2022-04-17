<?php
    $server = "localhost";
    $username = "root";
    $password = "";
    $database = "hapla";
    $connection = mysqli_connect($server, $username, $password, $database);
    if ($connection->connect_error){
        die("Connection to MySQL database failed" . $connection->connect_error);
    }


?>