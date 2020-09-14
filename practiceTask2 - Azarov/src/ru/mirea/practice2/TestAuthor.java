package ru.mirea.practice2;

public class TestAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Mike", "mike.mail,ru", 'm');
        a1.setEmail("mike2.mail.ru");
        System.out.println(a1);
    }
}
