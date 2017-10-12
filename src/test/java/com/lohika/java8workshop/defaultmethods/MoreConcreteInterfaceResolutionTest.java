package com.lohika.java8workshop.defaultmethods;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoreConcreteInterfaceResolutionTest {

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

    interface C extends A {
        @Override
        default String getMessage() {
            return "Message from C";
        }
    }

    class D implements A, B, B1 {
    }

}



