package ru.mirea.pr9;

import ru.mirea.pr9.exceptions.StudentNotFoundException;

import java.util.*;

public class LabClassDriver implements LabClassUI {
    private List<Student> students;

    public LabClassDriver() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> students() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    @Override
    public void sortByMark() {
        students.sort(Comparator.comparing(Student::getMark));
        Collections.reverse(students);
    }

    @Override
    public Student getStudent(
            String name,
            String surname)
            throws StudentNotFoundException {
        return students.stream().filter(st -> st.getName().equals(name) && st.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                String.format("%s %s", name, surname)));
    }

    @Override
    public String toString() {
        StringBuilder listOfStudents = new StringBuilder("----------------------------List of students----------------------------\n");

        for (Student student : students) {
            listOfStudents.append(student.toString()).append("\n");
        }

        return listOfStudents.toString();
    }
}

