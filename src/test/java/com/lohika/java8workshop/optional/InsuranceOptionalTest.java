package com.lohika.java8workshop.optional;

import com.lohika.java8workshop.optional.opt.Car;
import com.lohika.java8workshop.optional.opt.Person;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InsuranceOptionalTest {

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
        Optional<Person> optPerson = Optional.ofNullable(person);

        return optPerson.flatMap(Person::getCar)
            .flatMap(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("unknown");
    }

}
