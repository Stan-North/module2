package homework5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runnner {
    private static final BigDecimal MONEY_QUANTITY = BigDecimal.valueOf(1500);
    private static final String METHOD_NAME_FOR_STEAL_MONEY = "stealMoney";

    public static void main(String[] args) {
        Bank bank = createBank(MONEY_QUANTITY);
        Thief thief = createThief();
        stealMoney(thief, bank);
        System.out.println(thief + "\n" + bank);
    }

    private static Bank createBank(BigDecimal money) {
        try {
            Class<Bank> bank = Bank.class;
            Constructor<Bank> bankConstructor = bank.getDeclaredConstructor(BigDecimal.class);
            bankConstructor.setAccessible(true);
            return bankConstructor.newInstance(money);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Thief createThief(){
        try {
            Class<Thief> thief = Thief.class;
            Constructor<Thief> thiefConstructor = thief.getDeclaredConstructor();
            thiefConstructor.setAccessible(true);
            return thiefConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void stealMoney(Thief thief, Bank bank) {
        try {
            Method method = thief.getClass().getDeclaredMethod(METHOD_NAME_FOR_STEAL_MONEY, Bank.class);
            method.setAccessible(true);
            method.invoke(thief, bank);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
