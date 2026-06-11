@echo off
REM Run the test program with proper classpath
setlocal enabledelayedexpansion
set SINH_VIEN_JAR=%CD%\..\sinh_vien_lib\target\sinh_vien_lib-1.0-SNAPSHOT.jar
java -cp "target\classes;!SINH_VIEN_JAR!" com.NguyenHuynhMinhTien.test_thuvien_sinhvien.ChuongTrinh
