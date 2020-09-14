package ru.mirea.practice3;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed) {
        this.radius = radius;
        this.center = new MovablePoint(x,y,xSpeed,ySpeed);
    }

    public String toString(){
        return "Circle with radius "+this.radius+" with Central "+center;
    }

    @Override
    public void moveUp() {
    center.moveUp();
    }

    @Override
    public void moveDown() {
    center.moveDown();
    }

    @Override
    public void moveLeft() {
    center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
}
