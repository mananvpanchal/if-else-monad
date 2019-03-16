package org.frozenarc.ifelsemonad;

public class Else<T, U> implements Do<T, U> {

    private Do<T, U> elsDo;


    public Else(Do<T, U> elsDo) {
        this.elsDo = elsDo;
    }

    @Override
    public U work(T value) {
        return elsDo.work(value);
    }
}
