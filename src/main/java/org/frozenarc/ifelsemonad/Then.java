package org.frozenarc.ifelsemonad;

import java.util.function.Function;

public interface Then<T, U> {

    Else<T, U> thn(Do<T, U> thnFn);

}