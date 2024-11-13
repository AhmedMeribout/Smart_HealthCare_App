<?php 
session_start();

if (isset($_SESSION['id']) && isset($_SESSION['user_name'])) {

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/datatables.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Doctor Website</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a><span class="glyphicon glyphicon-user"></span> Hello, <?php echo $_SESSION['name'];?></a></li>
      <li><a href="logout.php"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
        <div class="row">
            <div class="col-12">
                <div class="data_table">
                <?php
//echo "<link href='style.css'>" ;

// Connect to database
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
$sql = "SELECT * FROM info";
$result = $conn->query($sql);

// Display data in table
if ($result->num_rows > 0) {
  echo "<table id='example' class='table table-striped table-bordered'>";
  echo "<thead class='table-dark'>";
  echo "<tr>";
  echo "<th>USER_ID</th>";
  echo "<th>First Name</th>";
  echo "<th>Last Name</th>";
  echo "</tr>";
  echo "</thead>";
  echo "<tbody>";
  while($row = $result->fetch_assoc()) {
    echo "<tr data-href='http://localhost/doctor/test/user.php?doctor=".$_SESSION['id']."&id=" . $row['id'] . "'>";
    echo "<td>" . $row["id"] . "</td>";
    echo "<td>" . $row["firstname"] . "</td>";
    echo "<td>" . $row["lastname"] . "</td>";
    echo "</tr>";
  }
  echo "</tbody>";
  echo "</table>";
} else {
  echo "No data found.";
}

// Close database connection
$conn->close();
?>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/jquery-3.6.0.min.js"></script>
    <script src="assets/js/datatables.min.js"></script>
    <script src="assets/js/pdfmake.min.js"></script>
    <script src="assets/js/vfs_fonts.js"></script>
    <script src="assets/js/custom.js"></script>
</html>
<?php 
}else{
     header("Location: index.php");
     exit();
}
 ?>
 <script>
  // Get all table rows with data-href attribute
  var rows = document.querySelectorAll("table#example tbody tr[data-href]");

  // Add a click event listener to each row
  rows.forEach(function(row) {
    row.addEventListener("click", function() {
      // Redirect the user to the new page
      window.location.href = row.getAttribute("data-href");
    });
  });
</script>
