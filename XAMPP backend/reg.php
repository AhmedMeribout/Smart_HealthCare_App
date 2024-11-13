<?php
/*if (!empty($_POST['email'])&&!empty($_POST['password'])){
    $pass="1234";
    $con=mysqli_connect("127.0.0.1","root","","beta1");
    $firstname=$_POST['firstname'];
    $email=$_POST['email'];
    $password=$_POST['password'];
    $lastname=$_POST['lastname'];
    $age=$_POST['age'];
    $birth=$_POST['birth'];
    //$gender=$_POST['gender'];
    $country=$_POST['country'];
    $city=$_POST['city'];
    $address=$_POST['address'];
    $phone=$_POST['phone'];
    $em_phone=$_POST['em_phone'];
    $height=$_POST['height'];
    $weight=$_POST['weight'];
    $cu_job=$_POST['cu_job'];
    $pre_job=$_POST['pre_job'];
    $desease=$_POST['desease'];
    $id_card=$_POST['id_card'];
    if ($con){
    //$sql="insert into users (email,password) values ('".$email."','".$password."')";
    //if(mysqli_query($con,$sql)){
    //    echo "Success";
    //}else echo "Error reg1";
    //$id="select id from users where email='".$email."'"; 
    $sql1="insert into info (firstname,lastname) values('".$firstname."',
    '".$lastname."')";
    if(mysqli_query($con,$sql1)){
        echo "Success";
    }else echo "Error reg2";
    }else echo "error connecting";
}else echo "all users";*/
/*if (!empty($_POST['email']) && !empty($_POST['password'])) {
    $con = mysqli_connect("127.0.0.1", "root", "", "beta1");
    $firstname = $_POST['firstname'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $lastname = $_POST['lastname'];
    $age = $_POST['age'];
    $birth = $_POST['birth'];
    $country = $_POST['country'];
    $city = $_POST['city'];
    $address = $_POST['address'];
    $phone = $_POST['phone'];
    $em_phone = $_POST['em_phone'];
    $height = $_POST['height'];
    $weight = $_POST['weight'];
    $cu_job = $_POST['cu_job'];
    $pre_job = $_POST['pre_job'];
    $desease = $_POST['desease'];
    $id_card = $_POST['id_card'];
    if ($con) {
        $sql = "insert into users (email, password) values ('".$email."', '".$password."')";
        if (mysqli_query($con, $sql)) {
            echo "Success";
            $id = mysqli_insert_id($con);
            $sql1 = "insert into info (id, firstname, lastname, age, birth,country,city,address,phone,em_phone,height,weight,cu_job,pre_job,desease,id_card) values 
            ('".$id."', '".$firstname."', '".$lastname."', '".$age."', '".$birth."','".$country."','".$city."','".$address."','".$phone."','".$em_phone."','".$height."',
            '".$weight."','".$cu_job."','".$pre_job."','".$desease."','".$id_card."')";
            if (mysqli_query($con, $sql1)) {
                echo "Success";
            } else {
                echo "Error reg2";
            }
        } else {
            echo "Error reg1";
        }
    } else {
        echo "Error connecting";
    }
} else {
    echo "All fields are required";
}*/

/*if (!empty($_POST['email']) && !empty($_POST['password'])) {
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    $firstname = $_POST['firstname'];
    $email = $_POST['email'];
    $password = password_hash($_POST['password'],PASSWORD_DEFAULT);
    $lastname = $_POST['lastname'];
    //$age = $_POST['age'];
    $birth = $_POST['birth'];
    $country = $_POST['country'];
    $city = $_POST['city'];
    $address = $_POST['address'];
    $phone = $_POST['phone'];
    $em_phone = $_POST['em_phone'];
    $height = $_POST['height'];
    $weight = $_POST['weight'];
    $cu_job = $_POST['cu_job'];
    //$pre_job = $_POST['pre_job'];
    $desease = $_POST['desease'];
    $id_card = $_POST['id_card'];
    $gender=$_POST['gender'];
    $bloodtype=$_POST['bloodtype'];
    $path='images/'.date("d-m-Y").'-'.time().'-'.rand(10000,10000).'.jpg';
    //$path=date("d-m-Y").'-'.time().'-'.rand(10000,10000).'.jpg';
    if ($con) {
        $sql = "insert into users (email, password) values ('".$email."', '".$password."')";
        if (mysqli_query($con, $sql)) {
            echo "Success";
            $id = mysqli_insert_id($con);
            if (file_put_contents($path, base64_decode($_POST['image']))) {
                $sql1 = "INSERT INTO info (id, firstname, lastname, birth,age, country, city, address, phone, em_phone, height, weight, desease, id_card, gender, bloodtype,image,cu_job) VALUES 
                ('$id', '$firstname', '$lastname',  '$birth',TIMESTAMPDIFF(YEAR, '$birth', CURDATE()), '$country', '$city', '$address', '$phone', '$em_phone', '$height', '$weight', 
                  '$desease', '$id_card', '$gender', '$bloodtype', '$path','$cu_job')";
            
                }else $sql1 = "INSERT INTO info (id, firstname, lastname, birth,age ,country, city, address, phone, em_phone, height, weight,  desease, id_card, gender, bloodtype,cu_job) VALUES 
                ('$id', '$firstname', '$lastname',  '$birth',TIMESTAMPDIFF(YEAR, '$birth', CURDATE()), '$country', '$city', '$address', '$phone', '$em_phone', '$height', '$weight', 
                  '$desease', '$id_card', '$gender', '$bloodtype','$cu_job')";
            if (mysqli_query($con, $sql1)) {
                echo "Success";
            } else {
                echo "Error reg2";
            }
        } else {
            echo "Duplicated Email";
        }
    } else {
        echo "Error connecting";
    }
} else {
    echo "All fields are required";
}*/
if (!empty($_POST['email']) && !empty($_POST['password'])) {
    $con = mysqli_connect("127.0.0.1", "root", "", "si");
    $firstname = $_POST['firstname'];
    $email = $_POST['email'];
    $password = password_hash($_POST['password'], PASSWORD_DEFAULT);
    $lastname = $_POST['lastname'];
    $birth = $_POST['birth'];
    $country = $_POST['country'];
    $city = $_POST['city'];
    $address = $_POST['address'];
    $phone = $_POST['phone'];
    $em_phone = $_POST['em_phone'];
    $height = $_POST['height'];
    $weight = $_POST['weight'];
    $cu_job = $_POST['cu_job'];
    $desease = $_POST['desease'];
    $id_card = $_POST['id_card'];
    $gender = $_POST['gender'];
    $bloodtype = $_POST['bloodtype'];
    $path = 'images/' . date("d-m-Y") . '-' . time() . '-' . rand(10000, 99999) . '.jpg';

    if ($con) {
        $sql = "INSERT INTO users (email, password) VALUES ('$email', '$password')";

        if (mysqli_query($con, $sql)) {
            echo "Success";
            $id = mysqli_insert_id($con);

            if (file_put_contents($path, base64_decode($_POST['image']))) {
                $age = floor((time() - strtotime($birth)) / 31556926);
                $sql1 = "INSERT INTO info (id, firstname, lastname, birth, age, country, city, address, phone, em_phone, height, weight, desease, id_card, gender, bloodtype, image, cu_job) 
                        VALUES ('$id', '$firstname', '$lastname', '$birth', '$age', '$country', '$city', '$address', '$phone', '$em_phone', '$height', '$weight', '$desease', '$id_card', 
                        '$gender', '$bloodtype', '$path', '$cu_job')";
            } else {
                $age = floor((time() - strtotime($birth)) / 31556926);
                $sql1 = "INSERT INTO info (id, firstname, lastname, birth, age, country, city, address, phone, em_phone, height, weight, desease, id_card, gender, bloodtype, cu_job) 
                        VALUES ('$id', '$firstname', '$lastname', '$birth', '$age', '$country', '$city', '$address', '$phone', '$em_phone', '$height', '$weight', '$desease', '$id_card', 
                        '$gender', '$bloodtype', '$cu_job')";
            }

            if (mysqli_query($con, $sql1)) {
                echo "Success";
            } else {
                echo "Error reg2";
            }
        } else {
            echo "Duplicated Email";
        }
    } else {
        echo "Error connecting";
    }
} else {
    echo "All fields are required";
}
?>

/*if (!empty($_POST['email']) && !empty($_POST['password'])) {
    $con = mysqli_connect("127.0.0.1", "root", "", "beta1");
    if (!$con) {
        echo "Error connecting";
        exit;
    }

    $firstname = $_POST['firstname'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $lastname = $_POST['lastname'];
    $age = $_POST['age'];
    $birth = $_POST['birth'];
    $country = $_POST['country'];
    $city = $_POST['city'];
    $address = $_POST['address'];
    $phone = $_POST['phone'];
    $em_phone = $_POST['em_phone'];
    $height = $_POST['height'];
    $weight = $_POST['weight'];
    $cu_job = $_POST['cu_job'];
    $pre_job = $_POST['pre_job'];
    $desease = $_POST['desease'];
    $id_card = $_POST['id_card'];
    $gender = $_POST['gender'];
    $bloodtype = $_POST['bloodtype'];
    $path = 'images/' . date("d-m-Y ") . '-' . time() . '-' . rand(10000, 10000) . '.jpg';

    if (isset($_POST['image'])) {
        if (file_put_contents($path, base64_decode($_POST['image']))) {
            $sql = "INSERT INTO users (email, password, image) VALUES ('$email', '$password', '$path')";
            
        } else {
            $sql = "INSERT INTO users (email, password) VALUES ('$email', '$password')";
        }
    } else {
        $sql = "INSERT INTO users (email, password) VALUES ('$email', '$password')";
    }
    
    if (mysqli_query($con, $sql)) {
        $id = mysqli_insert_id($con);
        if (file_put_contents($path, base64_decode($_POST['image']))) {
            $sql1 = "INSERT INTO info (id, firstname, lastname, age, birth, country, city, address, phone, em_phone, height, weight, cu_job, pre_job, desease, id_card, gender, bloodtype,image) VALUES 
            ('$id', '$firstname', '$lastname', '$age', '$birth', '$country', '$city', '$address', '$phone', '$em_phone', '$height', '$weight', '$cu_job',
             '$pre_job', '$desease', '$id_card', '$gender', '$bloodtype', '$path')";
        
            }else $sql1 = "INSERT INTO info (id, firstname, lastname, age, birth, country, city, address, phone, em_phone, height, weight, cu_job, pre_job, desease, id_card, gender, bloodtype) VALUES 
            ('$id', '$firstname', '$lastname', '$age', '$birth', '$country', '$city', '$address', '$phone', '$em_phone', '$height', '$weight', '$cu_job',
             '$pre_job', '$desease', '$id_card', '$gender', '$bloodtype')";
        if (mysqli_query($con, $sql1)) {
            echo "Success";
        } else {
            echo "Error reg2";
        }
    } else {
        echo "Error reg1";
    }

    mysqli_close($con);
} else {
    echo "All fields are required";
}*/
?>
