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
//synonym of headache



//$accident = str_contains($speech, 'حادث مرور');
$nose = str_contains($speech, 'runny nose');

$eyes = str_contains($speech, 'red eyes');
$sneezing = str_contains($speech, 'sneez');
$itching = str_contains($speech, 'itching');
$throat = str_contains($speech, 'throat');
$fever = str_contains($speech, 'fever');
$tired = str_contains($speech, 'tired');
$taste=str_contains($speech, 'taste');
$vomiting = str_contains($speech, 'vomiting');
$deziness = str_contains($speech, 'dizz');
$diarreah = str_contains($speech, 'diarrhea');
$stomach = str_contains($speech, 'stomach');



$sqlresponse = "SELECT images,level,illnessen,treatment_en FROM illness i,help h,symptoms s WHERE i.illness_id=h.illness_id and i.illness_id=s.illness_id and  headache=? and runny_nose=? and itching=? and red_eyes=? and sneezing=? and throat=? and fever=? and tired=? and taste=? and vomitting=? and dizziness=? and diarrhea=? and stomach=?";
$stmt = $conn->prepare($sqlresponse);
$stmt->bind_param("iiiiiiiiiiiii", $headache,$nose,$itching, $eyes,$sneezing,$throat,$fever,$tired,$taste,$vomiting,$deziness,$diarreah,$stomach);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    $row = mysqli_fetch_array($result);
    $result=array(
      "level"=>$row['level'],
      "illness"=>$row['illnessen'],
      "images"=>$row['images'],
      "treatment"=>$row['treatment_en']);
      echo json_encode($result,JSON_PRETTY_PRINT);
    $illness = $row['illnessen'];

  $sqlinsert = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", \"$illness\")";
  mysqli_query($conn, $sqlinsert);
} else{

  $sqlrecent = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", 'No Response')";
  mysqli_query($conn, $sqlrecent);
  echo "We are sorry we couldn't understand you or could not find a solution please contact a doctor.";
}

$stmt->close();
$conn->close();
?>