# TVStatePatternDemo

## 1. Ten de tai

Cai dat chuong trinh quan ly trang thai cua TV bang mau thiet ke State Pattern.

## 2. Mo ta bai toan

Doi tuong `TV` co nhieu trang thai khac nhau:

- `OFF`: TV dang tat
- `ON`: TV dang bat
- `MUTE`: TV dang bat nhung bi tat tieng

Nguoi dung co the thuc hien cac hanh dong:

- Bam nut ON
- Bam nut OFF
- Bam nut MUTE

Moi trang thai se xu ly cac hanh dong theo cach khac nhau.

Vi du:

- Neu TV dang `OFF`, bam `ON` thi chuyen sang `ON`.
- Neu TV dang `ON`, bam `MUTE` thi chuyen sang `MUTE`.
- Neu TV dang `MUTE`, bam `MUTE` lan nua thi tro ve `ON`.
- Neu TV dang `OFF`, bam `MUTE` thi khong co tac dung.

## 3. Cau truc thu muc

```text
TVStatePatternDemo/
│
├── src/
│   └── com/
│       └── NguyenHuynhMinhTien/
│
│           ├── normal/
│           │   ├── TV.java
│           │   └── DemoBasicImplementation.java
│           │
│           └── statepattern/
│               ├── state/
│               │   ├── ITrangThai.java
│               │   ├── TrangThaiON.java
│               │   ├── TrangThaiOFF.java
│               │   └── TrangThaiMUTE.java
│               │
│               ├── context/
│               │   └── TV.java
│               │
│               └── DemoStatePattern.java
│
└── README.md
```

## 4. Cach cai dat thong thuong

Package:

```text
com.NguyenHuynhMinhTien.normal
```

Lop `TV` quan ly trang thai bang bien so nguyen:

- `TRANG_THAI_OFF`
- `TRANG_THAI_ON`
- `TRANG_THAI_MUTE`

Cac phuong thuc `bamNutON`, `bamNutOFF`, `bamNutMUTE` dung `switch-case` de xu ly.

Nhuoc diem:

- Code dai.
- Kho bao tri.
- Neu them trang thai moi thi phai sua nhieu `switch-case`.
- De vi pham nguyen ly Open/Closed Principle.

## 5. Cach cai dat bang State Pattern

Package:

```text
com.NguyenHuynhMinhTien.statepattern
```

Cac thanh phan chinh:

| Thanh phan | Vai tro |
|---|---|
| `TV` | Context |
| `ITrangThai` | State interface |
| `TrangThaiON` | Concrete State |
| `TrangThaiOFF` | Concrete State |
| `TrangThaiMUTE` | Concrete State |

Trong cach nay, lop `TV` khong can tu xu ly tat ca logic bang `switch-case`.
Thay vao do, `TV` uy quyen viec xu ly hanh dong cho doi tuong trang thai hien tai.

## 6. Cach chay bang terminal

Dung lenh sau tai thu muc goc project:

```bash
javac -encoding UTF-8 -d out src/com/NguyenHuynhMinhTien/normal/*.java src/com/NguyenHuynhMinhTien/statepattern/*.java src/com/NguyenHuynhMinhTien/statepattern/context/*.java src/com/NguyenHuynhMinhTien/statepattern/state/*.java
```

Chay phien ban thong thuong:

```bash
java -cp out com.NguyenHuynhMinhTien.normal.DemoBasicImplementation
```

Chay phien ban State Pattern:

```bash
java -cp out com.NguyenHuynhMinhTien.statepattern.DemoStatePattern
```

## 7. Ket luan

Mau thiet ke State Pattern giup tach logic xu ly theo tung trang thai ra cac class rieng.
Cach lam nay giup code ro rang hon, de mo rong hon va han che viec dung qua nhieu cau lenh `if-else` hoac `switch-case`.
