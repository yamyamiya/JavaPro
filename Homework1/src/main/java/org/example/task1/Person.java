package org.example.task1;

public class Person {
    public Person(){};

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    String fullName;
    int age;
    public void move(){
        System.out.println(fullName+" идёт");
    }
    public void talk(){
        System.out.println(fullName+" говорит");
    }
}
