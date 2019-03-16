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

        /*Assert.assertTrue(If.of("Hello")
                .whn(s -> s != null)
                .thn(s -> s + " Manan")
                .els(s -> "Null").done().equals("Hello Manan"));

        Assert.assertTrue(If.of(null)
                .whn(s -> s != null)
                .thn(s -> s + " Manan")
                .els(s -> "Null").done().equals("Null"));*/
        String str = "Hello";
        Assert.assertTrue(If.<String, String>of(s -> s != null)
                .thn(s -> s + " Manan")
                .els(If.<String, String>of(s -> true)
                        .thn(s -> "Hi Bhumi")
                        .els(s -> s)).work("Halo").equals("Halo Manan"));

        Assert.assertTrue(If.<String, String>of(s -> s != null)
                .thn(s -> s + " Manan")
                .els(If.<String, String>of(s -> true)
                        .thn(s -> "Hi Bhumi")
                        .els(s -> s)).work(null).equals("Hi Bhumi"));

    }

}
