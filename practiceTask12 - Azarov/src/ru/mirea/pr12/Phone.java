package ru.mirea.pr12;

public class Phone {
    private final String number;

    public Phone(String phoneNumber) {
        this.number = parsePhoneNumber(phoneNumber);
    }

    public String parsePhoneNumber(String number) {

        String code = number.substring(0, number.length() - 10);

        if (!(number.charAt(0) == '+')) {
            code = "+" + code;
        }

        number = number.substring(number.length() - 10);
        return code + number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6, 10);
    }

    @Override
    public String toString() {
        return "Phone number: " + number;
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("+104289652211");
        Phone phone2 = new Phone("89175655655");
        System.out.println(phone1);
        System.out.println(phone2);

    }
}
