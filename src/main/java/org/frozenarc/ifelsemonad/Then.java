package org.frozenarc.ifelsemonad;

public class Then<T, U> implements Do<T, U> {

    private Do<T, U> thnDo;


    public Then(Do<T, U> thnDo) {
        this.thnDo = thnDo;
    }

    public Else<T, U> els(Do<T, U> elsDo) {
        return new Else<>(elsDo);
    }

    @Override
    public U work(T value) {
        return thnDo.work(value);
    }
}
