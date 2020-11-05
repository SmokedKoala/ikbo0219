package ru.mirea.pr12;


import java.util.StringTokenizer;

public class Address {
    private final String country, region, city, street, house, block, flat;

    public Address(String str) {
        String[] arr = getAddressArray(str);
        this.country = arr[0];
        this.region = arr[1];
        this.city = arr[2];
        this.street = arr[3];
        this.house = arr[4];
        this.block = arr[5];
        this.flat = arr[6];
    }

    private String[] getAddressArray(String str) {
        String[] arr = new String[7];
        str = str.replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(str, ",.;-");

        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = st.nextToken();
            i++;
        }
        return arr;
    }

    public String toString() {
        return ("Полный адрес: " + country + ", " + region + ", г." + city + ", ул." + street + ", д." + house + "к" + block + ", " + flat);
    }

    public static void main(String[] args) {
        Address address = new Address("   Россия, 77, Москва, Академическая, 22А, 3, 666  ");
        System.out.println(address);
        address = new Address("Россия.77.Москва.Академическая.22А.3.666    ");
        System.out.println(address);
        address = new Address("   Россия-77-Москва-Академическая-22А-3-666");
        System.out.println(address);
        address = new Address("Россия;77;Москва;Академическая;22А;3;666");
        System.out.println(address);
    }
}
