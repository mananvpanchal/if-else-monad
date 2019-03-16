package org.frozenarc.ifelsemonad;

import java.util.function.Function;

public class Worker<T, U> implements Do<T, U> {

    private Function<T, Boolean> whnFn;
    private Do<T, U> thnFn;
    private Do<T, U> elsFn;

    @Override
    public U work(T value) {
        return whnFn.apply(value)
                ? thnFn.work(value)
                : elsFn.work(value);
    }

    static <T, U> Worker<T, U> of(Function<T, Boolean> whnFn) {
        Worker<T, U> worker = new Worker<>();
        return worker.whnFn(whnFn);
    }

    Worker<T, U> whnFn(Function<T, Boolean> whnFn) {
        this.whnFn = whnFn;
        return this;
    }

    Worker<T, U> thnFn(Do<T, U> thnFn) {
        this.thnFn = thnFn;
        return this;
    }

    Worker<T, U> elsFn(Do<T, U> elsFn) {
        this.elsFn = elsFn;
        return this;
    }
}
