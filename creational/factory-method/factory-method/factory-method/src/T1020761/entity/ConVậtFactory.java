package T1020761.entity;

public abstract class ConVậtFactory {
    abstract public ConVật getConVật();

    public void hello() {
        System.out.println("I'm an implemented method");
    }

    protected int someAttribute;
}
