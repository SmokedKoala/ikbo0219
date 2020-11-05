package ru.mirea.pr9;

public class LabClass {
    final private LabClassUI classUI;

    public LabClass() {
        this.classUI = new LabClassDriver();
    }

    public LabClassUI getClassUi() {
        return classUI;
    }

    @Override
    public String toString() {
        return classUI.toString();
    }
}
