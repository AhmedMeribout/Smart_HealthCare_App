<?php
/*
if(!empty($_POST['id'])){
$id=$_POST['id'];
$result=array();
$con = mysqli_connect("127.0.0.1", "root", "", "beta1");
if($con){
    $sql="select * from info where id='".$id."'";
    $res = mysqli_query($con,$sql);
    if(mysqli_num_rows($res)!=0){
        $res = mysqli_fetch_array($res);
        $result=array("status"=>"data fetched","message"=>"login successful","id"=>$row['id'],"firstname"=>$row['firstname']
        ,"lastname"=>$row['lastname'],"age"=>$row['age'],"birth"=>$row['birth'],"gender"=>$row['gender']
        ,"country"=>$row['country'],"city"=>$row['city'],"address"=>$row['address'],"phone"=>$row['phone'],"em_phone"=>$row['em_phone']
        ,"height"=>$row['height'],"weight"=>$row['weight'],"cu_job"=>$row['cu_job'],"pre_job"=>$row['pre_job']
        ,"desease"=>$row['desease'],"id_card"=>$row['id_card'],"bloodtype"=>$row['bloodtype']);
    }else $result = array("status" => "failed", "message"=> "unautherase access");
}else $result = array("status" => "failed", "message"=> "failed to connect");

}else $result = array("status" => "failed", "message"=> "failed");
echo json_encode($result,JSON_PRETTY_PRINT);*/
if(!empty($_POST['id'])){
    $id=$_POST['id'];
    $result=array();
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    if($con){
        $sql="select * from info where id='".$id."'";
        $res = mysqli_query($con,$sql);
        if(mysqli_num_rows($res)!=0){
            $row = mysqli_fetch_array($res);
            $result=array(
                "status"=>"data fetched",
                "message"=>"login successful",
                "id"=>$row['id'],
                "firstname"=>$row['firstname'],
                "lastname"=>$row['lastname'],
                "age"=>$row['age'],
                "birth"=>$row['birth'],
                "gender"=>$row['gender'],
                "country"=>$row['country'],
                "city"=>$row['city'],
                "address"=>$row['address'],
                "phone"=>$row['phone'],
                "em_phone"=>$row['em_phone'],
                "height"=>$row['height'],
                "weight"=>$row['weight'],
                "cu_job"=>$row['cu_job'],
                "pre_job"=>$row['pre_job'],
                "desease"=>$row['desease'],
                "id_card"=>$row['id_card'],
                "bloodtype"=>$row['bloodtype'],
                "image"=>$row['image']
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