package homework1.ex1;

import homework1.ex1.animals.Animal;

public class Zoo <T extends Animal, S extends Animal, U extends Animal > {
    private T firstAnimal;
    private S secondAnimal;
    private U thirdAnimal;

    public Zoo(T firstAnimal, S secondAnimal, U thirdAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.thirdAnimal = thirdAnimal;
    }

    public T getFirstAnimal() {
        return firstAnimal;
    }

    public S getSecondAnimal() {
        return secondAnimal;
    }

    public U getThirdAnimal() {
        return thirdAnimal;
    }
}
