package ru.mirea.pr9;

import ru.mirea.pr9.exceptions.EmptyStringException;
import ru.mirea.pr9.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSort {
    public static void main(String[] args)
            throws EmptyStringException, StudentNotFoundException {
        LabClassUI classUI = new LabClass().getClassUi();

        classUI.addStudent(new Student("Stephen", "King",  5.0));
        classUI.addStudent(new Student("Robert", "Burns",  3.5));
        classUI.addStudent(new Student("Virginia", "Woolf",  4.2));
        classUI.addStudent(new Student("John", "Steinbeck",  3.3));

        ArrayList<Student> testStudents= new ArrayList<Student>();
        testStudents.add(new Student("Agatha", "Christie", 4.8));
        testStudents.add(new Student("George", "Martin", 2.6));
        testStudents.add(new Student("Walt", "Whitman", 3.8));
//        testStudents.add(new Student("Mike", "", 2.0));
        classUI.addStudents(testStudents);
        System.out.println(classUI);

        classUI.sortByMark();
        System.out.println(classUI);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's name and surname: ");
        System.out.println(classUI.getStudent(scanner.next(), scanner.next()));
    }
}

