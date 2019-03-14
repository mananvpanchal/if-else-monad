package org.frozenarc;

import static org.junit.Assert.assertTrue;

import org.frozenarc.ifelsemonad.If;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test() {

        Assert.assertTrue(If.of("Ho, ", str -> str.equals("Ho"))
                .thn(str -> If.of(str, str2 -> str2.equals(""))
                        .thn(str2 -> str2 + "He")
                        .els(str2 -> str2 + "Hu")
                        .done())
                .els(str -> str + "hi")
                .done().equals("Ho, hi"));

        Assert.assertTrue(If.of("Ho", str -> str.equals("Ho"))
                .thn(If.<String>of(str2 -> str2.equals("Ho"))
                        .thn(str2 -> str2 + ", He")
                        .els(str2 -> str2 + ", Hu")
                        .delay())
                .els(If.<String>of(str2 -> str2.equals("Ho, "))
                        .thn(str2 -> str2 + "He")
                        .els(str2 -> str2 + "Hu")
                        .delay())
                .done().equals("Ho, He"));

    }

}
