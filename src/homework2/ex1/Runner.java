package homework2.ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Runner {
    private static final String FILE_NAME = "resources/luggage.csv";
    private static final int FEED_CAPACITY = 10;
    private static final String UNLOADING_MESSAGE = "Лента загружена, начинается выдача багажа.";
    private static final String FEED_IS_EMPTY = "Лента пустая, закончена выдача багажа";
    private static final String UPLOAD_IS_STARTED = "Начинается загрузка на ленту";
    private static final String SPLITTERATOR = ";";
    private static final String LUGGAGE_GIVEN = " - выдан";
    private static final int INDEX_OF_LUGGAGE_NUMBER = 0;

    public static void main(String[] args) {
        luggageUnload(FILE_NAME);
    }

    /**
     * основной метод
     */
    public static void luggageUnload (String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // пропускаем первую строку
            while (reader.ready()) {
                unloadFeed(uploadFeed(reader));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * загрузка ленты
     */
    private static LinkedList<String> uploadFeed(BufferedReader reader) throws IOException {
        int counter = 0;
        LinkedList<String> feed = new LinkedList<>();
        System.out.println(UPLOAD_IS_STARTED);

        while (reader.ready()) {
            if (counter == FEED_CAPACITY) {
                return feed;
            } else {
                feed.add(reader.readLine());
                counter++;
            }
        }
        return feed;
    }

    /**
     * определение номера багажа
     */
     private static String getNumberOfLuggage(String line) {
         if (line != null) {
             String[] splittedLine = line.split(SPLITTERATOR);
             return splittedLine[INDEX_OF_LUGGAGE_NUMBER];
         }
        return "";
     }

    /**
     * разгрузка ленты
     */
    private static void unloadFeed(LinkedList<String> feed) {
        System.out.println(UNLOADING_MESSAGE);
        while (!feed.isEmpty()) {
            System.out.println(getNumberOfLuggage(feed.poll()) + LUGGAGE_GIVEN);
        }
        System.out.println(FEED_IS_EMPTY + "\n");
    }
}
