package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//         1. Создать лист.
        List<Integer> list = new ArrayList<>();


//В цикле наполнить лист 10 миллионами значений (от 1 до 10000000)
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        int listSize = list.size();

//Перебрать лист с помощью for-each, в теле цикла каждое значение листа записать в переменную temp.
        long time11 = System.currentTimeMillis();
        for (Integer number : list) {
            int tmp = number;
        }
        long time12 = System.currentTimeMillis();
        System.out.println((time12 - time11));

//        Сделать то же самое с помощью классического for.
        time11 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.indexOf(i);
        }
        time12 = System.currentTimeMillis();
        System.out.println((time12 - time11));
//Сделать то же самое с помощью классического for, но сначала вынести размер листа в отдельную переменную,
// а потом эту переменную использовать внутри условия цикла.
        time11 = System.currentTimeMillis();
        for (int i = 0; i < listSize; i++) {
            int tmp = list.indexOf(i);
        }
        time12 = System.currentTimeMillis();
        System.out.println((time12 - time11));
//Сделать то же самое, что и в пункте 5, но перебрать лист с конца до начала.
        time11 = System.currentTimeMillis();
        for (int i = listSize - 1; i >= 0; i--) {
            int tmp = list.indexOf(i);
        }
        time12 = System.currentTimeMillis();
        System.out.println((time12 - time11));

//Сделать то же самое, но используя Iterator.
        time11 = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        time12 = System.currentTimeMillis();
        System.out.println((time12 - time11));

//Сделать то же самое, но используя ListIterator.
//Для всех случаев 3-8 замерить время, в течение которого отрабатывает цикл
        time11 = System.currentTimeMillis();
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        time12 = System.currentTimeMillis();
        System.out.println((time12 - time11));


    }
}