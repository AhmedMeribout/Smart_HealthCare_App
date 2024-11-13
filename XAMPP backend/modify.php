<?php
if (!empty($_POST['id'])) {
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    $id = $_POST['id'];
    $weight = $_POST['weight'];
    $height = $_POST['height'];
    
    if ($con) {
            $sql = "UPDATE info SET weight = '".$weight."', height = '".$height."' WHERE id = '".$id."';";
        
        if (mysqli_query($con, $sql)) {
            echo "Success";
            
        } else {
            echo "Error reg1";
        }
    } else {
        echo "Error connecting";
    }
} else {
    echo "All fields are required";
}