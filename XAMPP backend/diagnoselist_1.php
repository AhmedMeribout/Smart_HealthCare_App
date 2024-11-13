<?php
      $servername = "localhost:3306";
      $username = "root";
      $password = "";
      $dbname = "si";
    
      // Create connection
      $connection = new mysqli($servername, $username, $password, $dbname);

    //fetch table rows from mysql db
    $speech=$_POST['speech'];
  $headache = str_contains($speech, 'headache');
  $nose = str_contains($speech, 'runny nose');
  $eyes = str_contains($speech, 'red eyes');
  $sneezing = str_contains($speech, 'sneez');
  $itching = str_contains($speech, 'itching');
  $throat = str_contains($speech, 'throat');
  $fever = str_contains($speech, 'fever');
    $sqlresponse = "SELECT symptomen,treatmenten,photo,symptom_id FROM simple_symptoms WHERE  headache=? or runny_nose=? or itching=? or red_eyes=? or sneezing=? or throat=? or fever=?";
    $stmt = $connection->prepare($sqlresponse);
    $stmt->bind_param("iiiiiii", $headache,$nose,$itching, $eyes,$sneezing,$throat,$fever);
    $stmt->execute();
    $result = $stmt->get_result();
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    echo json_encode($emparray);

    //close the db connection
    mysqli_close($connection);
?>