package ru.mirea.pr9;

public class TestException {
    public static void main(String[] args)
            throws WrongINNLengthException {
        Client client1 = new Client("John", "Snow",  "023910482947");
        System.out.println(client1);
        Client client2 = new Client("Tirion", "Lannister", "123456789");
        System.out.println(client2);
    }
}
