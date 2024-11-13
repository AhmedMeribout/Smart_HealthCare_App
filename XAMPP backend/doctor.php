<?php
      $servername = "localhost:3306";
      $username = "root";
      $password = "";
      $dbname = "si";
    
      // Create connection
      $connection = new mysqli($servername, $username, $password, $dbname);

    //fetch table rows from mysql db
    $id=$_POST['id'];
    $sql = "select name,speciality,phone,id FROM doctors";
    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    echo json_encode($emparray);

    //close the db connection
    mysqli_close($connection);
?>