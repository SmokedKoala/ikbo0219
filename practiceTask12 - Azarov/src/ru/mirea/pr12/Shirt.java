package ru.mirea.pr12;


public class Shirt {
    private String id, name, color, size;


    public Shirt() {
    }

    public Shirt(String id, String name, String color, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }


    private Shirt shirtFromString(String str) {
        String[] shirtStr = str.split(",");
        return new Shirt(shirtStr[0], shirtStr[1], shirtStr[2], shirtStr[3]);
    }

    private Shirt[] shirtsFromStrings(String[] arr) {
        Shirt[] shirts = new Shirt[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shirts[i] = shirtFromString(arr[i]);
        }
        return shirts;
    }

    @Override
    public String toString() {
        return "Shirt:" +
                "\nid='" + id + '\'' +
                "\nname='" + name + '\'' +
                "\ncolor='" + color + '\'' +
                "\nsize='" + size + '\'' +
                '\n';
    }

    public static void main(String[] args) {

        String[] strShirts = new String[11];
        strShirts[0] = "S001,Black Polo Shirt,Black,XL";
        strShirts[1] = "S002,Black Polo Shirt,Black,L";
        strShirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        strShirts[3] = "S004,Blue Polo Shirt,Blue,M";
        strShirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        strShirts[5] = "S006,Black T-Shirt,Black,XL";
        strShirts[6] = "S007,White T-Shirt,White,XL";
        strShirts[7] = "S008,White T-Shirt,White,L";
        strShirts[8] = "S009,Green T-Shirt,Green,S";
        strShirts[9] = "S010,Orange T-Shirt,Orange,S";
        strShirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt[] shirts = new Shirt().shirtsFromStrings(strShirts);

        for (Shirt shirt : shirts) {
            System.out.println(shirt);
        }
    }
}
