package ru.mirea.practice2;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball();
        b1.setX(1.0);
        b1.setY(2.0);
        b1.move(76.0,32.1);
        System.out.println(b1);
    }
}
