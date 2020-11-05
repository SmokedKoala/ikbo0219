package ru.mirea.pr9;

import ru.mirea.pr9.exceptions.EmptyStringException;
import ru.mirea.pr9.exceptions.StudentNotFoundException;

import java.util.List;

public interface LabClassUI {
    List<Student> students();
    void addStudent(Student student) throws EmptyStringException;
    void addStudents(List<Student> students);
    void sortByMark();
    Student getStudent(String name, String surname) throws StudentNotFoundException;
}
