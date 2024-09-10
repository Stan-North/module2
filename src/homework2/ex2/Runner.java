package homework2.ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Runner {
    private static final int LIGHT_WEIGHT = 5;
    private static final int HEAVY_WEIGHT = 10;
    private static final String FILE_NAME = "resources/luggage.csv";
    private static final String SPLITTERATOR = ";";
    private static final int INDEX_OF_LUGGAGE_WEIGHT = 1;
    private static final String LIGHT = "легкий";
    private static final String MIDDLE = "средний";
    private static final String HEAVY = "тяжелый";
    private static final int INITIAL_VALUE = 0;

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> result = calculateStatistics(FILE_NAME);
        System.out.println(result);
    }

    /**
     * основной метод
     */
    public static LinkedHashMap<String, Integer> calculateStatistics(String fileName) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        mapInitialize(map);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); //пропускаем первую строку
            while (reader.ready()) {
                addWeightToMap(reader.readLine(), map);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }

    /**
     * Инициализация мапы и заполнение стартовыми значениями
     */
    public static void mapInitialize(Map<String, Integer> result) {
        result.put(LIGHT, INITIAL_VALUE);
        result.put(MIDDLE, INITIAL_VALUE);
        result.put(HEAVY, INITIAL_VALUE);
    }

    /**
     * добавление значений веса в мапу
     */
    public static void addWeightToMap(String line, HashMap<String, Integer> hashMap) {
        if (line != null) {
            String[] splittedLine =  line.split(SPLITTERATOR);
            int value = Integer.parseInt(splittedLine[INDEX_OF_LUGGAGE_WEIGHT]);
            if (value < LIGHT_WEIGHT) {
                hashMap.computeIfPresent(LIGHT, (k, v) -> v + value);
            } else if (value > LIGHT_WEIGHT && value < HEAVY_WEIGHT) {
                hashMap.computeIfPresent(MIDDLE, (k, v) -> v + value);
            } else {
                hashMap.computeIfPresent(HEAVY, (k, v) -> v + value);
            }
        }

    }

}
