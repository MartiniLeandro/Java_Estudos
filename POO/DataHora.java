package POO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataHora {
    public static void main(String[] args) {
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 =  Instant.parse("2022-07-20T01:30:26Z");
        Instant d07 =  Instant.parse("2022-07-20T01:30:26-03:00");

        System.out.println("d01 = "  + d01);
        System.out.println("d02 = "  + d02);
        System.out.println("d03 = "  + d03);
        System.out.println("d04 = "  + d04);
        System.out.println("d05 = "  + d05);
        System.out.println("d06 = "  + d06);
        System.out.println("d07 = "  + d07);
    }
}
