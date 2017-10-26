package com.lohika.java8workshop.optional;

import com.lohika.java8workshop.optional.noopt.Car;
import com.lohika.java8workshop.optional.noopt.Person;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InsuranceJava7Test {

    @Test
    public void shouldGetKnownInsurance() {
        Insurance insurance = new Insurance("super-insurance");
        Car car = new Car(insurance);
        Person person = new Person(car);

        String insuranceName = getCarInsuranceName(person);
        assertThat(insuranceName, is("super-insurance"));
    }

    @Test
    public void shouldGetUnknownInsurance() {
        Person person = new Person(null);

        String insuranceName = getCarInsuranceName(person);
        assertThat(insuranceName, is("unknown"));
    }

    private static String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();

            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }

        return "unknown";
    }

}
