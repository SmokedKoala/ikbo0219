package ru.mirea.pr9;

public class Client {
    final private String name;
    final private String surname;
    final private String inn;

    public Client(String name, String surname, String inn)
            throws WrongINNLengthException {
        if (inn.length() != 12)
            throw new WrongINNLengthException();
        this.name = name;
        this.surname = surname;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Client {" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", inn='" + inn + '\'' +
                '}';
    }
}
