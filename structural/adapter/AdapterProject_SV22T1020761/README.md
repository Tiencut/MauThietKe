# AdapterProject

## Chạy dự án

```bash
# Build
mvn clean install -DskipTests

# Chạy ứng dụng
mvn -pl App exec:java
```

## Cấu trúc
- **CongNhanLib**: Thư viện cho công nhân
- **SinhVienLib**: Thư viện cho sinh viên
- **App**: Ứng dụng chính (Adapter Pattern)