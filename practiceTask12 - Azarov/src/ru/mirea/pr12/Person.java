package ru.mirea.pr12;

public class Person {
    private String firstName, lastName, middleName;

    Person(String lastName) {
        this.lastName = lastName;
    }

    Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String toString() {
        if (firstName == null || middleName == null) {
            return lastName;
        } else {
            return (lastName + " " + ((firstName.toUpperCase()).toCharArray())[0] + "." + ((middleName.toUpperCase()).toCharArray())[0] + ".");
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Johnson", "John", "Eric");
        System.out.println(person);
        Person person2 = new Person("Pavlinina");
        System.out.println(person2);
    }
}
