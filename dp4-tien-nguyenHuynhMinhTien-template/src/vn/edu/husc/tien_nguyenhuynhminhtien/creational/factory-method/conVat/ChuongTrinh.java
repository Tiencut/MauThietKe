package T1020761.entity;

public class ChuongTrinh {
	static void testFactoryMethod() {
		ConVật x;
		ConVậtFactory f;

		// Tạo và chạy Gà
		f = new GàFactory();
		x = f.getConVật();
		x.kêu();

		// Tạo và chạy Mèo
		f = new MèoFactory();
		x = f.getConVật();
		x.kêu();

		// Tạo và chạy Chó
		f = new ChóFactory();
		x = f.getConVật();
		x.kêu();
	}

	public static void main(String[] args) {
		testFactoryMethod();
	}
}
