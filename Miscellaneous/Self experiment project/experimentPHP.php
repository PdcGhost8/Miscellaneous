<?php
//Connecting to sql db.
$connect = mysqli_connect("localHost","root","toor","hourstracker");
//Sending form data to sql db.
mysqli_query($connect,"INSERT INTO posts (first name,last name,employee number, password,date, hours )
VALUES ('$_POST[fname]', '$_POST[lname]', '$_POST[lid]', '$_POST[lpass]','$_POST[ldate]','$_POST[lhour]')";
?>