<?php
/*if (!empty($_POST['email'])&& !empty($_POST['password'])) {
    $email = $_POST['email'];
    $password=  $_POST['password'];

    $result=array();
    $con = mysqli_connect("127.0.0.1", "root", "", "beta1");
    if ($con){
    $sql="select * from users where email='".$email."'";
    $res = mysqli_query($con,$sql);
    if(mysqli_num_rows($res)!=0){
        $row=mysqli_fetch_assoc($res);
        if($email==$row['email']&&$password=$row['password']){
            try{
                $apihey=bin2hex(random_bytes(23));}
            catch(Exception ){
                $apihey=bin2hex(uniqid($email,true));
            }
            $sqlUpdate ="update users set apikey='".$apihey."'where email='".$email."'";
            if (mysqli_query($con,$sqlUpdate)){
                $result=array("status"=>"success","message"=>"login successful","name"=> $row['name'],"email"=>$row['email'],
                "apikey"=>$row['apikey'],"id"=>$row['id']);//"apikey"=>$row['apikey']
            }else $result = array("status" => "failed", "message"=> "login failed try again");
        }else $result = array("status" => "failed", "message"=> "false username or pass");
    }else $result = array("status" => "failed", "message"=> "false username or passworddd");
    }else $result = array("status" => "failed", "message"=> "connection failed");
}else $result = array("status" => "failed", "message"=> "all failed");
echo json_encode($result,JSON_PRETTY_PRINT);*/
if (!empty($_POST['email']) && !empty($_POST['password'])) {
    $email = $_POST['email'];
    $password = $_POST['password'];
    //$location = $_POST['location'];

    $result = array();
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    if ($con) {
        $sql = "SELECT * FROM users WHERE email='".$email."'";
        $res = mysqli_query($con, $sql);
        if (mysqli_num_rows($res) != 0) {
            $row = mysqli_fetch_assoc($res);
            if ($email == $row['email'] &&  password_verify($password,$row['password'])) {
                try {
                    $apihey = bin2hex(random_bytes(23));
                } catch (Exception $e) {
                    $apihey = bin2hex(uniqid($email, true));
                }
                $sqlUpdate = "UPDATE users SET apikey='".$apihey."' WHERE email='".$email."'";
                if (mysqli_query($con, $sqlUpdate)) {
                    $result = array(
                        "status" => "success",
                        "message" => "login successful",
                        //"name" => $row['name'],
                        "email" => $row['email'],
                        "apikey" => $apihey,
                        "id" => $row['id']
                    );
                    $id=$row['id'];
                    $sqltime = "UPDATE info SET last_connection_time=CURRENT_TIMESTAMP() WHERE id= $id";
                    mysqli_query($con, $sqltime);
                } else {
                    $result = array(
                        "status" => "failed",
                        "message" => "login failed try again"
                    );
                }
            } else {
                $result = array(
                    "status" => "failed",
                    "message" => "false username or password"
                );
            }
        } else {
            $result = array(
                "status" => "failed",
                "message" => "false username or password"
            );
        }
    } else {
        $result = array(
            "status" => "failed",
            "message" => "connection failed"
        );
    }
} else {
    $result = array(
        "status" => "failed",
        "message" => "all fields are required"
    );
}
echo json_encode($result, JSON_PRETTY_PRINT);
