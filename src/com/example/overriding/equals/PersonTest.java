package com.example.overriding.equals;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testEquals() throws Exception {
        Person person = new Person(0,"fi","la");
        Person person1 = new Person(0,"fi","la");
        Person person2 = new Person(1,"fi","la");
        Person person3 = new Person(0,"if","al");

        assert(person.equals(person1));
        assert(person1.equals(person));
        assert(!person.equals(person2));
        assert(!person.equals(person3));

    }

    @Test
    public void testHashCode() throws Exception {
        Person person = new Person(0,"fi","la");
        Person person1 = new Person(0,"fi","la");
        Person person2 = new Person(1,"fi","la");
        Person person3 = new Person(0,"if","al");

        assert(person.hashCode() == person1.hashCode());
        assert(person.hashCode() != person2.hashCode());
        assert(person.hashCode() != person3.hashCode());

    }
}

