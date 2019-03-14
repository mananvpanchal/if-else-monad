package org.frozenarc.ifelsemonad;

import java.util.function.Function;

/*
* Author: Manan
* Date: 14-03-2019 13:50
*/
public class Then<T, U> {

    private Function<T, U> thnFn;
    private If<T> iff;

    private Then(Function<T, U> thnFn, If<T> iff) {
        this.thnFn = thnFn;
        this.iff = iff;
    }

    static <T, U> Then<T, U> of(Function<T, U> thnFn, If<T> iff) {
        return new Then<>(thnFn, iff);
    }

    public Else<T, U> els(Function<T, U> elsFn) {
        return Else.of(elsFn, this);
    }

    Function<T, U> getThnFn() {
        return thnFn;
    }

    If<T> getIf() {
        return iff;
    }
}
