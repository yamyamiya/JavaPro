package org.example.Task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Создать лист студентов, куда поместить нескольких студентов с разными значениями полей.
// Написать метод, который принимает лист студентов и при помощи итератора удаляет всех студентов
// с номером курса меньше 3. Написать метод, который принимает лист студентов и имя в качестве
// второго параметра. С помощью итератора метод должен удалять всех студентов с таким именем.
public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Vasyl", "Hadiak", 4, 4));
        list.add(new Student("Olga", "Iamshchikova", 3, 5));
        list.add(new Student("Igor","Sadurkis", 2, 5));
        list.add(new Student("Andrey", "Tk", 6, 4));
        removeStudentsByClassNumber(list);
        removeStudentsByName(list, "Andrey");
    }

    public static void removeStudentsByClassNumber(List<Student> list){
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().classNumber<3){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static void removeStudentsByName(List<Student> list, String name){
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().firstName.equals(name)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}