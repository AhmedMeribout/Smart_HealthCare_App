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
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
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
<?php
echo "<link href='style.css'>" ;

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
  echo "<table class='styled-table'>";
  echo "<thead>";
  echo "<tr>";
  echo "<th>USER_ID</th>";
  echo "<th>First Name</th>";
  echo "<th>Last Name</th>";
  echo "</tr>";
  echo "</thead>";
  echo "<tbody>";
  while($row = $result->fetch_assoc()) {
    echo "<tr data-href='user.php?id=" . $row['id'] . "'>";
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

<script>
  // Get all table rows with data-href attribute
  var rows = document.querySelectorAll("table.styled-table tbody tr[data-href]");

  // Add a click event listener to each row
  rows.forEach(function(row) {
    row.addEventListener("click", function() {
      // Redirect the user to the new page
      window.location.href = row.getAttribute("data-href");
    });
  });
</script>
