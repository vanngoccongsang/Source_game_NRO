
	 <?php
$username = "root"; // Khai báo username
$password = "";      // Khai báo password
$server   = "127.0.0.1";   // Khai báo server
$dbname   = "nrolau";      // Khai báo database


$connect = new mysqli($server, $username, $password, $dbname);
if ($connect->connect_error) {
    die("Không kết nối :" . $connect->connect_error);
}
?>
