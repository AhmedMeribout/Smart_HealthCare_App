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
  -$headache=str_contains($speech, 'headache');
  // Insert data into database
  
  $sqlresponse = "SELECT solution FROM response WHERE headache=$headache";
  try{
    $result = mysqli_query( $conn,$sqlresponse);
  if($result){
    $row = mysqli_fetch_row($result);
  echo $row[0];
  $sqlinsert = "INSERT INTO test VALUES ('$speech')";
  if (mysqli_query($conn, $sqlinsert)) {

   //echo "Parasetamol";
  } else {
   //echo "Error";
  }
  }else{
    echo "I am sorry I couldn't understand you or we didn't find a solution please contact a doctor.";
  };
  }catch (Exception $e) {
    echo "I am sorry I couldn't understand you or I could't find an answer for you please contact your neareest doctor";
}
  
  
  $conn->close();
?>
