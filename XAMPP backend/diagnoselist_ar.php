<?php
$servername = "localhost:3306";
$username = "root";
$password = "";
$dbname = "si";

// Create connection
$connection = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

// Fetch symptoms from the POST request
$speech = $_POST['speech'];
$symptoms = [
    'راسي يوجع',
    'خشمي',
    'عيني',
    'نعطس',
    'نحك',
    'حنجر',
    'حراره مرتفعه',
    'حادث مرور',
    'غلبان',
    'ذوق',
    'تقي',
    'دوخ',
    'كرشي',
    'كرشي جاريه'
];

// Build the dynamic query
$query = "SELECT symptomar, treatmentar, photo, symptom_id 
          FROM simple_symptoms 
          WHERE ";

$conditions = [];
$params = [];

foreach ($symptoms as $symptom) {
    if (str_contains($speech, $symptom)) {
        $conditions[] = "symptomen LIKE ?";
        $params[] = "%$symptom%";
    }
}

$query .= implode(' OR ', $conditions);

$stmt = $connection->prepare($query);

// Bind the parameters dynamically
if (!empty($params)) {
    $types = str_repeat('s', count($params));
    $stmt->bind_param($types, ...$params);
}

$stmt->execute();
$result = $stmt->get_result();
$emparray = array();

while ($row = mysqli_fetch_assoc($result)) {
    $emparray[] = $row;
}

// Close the database connection
$stmt->close();
$connection->close();

echo json_encode($emparray);
?>
