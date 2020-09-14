package ru.mirea.practice1;

public class Circle {
    private int radius;
    private String colour;

    public Circle(String colour, int radius){
    this.colour = colour;
    this.radius = radius;
    }
    public Circle(String colour){
        this.colour = colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public String getColour() {
        return colour;
    }
    public void getS (){
        System.out.println("Square is "+4*3.14*radius);
    }
    public String toString(){
        return "Radius is "+this.radius+" \nColour is "+this.colour;
    }
}

