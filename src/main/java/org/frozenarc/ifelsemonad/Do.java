package org.frozenarc.ifelsemonad;

public interface Do<T, U> {

    U work(T value);
}
