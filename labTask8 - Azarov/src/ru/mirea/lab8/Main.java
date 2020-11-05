package ru.mirea.lab8;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Task1
        writeToFile(false);
        System.out.println();

        //Task2
        readFile();
        System.out.println("\n");

        //Task3
        System.out.println("Now your line will rewrite the current text file.");
        writeToFile(false);
        readFile();
        System.out.println("\n");

        //Task4
        System.out.println("Now your will be written into the end of the file.");
        writeToFile(true);
        System.out.println();
        readFile();

    }

    private static void writeToFile(boolean append) {
        try (FileWriter writer = new
                FileWriter("notes.txt", append)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your line to write into the file: ");

            String text = scanner.nextLine();
            writer.write(text);
            writer.flush();
            System.out.println("Your line was written in the file!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void readFile() {
        try (FileReader reader = new
                FileReader("notes.txt")) {
            int c;
            System.out.println("Lines from your text file:");
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
