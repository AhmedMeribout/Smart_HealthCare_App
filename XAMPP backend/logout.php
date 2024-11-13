<?php
/*if(!empty($_POST['email'])&&!empty($_POST['apikey'])){
$email=$_POST['email'];
$apikey=$_POST['apikey'];
$con = mysqli_connect("127.0.0.1", "root", "", "beta1");
if($con){
    $sql="select * from users where email='".$email."'and apikey='".$apikey."'";
    $res = mysqli_query($con,$sql);
    if(mysqli_num_rows($res)!=0){
        $res = mysqli_fetch_array($res);
        $sqlUpdate="update users set apikey=''where email='".$email."'";
        if(mysqli_query($con,$sqlUpdate)){
            echo "success";
        }else echo "error login";
    }else echo "error uthorization";
}else echo "errordatabase connection error";

}else echo 'error';*/
if (!empty($_POST['email']) && !empty($_POST['apikey'])) {
    $email = $_POST['email'];
    $apikey = $_POST['apikey'];

    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    if ($con) {
        $sql = "SELECT * FROM users WHERE email='".$email."' AND apikey='".$apikey."'";
        $res = mysqli_query($con, $sql);
        if (mysqli_num_rows($res) != 0) {
            $sqlUpdate = "UPDATE users SET apikey='' WHERE email='".$email."'";
            if (mysqli_query($con, $sqlUpdate)) {
                echo "success";
            } else {
                echo "error updating apikey";
            }
        } else {
            echo "error authorization";
        }
    } else {
        echo "error database connection error";
    }
} else {
    echo "error missing parameters";
}
