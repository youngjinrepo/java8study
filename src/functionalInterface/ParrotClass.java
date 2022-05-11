package functionalInterface;

public class ParrotClass {

    String greeting;

    public ParrotClass() {
    }

    public ParrotClass(String greeting) {
        this.greeting = greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public static String printGreeting(String greeting) {
        return greeting+"~";
    }

    public String printHi(String greeting) {
        return greeting+"!";
    }
}
