package streamsession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamSession {

    public static void main(String[] args) {
        session1();
    }

    //flatMap
    public static void session1() {
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

        allSeason.stream() // stream { winterSeason, springSeason }
                .flatMap(eachList -> eachList.stream()) // stream { americano, coldBrewed, greentea, Strawberry, Strawberry }
                .forEach(menu-> System.out.println(menu.getName()));

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
