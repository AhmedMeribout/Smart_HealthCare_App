<?php
  $servername = "localhost:3306";
  $username = "root";
  $password = "";
  $dbname = "si";

  // Create connection
  $conn = new mysqli($servername, $username, $password, $dbname);

  // Check connection
  if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  }


  $speech = mysqli_real_escape_string($conn,$_POST['speech']);
  //$id = mysqli_real_escape_string($conn, $_POST['id']);
  //$phone = mysqli_real_escape_string($conn, $_POST['phone']);

  // Insert data into database
  $sql = "INSERT INTO test VALUES ('$speech')";
  
  if (mysqli_query($conn, $sql)) {
   echo "hi";
  } else {
   echo "Error";
  }
  $conn->close();
?>
