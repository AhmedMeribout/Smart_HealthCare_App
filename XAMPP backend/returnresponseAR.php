<?php
  $servername = "localhost";
  $username = "root";
  $password = "";
  $dbname = "si";

  // Create connection
  $conn = new mysqli($servername, $username, $password, $dbname);

  $speech = $_POST['speech'];
  $id=$_POST['id'];
  $headache = str_contains($speech, 'راسي يوجع');
  //$accident = str_contains($speech, 'حادث مرور');
  $nose = str_contains($speech, 'خشمي');
  $eyes = str_contains($speech, 'عيني');
  $sneezing = str_contains($speech, 'نعطس');
  $itching = str_contains($speech, 'نحك');
  $throat = str_contains($speech, 'حنجر');
  $fever = str_contains($speech, 'حراره مرتفعه');
  $accident = str_contains($speech, 'حادث مرور');
  $tired = str_contains($speech, 'غلبان');
  $taste=str_contains($speech, 'ذوق');
  $vomiting = str_contains($speech, 'تقي');
  $deziness = str_contains($speech, 'دوخ');
  $diarreah = str_contains($speech, 'كرشي');
  $stomach = str_contains($speech, 'كرشي جاريه');
  
  $sqlresponse = "SELECT images,level,illnessar,treatment_ar FROM illness i,help h,symptoms s WHERE i.illness_id=h.illness_id and i.illness_id=s.illness_id and  headache=? and runny_nose=? and itching=? and red_eyes=? and sneezing=? and throat=? and fever=? and tired=? and taste=? and vomitting=? and dizziness=? and diarrhea=? and stomach=?";
  $stmt = $conn->prepare($sqlresponse);
  $stmt->bind_param("iiiiiiiiiiiii", $headache,$nose,$itching, $eyes,$sneezing,$throat,$fever,$tired,$taste,$vomiting,$deziness,$diarreah,$stomach);
  $stmt->execute();
  $result = $stmt->get_result();

  if ($result->num_rows > 0) {
      $row = mysqli_fetch_array($result);

      $result=array(
        "level"=>$row['level'],
        "illness"=>$row['illnessar'],
        "images"=>$row['images'],
        "treatment"=>$row['treatment_ar']);
        echo json_encode($result,JSON_PRETTY_PRINT);
      $illness = $row['illnessen'];

    $sqlinsert = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", \"$illness\")";
    mysqli_query($conn, $sqlinsert);
  } else {
    $sqlrecent = "INSERT INTO recent (user_id, time, speech, response) VALUES ($id, current_timestamp(), \"$speech\", 'No Response')";
    mysqli_query($conn, $sqlrecent);
    echo "أنا آسف لأنني لم أستطع فهمك أو لم نجد حلاً. الرجاء الاتصال بالطبيب.";
  }

  $stmt->close();
  $conn->close();
?>