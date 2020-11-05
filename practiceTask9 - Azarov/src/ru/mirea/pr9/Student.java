package ru.mirea.pr9;

import ru.mirea.pr9.exceptions.EmptyStringException;

public class Student implements Comparable<Student> {
    final private String name;
    final private String surname;
    private Double mark;

    public Student(String name, String surname, Double mark)
            throws EmptyStringException {
        if (name.isEmpty() || surname.isEmpty())
            throw new EmptyStringException();
        this.name = name;
        this.surname = surname;
        this.mark = mark;
    }

    public Double getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student secondStudent) {
        return mark.compareTo(secondStudent.getMark());
    }

    @Override
    public String toString() {
        return "Student {" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", mark = " + mark +
                '}';
    }
}
