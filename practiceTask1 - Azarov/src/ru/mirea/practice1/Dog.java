package ru.mirea.practice1;
public class Dog {
    private String name;
    private int age;

    public Dog (String name, int age){
        this.name = name;
        this.age = age;
    }
    public Dog (String name){
        this.name = name;
    }

    public Dog(int age){
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public void toHumanAge(){
        System.out.println(this.age*7+" human years") ;
    }
    public String toString(){
        return "Name is "+this.name+" \nAge is "+this.age;
    }
}
