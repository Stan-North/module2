package homework3.ex1;

import homework3.ex1.fruits.Apple;
import homework3.ex1.fruits.Apricot;

public class Runner {
    public static void main(String[] args) {

        Garden<Apple> appleFarm = () -> new Apple();
        Garden<Apricot> apricotFarm = () -> new Apricot();

        Apple apple = appleFarm.growFruit();
        Apricot apricot = apricotFarm.growFruit();
    }
}
