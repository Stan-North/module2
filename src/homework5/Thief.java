package homework5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Thief {
    private static final BigDecimal ZERO_VALUE = BigDecimal.ZERO;
    private static final String BANK_MONEY_FIELD_NAME = "money";
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchFieldException, IllegalAccessException {
        Field field = bank.getClass().getDeclaredField(BANK_MONEY_FIELD_NAME);
        field.setAccessible(true);
        money = (BigDecimal) field.get(bank);
        field.set(bank, ZERO_VALUE);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }
}
