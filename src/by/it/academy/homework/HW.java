package by.it.academy.homework;

import java.util.Arrays;
import java.util.List;

public class HW {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");

        List<String> firstList= myList.stream()
                .filter(string -> !string.contains("3"))
                .sorted((str1, str2) -> Integer.compare(Integer.parseInt(str1.substring(1)), Integer.parseInt(str2.substring(1))))
                .sorted((string1, string2) -> string2.compareTo(string1))
                .toList();
        System.out.println("Промежуточный результат" + firstList);

         List <String> secondList = firstList.stream()
                .limit(firstList.size()-1)  // у меня здесь вопрос: если не создавать новый список (secondList),
                                                    // то эта строка (18) не срабатывает, и получается в результате 5 элементов, а не 4
                .skip(1)
                .map(string -> string.toUpperCase())
                .toList();
        System.out.println(secondList);

        long listCount = secondList.stream()
                .count();
        System.out.println("Count on elements: " + listCount);
    }
}
