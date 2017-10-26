package com.lohika.java8workshop.defaultmethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManualResolutionTest {

    /**
     * The test demonstrates explicit manual resolution of ambiguous default method. This
     * is used after applying two previous resolution rules (Classes always win,
     * sub-interfaces win) still give ambiguous result.
     *
     * While implementing {@code getMessage()} in class D, the
     * explicit method call should be used.
     */
    @Test
    public void shouldResolveClassImplementationOfDefaultMethod() {
        D obj = new D();

        assertThat(obj.getMessage(), is("Message from B"));
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

    interface C extends A {
        @Override
        default String getMessage() {
            return "Message from C";
        }
    }

    class D implements B, C {

        @Override
        public String getMessage() {
            return B.super.getMessage();
        }
    }

}


