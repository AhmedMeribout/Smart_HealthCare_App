<?php
$speech = $_POST['speech'];
$command = escapeshellcmd("python ask.py ".$speech);
//$command = escapeshellcmd('ask.py');
$output = shell_exec($command);
echo $output;
?>