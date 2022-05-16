package optionalStudy;

public class BreadNotFoundException extends RuntimeException {
    public BreadNotFoundException() {
        System.out.println("Bread Not Found");
    }
}
