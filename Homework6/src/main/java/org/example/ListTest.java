package org.example;

import java.util.Iterator;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args) {
        MyLinkedListWithDoubleDirection list = new MyLinkedListWithDoubleDirection();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println("Размер листа " + list.size());
        System.out.println();
// выводим через toString
        System.out.println("Вывод через toString()");
        System.out.println(list);
        System.out.println();

        //выводим лист
        System.out.println("Вывод с помощью for");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");

        }
        System.out.println();
        System.out.println();

        // for each
        System.out.println("Вывод с помощью for each");
        for (String value : list) {
            System.out.print(value + " ");

        }
        System.out.println();
        System.out.println();

        //выводим с помощью итератора
        System.out.println("Вывод с помощью итератора:");
        ListIterator iterator = (ListIterator) list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Вывод с помощью итератора назад:");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();
        System.out.println();

        list.clear();
        System.out.println("После очистки:");
        System.out.println(list);

    }

}
