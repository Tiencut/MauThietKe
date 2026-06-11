package T1020761.entity;

public class MèoFactory extends ConVậtFactory {
    @Override
    public ConVật getConVật() {
        return new Mèo();
    }
}
