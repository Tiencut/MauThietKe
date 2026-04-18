# Script to run the test program with proper classpath
$SINH_VIEN_JAR = Resolve-Path "..\sinh_vien_lib\target\sinh_vien_lib-1.0-SNAPSHOT.jar"
java -cp "target\classes;$SINH_VIEN_JAR" com.NguyenHuynhMinhTien.test_thuvien_sinhvien.ChuongTrinh
