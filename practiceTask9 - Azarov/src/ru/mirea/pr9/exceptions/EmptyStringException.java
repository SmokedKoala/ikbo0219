package ru.mirea.pr9.exceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Student's personal info is missing");
    }

}
