package streamsession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class streamSession {


    public static void main(String[] args) {
        List<Starbucks> winterSeason = new ArrayList<>();
        winterSeason.add(new Starbucks(1, "coffee", "americano", false));
        winterSeason.add(new Starbucks(2, "coffee", "coldBrewed", true));
        winterSeason.add(new Starbucks(3, "tea", "greentea", false));

        List<Starbucks> springSeason = new ArrayList<>();
        springSeason.add(new Starbucks(4, "beverage", "Strawberry", true));
        springSeason.add(new Starbucks(5, "tea", "Strawberry", true));

        List<List<Starbucks>> allSeason = new ArrayList<>();
        allSeason.add(winterSeason);
        allSeason.add(springSeason);

        System.out.println("session1 /////////////////////////////////////////");
        session1(allSeason);

        System.out.println("session2 /////////////////////////////////////////");
        session2();
    }

    //flatMap
    public static void session1( List<List<Starbucks>> allSeason ) {
        allSeason.stream() // stream { winterSeason, springSeason }
                .flatMap(eachList -> eachList.stream()) // stream { americano, coldBrewed, greentea, Strawberry, Strawberry }
                .forEach(menu-> System.out.println(menu.getName()));
    }

    //Stream 기능 활용
    public static void session2() {
        Stream.iterate(1, i -> i + 1) // seed 와 UnaryOperator 를 인자로 줌
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
        ;
    }

    //anyMatch
    public static void sessionAnyMatch(List<Starbucks> menu) {
        boolean match = menu.stream()
                .anyMatch(m -> m.getName().contains("o"));
    }

    //////////////////////////////////////////////////////////////
    public static class Starbucks {
        private int id;
        private String type;
        private String name;
        private boolean isNonCaffeine;

        public Starbucks(int id, String type, String name, boolean isNonCaffeine) {
            this.id = id;
            this.type = type;
            this.name = name;
            this.isNonCaffeine = isNonCaffeine;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isNonCaffeine() {
            return isNonCaffeine;
        }

        public void setNonCaffeine(boolean nonCaffeine) {
            isNonCaffeine = nonCaffeine;
        }
    }
}
