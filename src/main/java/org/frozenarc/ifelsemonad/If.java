package org.frozenarc.ifelsemonad;

import java.lang.reflect.Type;
import java.util.function.Function;

/*
* Author: Manan
* Date: 14-03-2019 13:46
*/
public class If<T> {

    private T value;
    private Function<T, Boolean> ifFn;

    private If(T value, Function<T, Boolean> ifFn) {
        this.value = value;
        this.ifFn = ifFn;
    }

    private If(Function<T, Boolean> ifFn) {
        this.value = value;
        this.ifFn = ifFn;
    }

    public static <T> If<T> of(T value, Function<T, Boolean> ifFn) {
        return new If<>(value, ifFn);
    }

    public <U> Then<T, U> thn(Function<T, U> thnFn) {
        return Then.of(thnFn, this);
    }

    T getValue() {
        return value;
    }

    Function<T, Boolean> getIfFn() {
        return ifFn;
    }
}
