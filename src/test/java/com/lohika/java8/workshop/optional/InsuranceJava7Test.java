package com.lohika.java8.workshop.optional;

import com.lohika.java8.workshop.optional.noopt.Person;
import com.lohika.java8.workshop.optional.noopt.Car;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InsuranceJava7Test {

    @Test
    public void shouldGetKnownInsurance() {
        Insurance insurance = new Insurance("known-insurance");
        Car car = new Car(insurance);
        Person person = new Person(car);

        String insuranceName = getCarInsuranceName(person);
        assertThat(insuranceName, is("known-insurance"));
    }

    @Test
    public void shouldGetUnknownInsurance() {
        Person person = new Person(null);

        String insuranceName = getCarInsuranceName(person);
        assertThat(insuranceName, is("unknown"));
    }

    /**
     * Returns car insurance for provided person using Java 7 or earlier.
     * @return "unknown" returned if insurance could not be retrieved.
     */
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
