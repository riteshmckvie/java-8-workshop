package com.lohika.java8workshop.defaultmethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassResolutionTest {

    /**
     * The test demonstrates default method resolution rule where method
     * declaration in the class or a superclass takes priority over any
     * default method declaration. This rule has highest priority.
     *
     * The {@code getMessage()} implemented in class C is used.
     */
    @Test
    public void shouldResolveClassImplementationOfDefaultMethod() {
        D obj = new D();

        assertThat(obj.getMessage(), is("Message from C"));
    }

    interface A {
        default String getMessage() {
            return "Message from A";
        }
    }

    interface B extends A {

    }

    interface B1 extends B {
        @Override
        default String getMessage() {
            return "Message from B1";
        }
    }

    class C implements A {

        @Override
        public String getMessage() {
            return "Message from C";
        }
    }

    class D extends C implements B1 {
    }

}


