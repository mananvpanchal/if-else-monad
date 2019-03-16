package org.frozenarc.ifelsemonad;

import java.util.function.Function;

public interface Do<T, U> {

    U work(T value);
}
