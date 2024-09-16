package homework3.ex3;

public class Runner {
    private static final String GREEN_LIGHT_MESSAGE = "зеленый свет вокруг!";
    private static final String ORANGE_LIGHT_MESSAGE = "желто-красный свет вокруг!";

    public static void main(String[] args) {

        Burning<Uran> atomicReactror = uran -> System.out.println(GREEN_LIGHT_MESSAGE);
        Burning<Tree> fire = tree -> System.out.println(ORANGE_LIGHT_MESSAGE);

        atomicReactror.burn(new Uran());
        fire.burn(new Tree());
    }
}
