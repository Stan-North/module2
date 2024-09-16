package homework3.ex4;

public class Runner {
    public static void main(String[] args) {

        Ruler<Animal> animalRuler = animal -> animal.getBodyLength() + animal.getTailLength();
        Ruler<Boat> boatRuler = boat -> boat.getLength();

        System.out.println(animalRuler.makeMeasure(new Animal(60,40)));
        System.out.println(boatRuler.makeMeasure(new Boat(320)));
    }
}
