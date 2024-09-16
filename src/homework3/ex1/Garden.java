package homework3.ex1;

import homework3.ex1.fruits.Fruit;

@FunctionalInterface
public interface Garden <T extends Fruit> {

    T growFruit();
}
