package homework3.ex2;

public class Runner {
    private static final int MIN_VALUE = 210;
    public static void main(String[] args) {

        Divination<String> chamomile = name -> name.length() % 2 == 0;
        Divination<Human> prophetess = human -> (human.getAge() + human.getHeight()) > MIN_VALUE;

        System.out.println(chamomile.makeDivination("Vladimir"));
        System.out.println(prophetess.makeDivination(new Human(30, 190)));
    }
}
