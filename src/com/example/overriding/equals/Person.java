package com.example.overriding.equals;

/**
 * Created by user on 2015/2/5.
 * Read more: http://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#ixzz3Qs3RvwlS
 */
public class Person {
    private int id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Person p = (Person) o;
        if (this.id != p.id) return false;
        if (!this.firstName.equals(p.firstName)) return false;
        if (!this.lastName.equals(p.lastName)) return false;

        return true;
        /* http://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#ixzz3QsJNe5U0
            implement as :
            return id == guest.id
            && (firstName == guest.firstName || (firstName != null && firstName.equals(guest.getFirstName())))
            && (lastName == guest.lastName || (lastName != null && lastName .equals(guest.getLastName())));
         */
    }

    @Override
    public int hashCode() {
        int result = this.id;
        result = 37 * result + this.firstName.hashCode();
        result = 37 * result + this.lastName.hashCode();
        return result;
        /*
            note that firstName and lastName can be null
            so should check :
            result = 37 * result + (firstName == null? 0 : firstName.hashCode());
            result = 37 * result + (lastName == null? 0 : lastName.hashCode());
         */
    }
}
