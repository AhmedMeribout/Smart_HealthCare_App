<?php
$con = mysqli_connect("127.0.0.1", "root", "", "si");
if ($con){
    echo "Success";
}else{
    echo "connection failed";
}