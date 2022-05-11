package functionalInterface;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {

    public static void main(String[] args) {
        basic3();
    }

    public static void basic1() {
        // anonymous inner class 익명 내부 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello anonymous");
            }
        };
        // java 8부터 익명 클래스 방식을 람다 표현식으로 표현할 수 있게 됨
        // ramda expression
        RunSomething runSomething2 = () -> System.out.println("hello ramda");
    }

    // java에서 제공중인 functional interface 활용
    public static void basic2() {
        Function<Integer, String> NumToString = (i) -> String.valueOf(i);
        Function<String, String> addBrace = (s) -> "{" + s + "}";

        //고차 함수 (Higher-Order Function)
        //함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
        Function<Integer, String> compose = addBrace.compose(NumToString);
        String s = compose.apply(1);
        System.out.println("s = " + s);
    }

    public static void basic3() {
        ParrotClass parrotClass = new ParrotClass("hi");

        UnaryOperator<String> s = o -> "hello"+o;
        UnaryOperator<String> staticMethodReference =
                ParrotClass::printGreeting;
        UnaryOperator<String> instanceMethodReference
                = parrotClass::printHi;

        System.out.println(s.apply("s"));
        System.out.println(staticMethodReference.apply("!"));
        System.out.println(instanceMethodReference.apply("!")) ;
    }

    public static void basic4(){
        //입력값은 없고 리턴이 있을 경우 사용할 수 있는 Functional Interface
        Supplier<ParrotClass> parrotClassSupplier = ParrotClass::new;

        parrotClassSupplier.get();
     }

     //임의 객체의 인스턴스 메소드 참조
    public static void basic5() {
        String[] names = {"egg", "beef", "pork"};
        Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.sort(names, (s1,s2) -> 00);
    }
}