# Mẫu Prototype

## 1. Đặt vấn đề

Có class `SinhVien` như sau

```java
package prototype;

@lombok.AllArgsConstructor 
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SinhVien {
	private String maSinhVien;
	private String hoTen;

  // Hàm dựng kiểu sao chép
	public SinhVien(SinhVien x) {
		this.maSinhVien = x.maSinhVien;
		this.hoTen      = x.hoTen;
	}

	@Override
	public String toString() {
		return "Sinh viên " + this.getHoTen();
	}	
}
```

Để sao chép một object `SinhVien`, chúng ta cần tạo ra constructor với đối số là `SinhVien`, như phần được tô sáng ở code phía trên.

Kiểu như:

```java
// Tạo đối tượng SinhVien
SinhVien nvtrung = new SinhVien("T102001", "Nguyen Van Trung");

// Sao chép nvtrung qua đối tượng x theo kiểu (1)
SinhVien x = new SinhVien();
x.setMaSinhVien(nvtrung.getMaSinhVien());
x.setHoTen     (nvtrung.getHoTen()     );

// Sao chép nvtrung qua đối tượng y theo kiểu (2) - Sử dụng hàm dựng sao chép
SinhVien y = new SinhVien(nvtrung);
```

Rõ ràng, sao chép theo kiểu (2) — dùng constructor với đối số `SinhVien` — thì ***tiện lợi hơn nhiều*** so với sao chép theo kiểu (1) — gán từng thuộc tính (Hãy nghĩ đến tình huống class `SinhVien` có khoảng 10 thuộc tính!!!)

OK, giờ cần thêm một class khác, `SinhVienNuocNgoai`, là `SinhVien`, nhưng có thêm thông tin `quocGia` nữa. Theo kinh nghiệm ở trên, chúng ta cũng cung cấp thêm một constructor với đối số là `SinhVienNuocNgoai`, như phần code được tô sáng ở dưới đây. Hiển nhiên, nó cũng có các hàm và constructor cần thiết khác nữa.

```java
package prototype;

// @lombok.AllArgsConstructor -> Annotation này chỉ bổ sung thêm hàm public SinhVienNuocNgoai(String quocGia);
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SinhVienNuocNgoai extends SinhVien {
	private String quocGia;

	public SinhVienNuocNgoai(String maSinhVien, String hoTen, String quocGia) {
		this.setMaSinhVien(maSinhVien);
		this.setHoTen(hoTen);
		this.setQuocGia(quocGia);
	}

	public SinhVienNuocNgoai(SinhVienNuocNgoai x) {
		super(x); // sử dụg hàm dựng kiểu sao chép ở lớp cha (SinhVien), thiết lập maSinhVien, hoTen của this là giống như của đối tượng x
		
		// Thiết lập thêm thuộc tính còn thiếu:
		this.quocGia = x.quocGia;
	}

	@Override
	public String toString() {
		return "Sinh viên NUOC NGOAI " + this.getHoTen() + " có quốc tịch = " + this.getQuocGia();
	}	
}
```

Vấn đề bắt đầu xuất hiện khi xét đoạn code dưới đây, thực hiện **sao chép nguyên danh sách** các object:

- Phần 1 - Khởi tạo danh sách, gồm lẫn lộn cả `SinhVien` lẫn `SinhVienNuocNgoai` :
    
    ```java
    // Khởi tạo danh sách
    List<SinhVien> lst1 = new ArrayList<>();
    
    lst1.add(new SinhVien("sv1", "Nguyễn Văn Trung"));
    lst1.add(new SinhVienNuocNgoai("sv2", "Trần Văn", "Lào"));
    lst1.add(new SinhVienNuocNgoai("sv3", "Lê Thị Hoa", "Anh"));
    lst1.add(new SinhVien("sv100", "John Smith"));
    
    System.out.println("DANH SÁCH GỐC");
    for (int i = 0; i < lst1.size(); i++)
    		System.out.println(lst1.get(i).toString());
    ```
    
    Kết quả khi chạy chương trình:
    
    ```
    DANH SÁCH GỐC
    Sinh viên Nguyễn Văn Trung
    Sinh viên NUOC NGOAI Trần Văn có quốc tịch = Lào
    Sinh viên NUOC NGOAI Lê Thị Hoa có quốc tịch = Anh
    Sinh viên John Smith
    ```
    
    ![image.png](attachment:7ade7485-0f6d-4675-906d-ce219f350db1:image.png)
    
- Phần 2 - Sao chép danh sách
    
    Tạo bản sao của danh sách `lst1` qua danh sách `lst2`:
    
    ```java
    // Tạo bản sao
    System.out.println("\nTẠO BẢN SAO KIỂU 1");
    
    List<SinhVien> lst2 = new ArrayList<>();
    for (int i = 0; i < lst1.size(); i++) {
    		SinhVien x = lst1.get(i);
    		
    		// Tạo đối tượng x2, là bản sao của đối tượng x
    		SinhVien x2;
    		
    		x2 = new SinhVien(x); // Sử dụng hàm dựng kiểu sao chép
    		// x2 = new SinhVienNuocNgoai((SinhVienNuocNgoai)x); // Cái này lỗi nếu x chỉ là SinhVien chứ không phải là SinhVienNuocNgoai
    
    		lst2.add(x2); // bổ sung bản sao của x vào dsách đích
    }
    
    // In danh sách bản sao
    for (int i = 0; i < lst2.size(); i++)
    		System.out.println(lst2.get(i).toString());
    ```
    
    ```
    TẠO BẢN SAO KIỂU 1
    Sinh viên Nguyễn Văn Trung
    Sinh viên Trần Văn
    Sinh viên Lê Thị Hoa
    Sinh viên John Smith
    ```
    
    Nhận xét: Hai đối tượng thứ hai, thứ ba chỉ là `SinhVien` chứ không phải là `SinhVienNuocNgoai` giống như ở danh sách gốc  
    
    ![image.png](attachment:e1996daf-1b17-4a1b-8694-52c21437bfb8:image.png)
    
    Như đã thấy, việc sao chép danh sách như trên *hoạt động không đúng như trông đợi*: nó sao chép **không chính xác** các phần tử trong danh sách. Nói cách khác, `lst1 ≠ lst2` về mặt nội dung, nên không đạt yêu cầu!
    
    Thực ra, để sửa lỗi, chúng ta phải làm như sau:
    
    ```java
    // Tạo bản sao -- version 2
    System.out.println("\nTẠO BẢN SAO KIỂU 2 -- fix lỗi");
    List<SinhVien> lst2 = new ArrayList<>();
    for (int i = 0; i < lst1.size(); i++) {
    	SinhVien x = lst1.get(i);
    	
    	SinhVien x2 = null;
    	
    	if (x instanceof SinhVienNuocNgoai)
    			x2 = new SinhVienVienNuocNgoai( (SinhVienNuocNgoai)x ); // ép x thành kiểu SinhVienNuocNgoai rồi dùng hàm sao chép của class SinhVienNuocNgoai
    	else
    			x2 = new (SinhVien(x); // chỉ cần dùng hàm sao chép của class SinhVien
    			
    	lst2.add(new SinhVien(x));
    }
    
    // In danh sách bản sao
    for (int i = 0; i < lst2.size(); i++)
    	System.out.println(lst2.get(i).toString());
    ```
    
    Kết quả khi chạy chương trình:
    
    ```
    TẠO BẢN SAO KIỂU 2 -- fix lỗi
    Sinh viên Nguyễn Văn Trung
    Sinh viên NUOC NGOAI Trần Văn có quốc tịch = Lào
    Sinh viên NUOC NGOAI Lê Thị Hoa có quốc tịch = Anh
    Sinh viên John Smith
    ```
    
    ![image.png](attachment:e7e93231-2b98-43a7-b09f-15dc629c197e:image.png)
    
    Có thể thấy, giờ thì việc sao chép mới được như ý muốn của chúng ta — có hai danh sách giống nhau về mặt nội dung!
    
    Tất cả là nhờ đoạn code được tô sáng ở trên: chúng ta cần phải dùng đúng constructor của đúng class mới được!
    
    Vấn đề là, nếu chúng ta có nhiều lớp con của `SinhVien` bên cạnh `SinhVienNuocNgoai` thì, cấu trúc `if` như trên sẽ **rất phức tạp**.
    
    👉 Mẫu prototype ra đời nhằm giải quyết vấn đề này
    

## 2. Xử lý vấn đề bằng mẫu Prototype

Chúng ta điều chỉnh class  `SinhVien`, bằng cách bổ sung hàm `taoBanSao()` như phần code được tô sáng bên dưới:

```java
package prototype;

@lombok.AllArgsConstructor 
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SinhVien {
	private String maSinhVien;
	private String hoTen;

	public SinhVien(SinhVien x) {
		this.maSinhVien = x.maSinhVien;
		this.hoTen = x.hoTen;
	}

	public SinhVien taoBanSao() {
		return new **SinhVien**(this); // tạo bản sao của chính đối tượng this
	}
	
	@Override
	public String toString() {
		return "Sinh viên " + this.getHoTen();				
	}
}
```

Đối với những class kế thừa class `SinhVien`, chúng ta cũng làm tương tự — bổ sung hàm `taoBanSao` dưới dạng được `@Override` như dưới đây:

```java
package prototype;

// @lombok.AllArgsConstructor 
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SinhVienNuocNgoai extends SinhVien {
	private String quocGia;

	public SinhVienNuocNgoai(SinhVienNuocNgoai x) {
		super(x);
		this.quocGia = x.quocGia;
	}
	
	// Chú ý, phải thêm hàm này
	// Do Lombok không gen được hàm dựng theo @AllArgConstructor
	public SinhVienNuocNgoai(String maSinhVien, String hoTen, String quocGia) {
		super(maSinhVien, hoTen);
		this.setQuocGia(quocGia);
	}

	@Override
	public SinhVien taoBanSao() {
		return new **SinhVienNuocNgoai**(this); // tạo bản sao của chính đối tượng this. Chú ý return new SinhVienNuocNgoai(...) chứ không phải là new SinHVien(...)
	}

	@Override
	public String toString() {
		return "Sinh viên NUOC NGOAI " + this.getHoTen() + " có quốc tịch = " + this.getQuocGia();
	}
}
```

Với bổ sung đơn giản như vậy, **việc sao chép danh sách là rất đơn giản**. Chẳng hạn:

```java
	System.out.println("\nTẠO BẢN SAO KIỂU 2");
	
	// Tạo bản sao
	List<SinhVien> lst2 = new ArrayList<>();
	for (int i = 0; i < lst1.size(); i++) {
			SinhVien x = lst1.get(i);
			
			SinhVien x2 = null;
			
			x2 = x.taoBanSao();
			
			lst2.add(x2);
	}

	// In danh sách bản sao
	for (int i = 0; i < lst2.size(); i++)
		System.out.println(lst2.get(i).toString());
```

Kết quả khi chạy chương trình:

```
TẠO BẢN SAO KIỂU 2
Sinh viên Nguyễn Văn Trung
Sinh viên NUOC NGOAI Trần Văn có quốc tịch = Công ty ABC
Sinh viên NUOC NGOAI Lê Thị Hoa có quốc tịch = XYZ corppation
Sinh viên John Smith
```

Để tạo bản sao cho đối tượng kiểu `SinhVien` hay lớp con của nó (như `SinhVienNuocNgoai`) chúng ta chỉ cần dùng code như sau:

```java
SinhVien x = new SinhVien(...);
SinhVien x2 = x.taoBanSao();

SinhVien y = new SinhVienNuocNgoai(...);
SinhVien y2 = y.taoBanSao();
```

Tức là, lúc nào cũng dùng hàm `taoBanSao`, chứ không cần phải kiểm tra `if` như cũ!

## 3. Các bước để cài đặt mẫu Prototype

Một class, nếu muốn bổ sung khả năng **tạo bản sao** thì thực hiện các bước

1. Định nghĩa class như bình thường, với các getter, setter, constructor dùng các đối số
    
    ```java
    @lombok.AllArgsConstructor 
    @lombok.NoArgsConstructor
    @lombok.Getter
    @lombok.Setter
    class TenLop {
    		private String f1;
    		private double f2;
    		
    		/// ...
    }
    ```
    
2. Bổ sung constructor với đối số là class đó (hàm dựng kiểu sao chép)
    
    ```java
    @lombok.AllArgsConstructor 
    @lombok.NoArgsConstructor
    @lombok.Getter
    @lombok.Setter
    class TenLop {
    		private String f1;
    		private double f2
    		
    		public TenLop(TenLop x) {
    				this.field1 = x.field1;
    				this.field2 = x.field2;
    				...
    		}
    		
    		///
    }
    ```
    
3. Bổ sung hàm **`taoBanSao` có dạng**
    
    ```java
    @lombok.AllArgsConstructor 
    @lombok.NoArgsConstructor
    @lombok.Getter
    @lombok.Setter
    class TenLop {
    		private String f1;
    		private double f2
    		
    		public TenLop(TenLop x) {
    				this.field1 = x.field1;
    				this.field2 = x.field2;
    				...
    		}
    		
    		public TenLop taoBanSao() {
    				return new TenLop(this);
    		}
    }
    ```
    
4. Đối với những class kế thừa class này thì phải thực hiện hai việc
    1. Tạo constructor với đối số là class con
    2. Override hàm `taoBanSao`
    
    Chẳng hạn, như dưới đây
    
    ```java
    @lombok.AllArgsConstructor 
    @lombok.NoArgsConstructor
    @lombok.Getter
    @lombok.Setter
    class TenLopCon extends TenLop {
    		private double field3; // thêm thuộc tính mới
    		
    		public TenLopCon(TenLopCon x) {
    				super(x); // gọi hàm này để khởi tạo các th.tính ở lớp cha
    				
    				this.field3 = x.field3; // gán thêm th.tính mới, chỉ có ở lớp con
    		}
    		
    		@Overide
    		public TenLop taoBanSao() {
    				return new **TenLopCon**(this);
    		}
    }
    ```
    

## 4. Nhận xét

- Giống tư duy của mẫu **Factory Method** ở điểm: thay vì `if ...` để tạo mới các `Product` cụ thể, chúng ta tạo ra các lớp con
- Một số ngôn ngữ lập trình đã có sẵn hàm thực hiện chức năng `taoBanSao()`, ví dụ Java có sẵn hàm `clone()` được khai báo trong class `Object`
    
    Như vậy, ở class `SinhVien` hay `SinhVienNuocNgoai`, có thể override hàm `clone` như sau
    
    ```java
    public class SinhVien {
    	//// các tính chất, hàm dựng sao chép:định nghĩa như trên 
    	
    	@Override
    	protected Object clone() throws CloneNotSupportedException {
    		return new **SinhVien**(this);
    	}
    }
    ```
    
    ```java
    public class SinhVienNuocNgoai {
    	//// các tính chất, hàm dựng sao chép:định nghĩa như trên
    	
    	@Override
    	protected Object clone() throws CloneNotSupportedException {
    		return new **SinhVienNuocNgoai**(this);
    	}
    }
    ```
    
    Cách sử dụng để sao chép danh sách
    
    ```java
    private static void test1() {
    		// Khởi tạo danh sách
    		List<SinhVien> lst1 = new ArrayList<>();
    
    		lst1.add(new SinhVien("sv1", "Nguyễn Văn Trung"));
    		lst1.add(new SinhVienNuocNgoai("sv2", "Trần Văn", "Lào"));
    		lst1.add(new SinhVienNuocNgoai("sv3", "Lê Thị Hoa", "Anh"));
    		lst1.add(new SinhVien("sv100", "John Smith"));
    
    		System.out.println("DANH SÁCH GỐC");
    		for (int i = 0; i < lst1.size(); i++)
    			System.out.println(lst1.get(i).toString());
    
    		// Sao chép theo kiểu 1
    		System.out.println("\nTẠO BẢN SAO KIỂU 1");
    		// Tạo bản sao
    		List<SinhVien> lst2 = new ArrayList<>();
    		for (int i = 0; i < lst1.size(); i++) {
    			SinhVien x = lst1.get(i);
    			
    			SinhVien x2 = null;
    				
    			// 1 - Tạo bản sao theo kiểu if
    			// if (x instanceof SinhVienNuocNgoai)
    			//		x2 = new SinhVienNuocNgoai( (SinhVienNuocNgoai)x );
    			// else
    			//		x2 = new SinhVien(x); 
    				
    			// 2 - Tạo bản sao theo mẫu Prototype tự cài đặt 			
    			// x2 = x.taoBanSao();
    			
    			// 3 - Tạo bản sao theo mẫu Prototype của thư viện Java
    			try {
    				x2 = (SinhVien)x.clone(); // Phải cast (ép kiểu) x.clone() từ object thành SinhVien do x2 được khai báo kiểu dữ liệu SinhVien   
    			} catch (CloneNotSupportedException e) {
    				e.printStackTrace();
    			}
    			
    			lst2.add(x2);	// bổ sung bản sao của x vào dsách đích
    		}
    
    		// In danh sách bản sao
    		for (int i = 0; i < lst2.size(); i++)
    			System.out.println(lst2.get(i).toString());
    	}
    ```
    
    Kết quả khi chạy chương trình:
    
    ```
    TẠO BẢN SAO KIỂU 2
    Sinh viên Nguyễn Văn Trung
    Sinh viên NUOC NGOAI Trần Văn có quốc tịch = Công ty ABC
    Sinh viên NUOC NGOAI Lê Thị Hoa có quốc tịch = XYZ corppation
    Sinh viên John Smith
    ```