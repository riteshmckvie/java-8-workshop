package com.lohika.java8.workshop.defaultmethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoreConcreteInterfaceResolutionTest {

    /**
     * The test demonstrates default method resolution where the method
     * in the most specific default-providing interface is selected. This
     * rules has lower priority than 'Classes always win', and higher priority
     * over manual resolution.
     *
     * In this case {@code getMessage()} implemented in B1 is used, as B1 is the
     * most specific interface.
     */
    @Test
    public void shouldResolveMoreConcreteOfDefaultMethod() {
        D obj = new D();

        assertThat(obj.getMessage(), is("Message from B1"));
    }

    interface A {
        default String getMessage() {
            return "Message from A";
        }
    }

    interface B extends A {
        @Override
        default String getMessage() {
            return "Message from B";
        }
    }

    interface B1 extends B {
        @Override
        default String getMessage() {
            return "Message from B1";
        }
    }

    class D implements A, B, B1 {
    }

}



