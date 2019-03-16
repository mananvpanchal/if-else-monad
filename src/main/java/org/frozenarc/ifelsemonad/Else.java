package org.frozenarc.ifelsemonad;

public interface Else<T, U> {

    Worker<T, U> els(Do<T, U> elsFn);
}
