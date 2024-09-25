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

        //Задание №2 - Сколько здесь "о" ?
        //1. Создать набор уникальных слов: "тон", "тополь", "боль", "рой", "стройка"
        //2. Создать стрим у набора
        //2.1 Посчитать количество букв "о" в одном слове
        //2.2 Посчитать сумму количества букв "о" во всех словах из набора
        //2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
        //
        //ожидаемый результат:
        //6
    }
}
