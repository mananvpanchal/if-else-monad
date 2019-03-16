package org.frozenarc.ifelsemonad;

public class If<T> {

    private T value;
    private Condition<T> condFn;

    public If(T value, Condition<T> condFn) {
        this.value = value;
        this.condFn = condFn;
    }

    public static <T> If<T> of(T value, Condition<T> condFn) {
        return new If<>(value, condFn);
    }

    public <U> Then<T, U> thn(Do<T, U> thnDo) {
        return new Then<>(thnDo);
    }
}
