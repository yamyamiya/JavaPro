package org.example.task1;

public class Task1 {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.fullName = "Игорь";
        person1.age = 23;
        Person person2 = new Person("Василий",22);
        person1.move();
        person1.talk();
        person2.move();
        person2.talk();

    }
}