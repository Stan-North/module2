package homework4.ex1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {
    private static final String FIRST_REGEX = "а0%02dан799";
    private static final String SECOND_REGEX = "к0%02dсе178";
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 50;
    private static final String FILTER_REGEX = ".*04[0-9].*";

    public static void main(String[] args) {
        List<Car> firstCars = new ArrayList<>();
        createCars(firstCars, FIRST_REGEX);

        List<Car> secondCars = new ArrayList<>();
        createCars(secondCars, SECOND_REGEX);

        Pattern pattern = Pattern.compile(FILTER_REGEX);

        Stream.of(firstCars, secondCars)
                .flatMap(Collection::stream)
                .filter(e -> pattern.matcher(e.getNumber()).matches())
                .forEach(e -> System.out.println(e.getNumber()));
    }

    private static void createCars(List<Car> cars, String regex) {
        IntStream.rangeClosed(START_VALUE, END_VALUE)
                .mapToObj(i -> new Car(String.format(regex, i)))
                .forEach(cars::add);
    }
}
