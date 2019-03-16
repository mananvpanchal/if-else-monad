package org.frozenarc;

import static org.junit.Assert.assertTrue;

import org.frozenarc.ifelsemonad.If;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test() {

        If.of("", s -> true).thn(s -> s).els(If.of("", s -> false).thn(s -> s));

    }

}
