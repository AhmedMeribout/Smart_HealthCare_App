<!DOCTYPE html>
<?php
$doctor_id=$_GET['doctor'];
$id= $_GET['id'];
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "si";
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// Fetch data from database
//$sql = "SELECT * FROM recent where ";
$sql = "SELECT * FROM info where id=$id";
$result = $conn->query($sql);

// Display data in table
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();

    $sql = "SELECT * FROM recent where user_id=$id";
$result = $conn->query($sql);
?>
<style>
    body{
        background-color: white;
 
    }
    h1{
        font-family: sans-serif;
        color: lightseagreen;
    }

    .styled-table {
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 50px;
    border-collapse: collapse;
    font-size: 0.9em;
    font-family: sans-serif;
    width: 100%;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #28a745;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}
.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}
</style>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Patient</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:300;400;600;700;800&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/styleform.css" rel="stylesheet">
    </head>

    <body>
    <div class="overlay" id="divOne">
		<div class="wrapper1">
			<h2>Please Fill up The Form</h2><a class="close" href="#">&times;</a>
			<div class="content">
				<div class="container">
					<form action="submit.php">
                    <input type="hidden" name="user_id" value="<?php echo $id; ?>">
                        <input type="hidden" name="doctor_id" value="<?php echo $doctor_id; ?>">

						<label>Subject</label> 
						<textarea name="message" iplaceholder="Write something.."></textarea>
						<input type="submit" value="Submit">
					</form>
				</div>
			</div>
		</div>
	</div>
        <div class="wrapper" style='position: relative;z-index: -1;'>
            <div class="sidebar">
                <div class="sidebar-text d-flex flex-column h-100 justify-content-center text-center">
                <img class="mx-auto d-block w-75 bg-success img-fluid rounded-circle mb-4 p-3" src="../../si/<?php echo $row['image']?>"  alt="Image">

                    <h1 class="font-weight-bold"><?php echo $row['firstname'].' '.$row['lastname'] ?></h1>
                    <p class="mb-4">
                        Justo stet no accusam stet invidunt sanctus magna clita vero eirmod, sit sit labore dolores lorem. Lorem at sit dolor dolores sed diam justo
                    </p>
                    <!--
                    <div class="d-flex justify-content-center mb-5">
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                    -->
                    <a href="#divOne" class="btn btn-lg btn-block btn-primary mt-auto">Message Me</a>
                </div>
                <div class="sidebar-icon d-flex flex-column h-100 justify-content-center text-right">
                    <i class="fas fa-2x fa-angle-double-right" style='color:#28a745;'></i>
                </div>
            </div>
            <div class="content" style='z-index: 0;'>
                <!-- Navbar Start -->
<?php

// Display data in table
if ($result->num_rows > 0) {
  echo "<table class='styled-table'>";
  echo "<thead>";
  echo "<tr style='position: sticky;top: 30px;'>";
  echo "<th>Diagnose_ID</th>";
  echo "<th>Speech</th>";
  echo "<th>Response</th>";
  echo "<th>Time</th>";
  echo "</tr>";
  echo "</thead>";
  echo "<tbody>";
  while($row = $result->fetch_assoc()) {

        echo "<tr postion: sticky;'>";
        echo "<td>" . $row["diagnose_id"] . "</td>";
        echo "<td>" . $row["speech"] . "</td>";
        echo "<td>" . $row["response"] . "</td>";
        echo "<td>" . $row["time"] . "</td>";
        echo "</tr>";

    
  }
  echo "</tbody>";
  echo "</table>";
} else {
  echo "No data found.";
}
}

// Close database connection
$conn->close();
?>
                <!-- Footer End -->
            </div>
        </div>
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-angle-double-up " style='color:#28a745;'></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
