package ru.mirea.practice6;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of students in the 1st list: ");
        Student[] students1 = new Student[scanner.nextInt()];
        System.out.print("Enter amount of students in the 2nd list: ");
        Student[] students2 = new Student[scanner.nextInt()];

        //fill the ID in both arrays
        for (int i = 0; i < students1.length; i++) {
            students1[i] = new Student((int) Math.round(Math.random() * 1000), 1 + "l" + i + " student");
        }
        for (int i = 0; i < students2.length; i++) {
            students2[i] = new Student((int) Math.round(Math.random() * 1000), 2 + "l" + i + " student");
        }

        //print both initial arrays
        System.out.println();
        System.out.println("First initial array:");
        Arrays.stream(students1).forEach(System.out::println);
        System.out.println();
        System.out.println("\nSecond initial array:");
        Arrays.stream(students2).forEach(System.out::println);

        //sort arrays separately
        mergeSort(students1, 0, students1.length - 1);
        mergeSort(students2, 0, students2.length - 1);

        //print sorted arrays
        System.out.println("\nFirst sorted array:");
        Arrays.stream(students1).forEach(System.out::println);
        System.out.println();
        System.out.println("\nSecond sorted array:");
        Arrays.stream(students2).forEach(System.out::println);
        System.out.println();

        //print final array
        System.out.println("\nMerged sorted array:");
        Arrays.stream(mergeArrays(students1, students2)).forEach(System.out::println);
    }

    private static Student[] mergeArrays(Student[] sortedArray1, Student[] sortedArray2) {
        int i = 0, j = 0;
        Student[] resArray = new Student[sortedArray1.length + sortedArray2.length];
        Student student;
        for (int k = 0; k < resArray.length; k++) {
            if (i > sortedArray1.length - 1) {
                student = sortedArray2[j];
                resArray[k] = student;
                j++;
            }
            else if (j > sortedArray2.length - 1) {
                student = sortedArray1[i];
                resArray[k] = student;
                i++;
            }
            else if (sortedArray1[i].getId() < sortedArray2[j].getId()) {
                student = sortedArray1[i];
                resArray[k] = student;
                i++;
            } else {
                student = sortedArray2[j];
                resArray[k] = student;
                j++;
            }
        }
        return resArray;
    }

    private static void mergeSort(Student[] students, int first, int last) {
        if (last <= first)
            return;
        int mid = first + (last - first) / 2;
        mergeSort(students, first, mid);
        mergeSort(students, mid + 1, last);

        Student[] buffer = Arrays.copyOf(students, students.length);
        if (last - first + 1 >= 0) {
            System.arraycopy(students, first, buffer, first, last - first + 1);
        }
        int i = first, j = mid + 1;
        for (int c = first; c <= last; c++) {
            if (i > mid) {
                students[c] = buffer[j];
                j++;
            } else if (j > last) {
                students[c] = buffer[i];
                i++;
            } else if (buffer[j].getId() < buffer[i].getId()) {
                students[c] = buffer[j];
                j++;
            } else {
                students[c] = buffer[i];
                i++;
            }
        }
    }
}
