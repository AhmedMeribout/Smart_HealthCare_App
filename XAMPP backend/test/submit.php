<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "si";


$id= $_GET['user_id'];
$message = $_GET['message'];
$doctor_id=$_GET['doctor_id'];

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}

$sql = "INSERT INTO messages (doctor_id,user_id, message) VALUES ('$doctor_id','$id', '$message')";

if (mysqli_query($conn, $sql)) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>