# Mẫu SBuilder

## 1. Đặt vấn đề

Giả sử cần xây dựng class `Bánh` với các thuộc tính `đường`, `muối`, `vani`, `nướcDừa`, `cacao`, `tiêu`, `ớt`. Các thuộc tính này thể hiện khối lượng nguyên liệu để làm nên một chiếc bánh.

Khai báo ban đầu của class này là như sau:

```java
public class Bánh {
	// thuộc tính bắt buộc có
	private double đường;
	private double bột;
	
	// thuộc tính tuỳ chọn
	private double vani;
	private double nướcDừa;
	private double cacao;
	private double ớt;
	private double tiêu;
}
```

Giả sử rằng, hai thuộc tính đường và bột là bắt buộc phải có còn các thuộc tính còn lại là tuỳ chọn, nếu không thiết lập thì nhận giá trị `0.0`. Chúng ta có thể tạo ra nhiều constructor cho class này, kiểu như:

```java
public Bánh(double duong, double bot) { /// }
public Bánh(double duong, double bot, double vani) { /// }
public Bánh(double duong, double bot, double vani, double cacao) { /// }
///
```

Có hai vấn đề:

- Thứ nhất, với nhiều thuộc tính của class `Bánh`, chúng ta có nhiều tổ hợp đối số, do đó sẽ phải tạo ra rất nhiều constructor! → Có 5 thuộc tính tuỳ chọn → $C^0_5 + C^1_5 + \dots + C^5_5 = 2^6$ hàm dựng khác nhau!!!
- Thứ hai, lời gọi sử dụng constructor để khởi tạo đối tượng `Bánh` trông rất khó nhìn, chẳng hạn:
    
    ```java
    Bánh x = new Bánh(1.2, 3, 0, 5, 1.5); // Jetbrain IntelliJ
    
    Bánh y;
    double duong = 1.2;
    double bot = 3;
    double vani = 0;
    ///
    y = new Bánh(duong, bot, vani, ..)
    ```
    
    👉 Khi nhìn vào code, chúng ta khó có thể biết được các giá trị `0` , `5`, `1.5` là dùng để thiết lập cho thông số nào (`vani`, `cacao`, `tiêu`, `ớt` hay `nướcDừa`?)
    

Bạn có thể giải quyết hai vấn đề trên bằng cách … không làm gì (với constructor). Theo nghĩa, chỉ định nghĩa constructor không đối số, cùng với tất cả các getter, setter cho các thuộc tính. Nếu sử dụng Lombok thì khai báo của lớp là rất gọn:

```java
@lombok.Data
public class Bánh {
	// thuộc tính bắt buộc có
	private double đường;
	private double bột;
	
	// thuộc tính tuỳ chọn
	private double vani;
	private double nướcDừa;
	private double cacao;
	private double ớt;
	private double tiêu;

	public Bánh() { }
}
```

Khi đó, việc khởi tạo các instance của lớp này được thực hiện theo kiểu:

```java
Bánh x = new Bánh();
x.setĐường(10.2);
x.setBột(5.5);
// doSomething(x);
x.setTiêu(1.5);
x.setNướcDừa(0.5);
```

Trông có vẻ ổn vì cách này giải quyết được hai vấn đề đã đề cập phía trên. Tuy nhiên, có một vấn đề khác: quá trình xây dựng instance được thực hiện qua nhiều lời gọi, và có khả năng có một thao tác nào đó khác xen giữa vào quá trình khởi tạo này. Trong nhiều bài toán thì đây là thứ không được chấp nhận.

Mẫu **SBuilder** ra đời giúp giải quyết tất cả vấn đề trên!

## 2. Mẫu SBuilder

Xét đoạn code sau đây:

```java
@lombok.Setter
@lombok.Getter
public class Bánh {
	// thuộc tính bắt buộc có
	private double đường;
	private double bột;
	
	// thuộc tính tuỳ chọn
	private double vani;
	private double nướcDừa;
	private double cacao;
	private double ớt;
	private double tiêu;
	
	// 1. Tạo ra inner-class của class Bánh
	public static class BánhBuilder {
		// thuộc tính bắt buộc có
		private double đường;
		private double bột;
		
		// thuộc tính tuỳ chọn
		private double vani;
		private double nướcDừa;
		private double cacao;
		private double ớt;
		private double tiêu;
	
		// 2. Tạo hàm dựng cho inner-class với các thuộc tính bắt buộc phải có
		public BánhBuilder(double đường, double bột) {
			this.đường = đường;
			this.bột = bột;
		}
		
		public BánhBuilder() {
			// neu can thi tao ham dung khong doi so cho inner-class
		}
	
		// 3. Với mỗi thuộc tính X là optional, tạo hàm 
		// public Builder x(Type value) { this.x = value; return this; }
		public BánhBuilder vani(double value) {
			this.vani = value;
			return this;
		}
	
		public BánhBuilder nướcDừa(double value) {
			this.nướcDừa = value;
			return this;
		}
	
		public BánhBuilder cacao(double value) {
			this.cacao = value;
			return this;
		}
	
		public BánhBuilder ớt(double value) {
			this.ớt = value;
			return this;
		}
		
		public BánhBuilder tiêu(double value) {
			this.tiêu = value;
			return this;
		}
	
		// 4. Tạo hàm build()
		public Bánh build() {
			return new Bánh(this);
		}
	}

	// 5. hàm dựng với đối số Builder, private
	private Bánh(BánhBuilder b) {
		this.đường = b.đường;
		this.bột = b.bột;
		this.vani = b.vani;
		this.nướcDừa = b.nướcDừa;
		this.cacao = b.cacao;
		this.tiêu = b.tiêu;
		this.ớt = b.ớt;
	}
}
```

Đặc điểm của đoạn code trên

- Với lớp muốn định nghĩa builder, chúng ta khai báo tất cả thuộc tính như thông thường, trong đó phân ra 2 nhóm: nhóm thuộc tính bắt buộc và nhóm thuộc tính tuỳ chọn.
- Khai báo inner class (`public static class **Builder**`) với đặc điểm
    - Có **tất cả thuộc tính của class ngoài**
    - Có constructor với tham số là tất cả thuộc tính bắt buộc có — như ví dụ trên là 2 thuộc tính `đường` và `bột`, tương ứng với constructor `public Builder(double đường, double bột)`.
    - Với mỗi thuộc tính tuỳ chọn, tạo ra phương thức dạng
        
        ```java
        Builder tênThuộcTính(KieuDuLieu value) {
        	this.tênThuộcTính = value;
        	return this;
        }
        ```
        
    - Có hàm `build` được định nghĩa như sau
        
        ```java
        public LớpNgoài build() {
        			return new LớpNgoài(this);
        }
        ```
        
        hàm này gọi đến constructor của lớp bên ngoài. Và hiển nhiên, chúng ta phải định nghĩa constructor như vậy ở lớp bên ngoài
        
- Định nghĩa constructor cho lớp bên ngoài, mức truy xuất `private`, với dạng :
    
    ```java
    private LớpNgoài(Builder b) {
    		// Gán tất cả thuộc tính của Builder ra thuộc tính của lớp ngoài
    		// Ví dụ
    		this.đường = b.đường;
    		this.bột = b.bột;
    
    		this.vani = b.vani;
    		this.nướcDừa = b.nướcDừa;
    		this.cacao = b.cacao;
    		this.tiêu = b.tiêu;
    		this.ớt = b.ớt;
    	}
    ```
    

Việc sử dụng lớp với mẫu SBuilder là rất đơn giản:

```java
		Bánh b = new Bánh.BánhBuilder(1.5, 0.7)
				.cacao(5)
				.tiêu(0.5)
				.nướcDừa(4.5)				
				.ớt(0.3)
				.build();
```

Cú pháp khởi tạo instance của lớp `Bánh` là dễ hiểu (các giá trị tham số được gắn với tên của tham số), thứ tự thiết lập của chúng là tuỳ ý, đồng thời cũng là tuỳ chọn (có thể gọi hoặc không gọi hàm thiết lập giá trị). Ngoài ra, hoàn toàn không có thao tác nào được xen vào giữa quá trình khởi tạo instance!

<aside>
💡

Thử tìm hiểu với từ khoá : Fluent API, chaining method

</aside>

## 3. Sử dụng Lombok để tạo SBuilder

Có thể thấy mẫu Builder cực kỳ phù hợp để tạo “constructor” cho những lớp có nhiều thuộc tính, đặc biệt là khi những thuộc tính này có cùng kiểu dữ liệu (như lớp `Bánh` ở phần trước). Tuy nhiên, lượng mã lệnh để cài đặt là khá nhiều. Thật may, Lombok cho phép bạn cài đặt mẫu Builder — theo cùng cách tạo ra các **getter**, **setter**, **constructor** (tham khảo bài viết **DP4 - Sử dụng Lombok**). 

Ví dụ: Với việc gắn các annotation `Getter`, `Setter` và `Builder` cho lớp `SinhVien` như dưới đây:

```java
@lombok.Builder
@lombok.Getter
@lombok.Setter
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private java.sql.Date ngaySinh;
	private int maNganhDaoTao; // mã ngành đào tạo
}
```

thì lớp `SinhVien` sẽ:

- có các getter, setter cho tất cả các thuộc tính của nó, chẳng hạn `getHoTen()`, `setHoTen(String value)`, …
- có cài đặt mẫu Builder. Chẳng hạn, chúng ta có thể khởi tạo một instance của lớp `SinhVien` theo kiểu
    
    ```java
    SinhVien x = new SinhVien.SinhVienBuilder()
    							.hoTen("Nguyễn Văn Trung")
    							.maSinhVien("T102123")
    							.maNganhDaoTao(102)
    							.ngaySinh(new java.sql.Date(1981, 10, 25))
    							.build();
    ```
    
    Lombok sinh code cho mẫu Builder theo quy tắc:
    
    - Tên lớp inner/Builder là tên của lớp ngoài + Builder. Chẳng hạn, builder cho lớp `SinhVien` có tên là `SinhVienBuilder`.
    - Hàm thiết lập thuộc tính có cùng tên với thuộc tính, chẳng hạn hàm thiết lập thuộc tính `maNganhDaoTao` cũng có tên là `maNganhDaoTao`.
    - Có constructor **không tham số**. Điều này khá dễ hiểu, vì chúng ta không có cách gì để chỉ định thuộc tính nào là bắt buộc, thuộc tính nào là tuỳ chọn.
    - Có hàm `build()` nằm ở cuối cùng trong lời gọi hàm xây dựng instance.
    

👉Tham khảo thêm cách dùng mẫu Builder với Lombok ở trên và ở đây: [Lombok Builder with Default Value | Baeldung](https://www.baeldung.com/lombok-builder-default-value)

(c) Trung Nguyễn 2024 (nvtrung@husc.edu.vn) — Lưu hành nội bộ, Không sao chép và sử dụng với mục đích khác mà không được sự đồng ý trước