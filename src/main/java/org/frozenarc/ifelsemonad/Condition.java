package org.frozenarc.ifelsemonad;

import java.util.function.Function;

public interface Condition<T> {

    boolean check(T value);
}
