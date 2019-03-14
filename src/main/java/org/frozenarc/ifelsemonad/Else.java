package org.frozenarc.ifelsemonad;

import java.util.function.Function;

/*
* Author: Manan
* Date: 14-03-2019 13:55
*/
public class Else<T, U> {

    private Function<T, U> elsFn;
    private Then<T, U> thn;

    private Else(Function<T, U> elsFn, Then<T, U> thn) {
        this.elsFn = elsFn;
        this.thn = thn;
    }

    static <T, U> Else<T, U> of(Function<T, U> elsFn, Then<T, U> thn) {
        return new Else<>(elsFn, thn);
    }


    Function<T, U> getElsFn() {
        return elsFn;
    }

    Then<T, U> getThn() {
        return thn;
    }

    public U done() {
        return getThn().getIf().getIfFn().apply(getThn().getIf().getValue())
                ? getThn().getThnFn().apply(getThn().getIf().getValue())
                : getElsFn().apply(getThn().getIf().getValue());
    }

    public Function<T, U> delay() {
        return val -> getThn().getIf().getIfFn().apply(val)
                ? getThn().getThnFn().apply(val)
                : getElsFn().apply(val);
    }
}
