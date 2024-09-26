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

        Optional<Skyscraper> tallestSkyScraper = newList.stream()
                .max(Comparator.comparingInt(Skyscraper::getHeight));
        System.out.println(tallestSkyScraper.orElseThrow());


        //Вывод всех небоскребов выше 1км, если таких небоскребов нет - печать в консоль
        newList.stream()
                .filter(e -> e.getHeight() > MIN_HEIGHT)
                .forEach(System.out::println);

        if (newList.stream().noneMatch(e -> e.getHeight() > MIN_HEIGHT)) {
            System.out.println("небоскреба выше километра - нет");
        }
    }
}
