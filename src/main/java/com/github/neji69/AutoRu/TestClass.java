package com.github.neji69.AutoRu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {
    public static void main(String[] args) {
        char test = 50;
        System.out.println( test);

        Pattern pattern = Pattern.compile("\\d+");
        String word = "Показать 1 798 предложений";
        word = word.replace(" ", "");// мой пример строки
        Matcher matcher = pattern.matcher(word);
        int start = 0;
        while (matcher.find(start)) {
            String value = word.substring(matcher.start(), matcher.end());
            int result = Integer.parseInt(value);
            start = matcher.end();
        }
        System.out.println();

//        String str = "ProgLang";
//        char[] strToArray = str.toCharArray(); // Преобразуем строку str в массив символов (char)
//        // Вывод массива на экран
//        for(int i = 0; i < strToArray.length; i++) {
//            if (strToArray[i] != 49 || 50)
//        }
    }


}
