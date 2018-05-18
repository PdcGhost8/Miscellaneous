<?php
session_start(); // Starting Session
$error=''; // Variable To Store Error Message
if (isset($_post['post'])) {

}

{
// Define $username and $password
$fname=$_GET['fname'];
$lname=$_GET['lname'];
$lid=$$_GET['lid'];
$lpass=$$_GET['lpass'];
$ldate=$$_GET['ldate'];
$ljob=$$_GET['ljob'];
$lhour=$$_GET['lhour'];
// Establishing Connection with Server by passing server_name, user_id and password as a parameter
$connection = mysql_connect("localhost", "root", "toor");
// To protect MySQL injection for Security purpose
                                            
$fname=stripslashes($fname);
$lname=stripslashes($lname);
$lid=stripslashes($lid);
$lpass=stripslashes($lpass);
$ldate=stripslashes($ldate);
$ljob=stripslashes($ljob);
$lhour=stripslashes($lhour);
$fname = mysql_real_escape_string($fname);
$lname = mysql_real_escape_string($lname);
$lid = mysql_real_escape_string($lid);
$lpass = mysql_real_escape_string($lpass);
$ldate = mysql_real_escape_string($ldate);
$ljob = mysql_real_escape_string($ljob);
$lhour=mysql_real_escape_string($lhour);
// Selecting Database
$db = mysql_select_db("hourstracker", $connection);
// SQL query to fetch information of registerd users and finds user match.

$query = "INSERT INTO employees (firstname, lastname, password, employeeNumber)
VALUES ('fname', 'lname', 'lpass', 'lid')";
$sql = "INSERT INTO jobdetails (employeenumber, date, job, hours)
VALUES ('lid', 'ldate', 'ljob', 'lhour')";
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
/*
$query = "INSERT fname, lname, lpass, lid 
TO employees 
WHERE firstName='$fname' AND lastName='$lname' AND password= '$lpass' AND employeeNumber= '$lid' 
UNION
INSERT lid, ldate, ljob, lhour
To jobdetails
WHERE employeeNumber='$lid' AND date='$ldate' AND job= '$ljob' AND hours= '$lhour'";
 */
//table 2 is jobdetails
$rows = mysql_num_rows($query);
if ($rows == 1) {
$_SESSION['employee_user']=$lpass; // Initializing Session
header("location: redirect.php"); // Redirecting To Other Page
} else {
$error = "your infomation is invalid";
}
mysql_close($connection); // Closing Connection
}

?>