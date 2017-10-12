package com.lohika.java8workshop.defaultmethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManualResolutionTest {

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


