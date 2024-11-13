<?php
if(!empty($_POST['id'])){
    $id=$_POST['id'];
    $result=array();
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    if($con){
        $sql="select * from doctors where id='".$id."'";
        $res = mysqli_query($con,$sql);
        if(mysqli_num_rows($res)!=0){
            $row = mysqli_fetch_array($res);
            $result=array(
                "status"=>"data fetched",
                "message"=>"login successful",
                "name"=>$row['name']
                ,"speciality"=>$row['speciality']
                ,"phone"=>$row['phone']
                ,"doctor_desc"=>$row['doctor_desc']
                ,"email"=>$row['email']
            );
        }else {
            $result = array(
                "status" => "failed",
                "message"=> "unauthorized access"
            );
        }
    }else {
        $result = array(
            "status" => "failed",
            "message"=> "failed to connect"
        );
    }
}else {
    $result = array(
        "status" => "failed",
        "message"=> "failed"
    );
}
echo json_encode($result,JSON_PRETTY_PRINT);