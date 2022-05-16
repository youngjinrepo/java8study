package optionalStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    static Long basketId = 0L;

    public static void main(String[] args) {
        //optionalGetMethod1();
        exceptionEvent();
    }

    //Optional 로 만드는 메소드
    public static void optionalBasic1() {
        Basket basket = new Basket( basketId++, "Cheese");

        Optional.of(basket); // null을 허용하지 않는다
        Optional.ofNullable(basket); // 널을 허용한다

        Optional.empty(); // 비어있는 Optional 객체를 반환한다.
    }

    //Optional 조회 메쏘드
    ////////////////////////////////////////////////////////////////////////////////////////
    //orElse 와 orElseGet의 차이
    //1. orElse 는 메소드를 인자로 취하지만 orElseGet 은 Supplier 형태의 함수를 취한다.
    //2. orElse 메소드의 실행 결과를 리턴 타입으로 사용하기 때문에 메소드를 실행한다.
    //   orElseGet은 값이 null일 경우에 실행하게 된다
    //결론
    // orElse에 값을 update,insert 하는 메소드를 줄 경우 원치않는 결과가 생길 수 있다
    // orElse는 전달받은 함수를 실행하기 때문에 불필요하게 실행시간이 증가할 수 있다.
    ////////////////////////////////////////////////////////////////////////////////////////
    public static void optionalGetMethod1() {

        List<Basket> basketList = new ArrayList<>();
        basketList.add(new Basket(basketId++, "Cheese"));
        basketList.add(new Basket(basketId++, "dubu"));
        basketList.add(new Basket(basketId++, "apple"));

        String targetName = "dubu";
        Optional<Basket> findTarget = basketList.stream()
                .filter(o -> o.getName().startsWith(targetName)).findFirst();

        //
        Basket basket = findTarget.orElse(addNewBasket());
        System.out.println("basket = " + basket.getName());

        findTarget.orElseGet(App::addNewBasket);
        System.out.println("basket = " + basket.getName());
    }

    public static Basket addNewBasket(String targetName) {

        return new Basket(basketId++, targetName);
    }
    public static Basket addNewBasket() {
        System.out.println("add new!!!");
        return new Basket(basketId++, "something");
    }

    // orElseThrow
    public static void exceptionEvent() {
        List<Basket> basketList = new ArrayList<>();
        basketList.add(new Basket(basketId++, "Cheese"));
        basketList.add(new Basket(basketId++, "dubu"));
        basketList.add(new Basket(basketId++, "apple"));

        Optional<Basket> bread = basketList.stream()
                .filter(p -> p.getName().equals("bread"))
                .findFirst();

        Basket basket = bread.orElseThrow(BreadNotFoundException::new);
    }
}
