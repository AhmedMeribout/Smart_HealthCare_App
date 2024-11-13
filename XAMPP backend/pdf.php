<?php
      $servername = "localhost:3306";
      $username = "root";
      $password = "";
      $dbname = "si";
    
      // Create connection
      $connection = new mysqli($servername, $username, $password, $dbname);

    //fetch table rows from mysql db
    $id=$_POST['id'];
    $sql = "select p.id,filename,d.name,time FROM pdf_data p,doctors d WHERE p.doctor_id=d.id and p.user_id=$id";
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