
	 <?php
    $conn['host'] = 'localhost'; // Tên server, nếu dùng hosting free thì cần thay đổi
    $conn['dbname'] = 'god99'; // Đây là tên của Database
    $conn['username'] = 'root'; // Tên sử dụng Database
    $conn['password'] = ''; // Mật khẩu của tên sử dụng Database
    @mysql_connect(
        "{$conn['host']}",
        "{$conn['username']}",
        "{$conn['password']}")
    or
        die("web bao tri game zo ok nhế");
    @mysql_select_db(
        "{$conn['dbname']}") 
    or
        die("Không thể chọn database");
$username = "root"; // Khai báo username
$password = "";      // Khai báo password
$server   = "localhost";   // Khai báo server
$dbname   = "god99";      // Khai báo database


$connect = new mysqli($server, $username, $password, $dbname);
if ($connect->connect_error) {
    die("Không kết nối :" . $connect->connect_error);
    exit();
}

?>
