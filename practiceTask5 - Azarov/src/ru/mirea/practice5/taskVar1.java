package ru.mirea.practice5;

import java.util.Scanner;

public class taskVar1 {

    public static void main(String[] args) {
	    int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        recursion(N, 0);
    }

    public static void recursion(int N, int k) {
        if (k > N)
            return;
        else {
            for (int i = 0; i < k; i++)
                if(i==N-1)
                    System.out.print(k);
                else System.out.print(k+",");
            recursion(N, k + 1);
        }
    }
}
