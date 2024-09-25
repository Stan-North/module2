package homework4.ex3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Runner {
    private static final int MIN_HEIGHT = 1000;
    private static final int COUNT_OF_PRINT = 3;
    public static void main(String[] args) {
        Skyscraper tradeCenter = new Skyscraper("Всемирный торговый центр", 541);
        Skyscraper shanghaiTower = new Skyscraper("Шанхайская башня", 632);
        Skyscraper burjKhalifa = new Skyscraper("Бурдж-Халифа", 828);
        Skyscraper lian = new Skyscraper("Международный финансовый центр Пинань",599);
        Skyscraper abradj = new Skyscraper("Абрадж аль-Бейт", 601);
        Skyscraper lotte = new Skyscraper("Всемирный центр Лотте", 555);

        List<Skyscraper> skyscrapers = List.of(tradeCenter, shanghaiTower, burjKhalifa, lian, abradj, lotte, burjKhalifa);

        List<Skyscraper> newList = skyscrapers.stream()
                .distinct().toList();

        newList.stream()
                .limit(COUNT_OF_PRINT)
                .forEach(System.out::println);

        // Печать самого высокого небоскреба
        Optional<Skyscraper> tallestSkyScraper = newList.stream()
                .max(Comparator.comparingInt(Skyscraper::getHeight));
        System.out.println(tallestSkyScraper.orElseThrow());

        // Выводит только один небоскреб
//        newList.stream()
//                .filter(e -> e.getHeight() > MIN_HEIGHT)
//                .findFirst().ifPresentOrElse(System.out::println,
//                () -> System.out.println("небоскреба выше километра - нет"));


        //Вывод всех небоскребов выше 1км, если таких небоскребов нет - печать в консоль
        newList.stream()
                .filter(e -> e.getHeight() > MIN_HEIGHT)
                .forEach(System.out::println);

        if (newList.stream().noneMatch(e -> e.getHeight() > MIN_HEIGHT)) {
            System.out.println("небоскреба выше километра - нет");
        }

        //Задание №3 - Небоскребы, небоскребы, а я...
        //1. Создать Класс Небоскреб - имя небоскреба, его высота в метрах.
        //2. Необходимо создать небоскребы:
        //Всемирный торговый центр - 541м
        //Шанхайская башня - 632м
        //Бурдж-Халифа - 828м
        //Международный финансовый центр Пинань - 599м
        //Абрадж аль-Бейт - 601м
        //Всемирный центр Лотте - 555м

        //3. Занести небоскребы в List! Дважды положить бурдж халифа в лист.

        //4. С помощью стримов:
        //4.1 Убрать дубликаты и сохранить в новый лист (далее работаем с этим листом).
        //(РАЗНЫЕ СТРИМЫ!)
        //4.2. Вывести только первые три небоскреба.
        //4.3. Вывести самый высокий небоскреб.
        //4.4. Вывести те небоскребы, которые выше километра.
        //Если выше километра нет, то вывести на экран: небоскреба выше километра - нет.
    }
}
