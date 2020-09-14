package ru.mirea.practice1;

public class TestCircle {
    public static void main(String[] args) {
    Circle c1 = new Circle("yellow", 23);
    Circle c2 = new Circle("green");
    c2.setRadius(12);
    System.out.println(c1);
    c2.getS();
}
}
