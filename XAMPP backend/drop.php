<?php
if(!empty($_POST['id'])){
    $id=$_POST['id'];
    $result=array();
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    if($con){
        $sql = "DELETE FROM info WHERE id='$id'";
if (mysqli_query($con, $sql)) {
    echo "Record deleted successfully from 'info' table<br>";
} else {
    echo "Error deleting record: " . mysqli_error($con) . "<br>";
}

// Delete the user from the 'users' table
$sql = "DELETE FROM users WHERE id='$id'";
if (mysqli_query($con, $sql)) {
    echo "Record deleted successfully from 'users' table<br>";
} else {
    echo "Error deleting record: " . mysqli_error($con) . "<br>";
}

// Delete the user from the 'recent' table
$sql = "DELETE FROM recent WHERE id='$id'";
if (mysqli_query($con, $sql)) {
    echo "Record deleted successfully from 'recent' table<br>";
} else {
    echo "Error deleting record: " . mysqli_error($con) . "<br>";
}
    }else {
        
        echo "connection failed";
    }
}else {
    
    echo "Login failed";
}
