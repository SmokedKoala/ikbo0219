package ru.mirea.pr12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//Для корректной работы файл должен быть помещен в корневую папку проекта - в данном случае это файл words.txt

public class Words {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<String> tempList = new ArrayList<>();
        while (bufferedReader.ready()) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                tempList.add(stringTokenizer.nextToken().replace(" ", ""));
            }
        }
        String[] words = new String[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            words[i] = tempList.get(i);
        }
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) {
            return sb;
        }
        List<String> unsorted = new ArrayList<>(Arrays.asList(words));
        List<String> sorted = new ArrayList<>();
        int temp = 0;
        while (sorted.size() != words.length) {
            sorted.add(unsorted.remove(++temp));
            for (int i = 0; i < unsorted.size(); ) {
                if (sorted.get(sorted.size() - 1).substring(sorted.get(sorted.size() - 1).length() - 1)
                        .equalsIgnoreCase(unsorted.get(i).substring(0, 1))) {
                    sorted.add(unsorted.remove(i));
                    i = 0;
                } else {
                    i++;
                }
            }
            if (unsorted.size() != 0) {
                unsorted.addAll(sorted);
                sorted.clear();
            }
        }
        for (String s : sorted) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(s);
        }
        return sb;
    }
}
