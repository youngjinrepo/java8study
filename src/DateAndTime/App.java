package DateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(String[] args) {
        dateFormatting();
    }

    public static void parseDate() {
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate parsedDate = LocalDate.parse("02/01/1994", MMddyyyy);
        System.out.println("parsedDate = " + parsedDate);
    }

    public static void dateFormatting() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("now.format(formatter) = " + now.format(formatter));
    }

    // 기계 시간
    public static void forMachine1() {
        Instant instant = Instant.now(); //Default : 기준시(UTC, GMT) 기준으로 생성
        System.out.println("instant = " + instant);

        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);
    }

    // 기계용 기간 계산
    public static void forMachine2() {
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(now, plus);
        System.out.println("duration.getSeconds = " + duration.getSeconds());
    }

    // 인간 시간
    public static void forHuman() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birthday = LocalDateTime.of(1994, Month.FEBRUARY, 1,0,0);
        ZonedDateTime nowInKor = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKor = " + nowInKor);
    }

    // 인간용 기간 계산
    public static void forHuman2() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of( 2023, Month.FEBRUARY, 1);

        Period between = Period.between(today, birthday);
        System.out.println(between.getYears()+"/"+between.getMonths()+"/"+between.getDays());

        Period until = today.until(birthday);
        System.out.println(until.get(ChronoUnit.DAYS));
        System.out.println(until.getYears()+"/"+until.getMonths()+"/"+until.getDays());
    }
}
