package functionalInterface;

@FunctionalInterface
public interface RunSomething {

    abstract void doIt();

    static void printName() {
        System.out.println("justdoit");
    }
}
