package T1020761.entity;

public class Client {
    public static void testFactoryMethod() {
        ConVật x;
        ConVậtFactory f;

        // f = new MèoFactory();
        // f = new ChóFactory();
        f = new GàFactory();

        x = f.getConVật();
        x.kêu();
    }

    public static void main(String[] args) {
        testFactoryMethod();
    }
}
