package homework4.ex2;

import java.util.List;

public class Runner {
    private static final char CHAR_TO_COUNT = 'о';
    public static void main(String[] args) {
        List<String> list = List.of("тон", "тополь", "боль", "рой", "стройка");

        long result = list.stream()
                .flatMapToInt(String::chars)
                .filter(e -> e == CHAR_TO_COUNT)
                .count();
        System.out.println(result);
    }
}
