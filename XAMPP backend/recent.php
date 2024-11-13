<?php
      $servername = "localhost:3306";
      $username = "root";
      $password = "";
      $dbname = "si";
    
      // Create connection
      $connection = new mysqli($servername, $username, $password, $dbname);

    //fetch table rows from mysql db
    $id=$_POST['id'];
    $sql = "select diagnose_id,time,speech,response FROM recent WHERE user_id=$id";
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