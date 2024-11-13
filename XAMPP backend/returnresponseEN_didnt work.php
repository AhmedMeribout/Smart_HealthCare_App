<?php
$servername = "localhost:3306";
$username = "root";
$password = "";
$dbname = "si";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

$speech = $_POST['speech'];
$id = $_POST['id'];
$id=$_POST['id'];
$sqltest = "select balance FROM info where id=$id";
$result = mysqli_query($conn, $sqltest) or die("Error in Selecting " . mysqli_error($connection));
$row = mysqli_fetch_assoc($result);

// Access the balance value
$balance = $row['balance'];



if($balance<5){
    $sqlrecent = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", 'No Response')";
    mysqli_query($conn, $sqlrecent);
  echo 'fund';
}else{
    $symptoms = array(
        "headache" => array("headache", "head hurts"),
        "runny_nose" => array("runny nose", "nose is running"),
        "itching" => array("itching", "itchy skin"),
        "red_eyes" => array("red eyes", "bloodshot eyes"),
        "sneezing" => array("sneezing", "sneezes"),
        "throat" => array("throat", "throat pain"),
        "fever" => array("fever", "high temperature"),
        "tired" => array("tiredness", "fatigue"),
        "taste" => array("loss of taste", "no taste"),
        "vomitting" => array("vomiting", "throwing up"),
        "dizziness" => array("dizziness", "lightheadedness"),
        "diarrhea" => array("diarrhea", "loose stools"),
        "stomach" => array("stomach", "abdominal pain")
    );
    
    // Determine the presence of symptoms
    $conditions = array();
    foreach ($symptoms as $column => $variations) {
        $symptomPresent = false;
        foreach ($variations as $variation) {
            if (stripos($speech, $variation) !== false) {
                $symptomPresent = true;
                break;
            }
        }
        $conditions[$column] = $symptomPresent ? 1 : 0; // Assign 1 for true, 0 for false
    }
    
    // Prepare and execute the SQL query
    $sqlresponse = "SELECT images,level, illnessen, treatment_en FROM illness i, help h, symptoms s WHERE i.illness_id=h.illness_id AND i.illness_id=s.illness_id";
    $sqlconditions = "";
    foreach ($conditions as $column => $value) {
        $sqlconditions .= " AND $column = $value";
    }
    $sqlresponse .= $sqlconditions;
    
    $stmt = $conn->prepare($sqlresponse);
    $stmt->execute();
    $result = $stmt->get_result();
    
    if ($result->num_rows > 0) {
        
        $row = mysqli_fetch_array($result);
        $result = array(
            "level" => $row['level'],
            "illness" => $row['illnessen'],
            "images"=>$row['images'],
            "treatment" => $row['treatment_en']
            
        );
        $sqlupdate = "UPDATE info SET balance = $balance-5 WHERE id = '".$id."';";
        mysqli_query($conn, $sqlupdate);
        echo json_encode($result, JSON_PRETTY_PRINT);
        $illness = $row['illnessen'];
    
        $sqlinsert = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", \"$illness\")";
        mysqli_query($conn, $sqlinsert);
        
    } else {
        $sqlupdate = "UPDATE info SET balance = $balance-5 WHERE id = '".$id."';";
        mysqli_query($conn, $sqlupdate);
        $sqlrecent = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", 'No Response')";
        mysqli_query($conn, $sqlrecent);
        echo "null";
    }

}




$conn->close();
?>
