<?php
  $servername = "localhost:3306";
  $username = "root";
  $password = "";
  $dbname = "si";

  // Create connection
  $conn = new mysqli($servername, $username, $password, $dbname);

  $speech = $_POST['speech'];
  $id=$_POST['id'];
  $headache = str_contains($speech, 'headache');
  $accident = str_contains($speech, 'accident');
  
  $sqlresponse = "SELECT solution FROM response WHERE headache=? AND accident=?";
  $stmt = $conn->prepare($sqlresponse);
  $stmt->bind_param("ii", $headache, $accident);
  $stmt->execute();
  $result = $stmt->get_result();

  if ($result->num_rows > 0) {
    $speech = $_POST['speech'];
    $row = $result->fetch_assoc();
    echo $row['solution'];
    $solution=$row['solution'];
    $sqlinsert = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", \"$solution\")";
if (mysqli_query($conn, $sqlinsert)) {
  // echo "Parasetamol";
} else {
  //echo "Error";
}
  } else {
    echo "I am sorry I couldn't understand you or we didn't find a solution. Please contact a doctor.";
  }

  $stmt->close();
  $conn->close();
?>

