package org.example.task2;

public class Task2 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        phone1.model = "Samsung";
        phone1.number = "777-777-777";
        phone1.weight = "120 g";
        Phone phone2 = new Phone();
        phone2.model = "Nokia";
        phone2.number = "333-333-333";
        phone2.weight = "110 g";
        Phone phone3 = new Phone();
        phone3.model = "Pixel";
        phone3.number = "555-555-555";
        phone3.weight = "100 g";
        System.out.println("First phone is "+phone1.model+ " with number: "+phone1.number+" and weight: "+phone1.weight);
        System.out.println("Second phone is "+phone2.model+ " with number: "+phone2.number+" and weight: "+phone2.weight);
        System.out.println("Third phone is "+phone3.model+ " with number: "+phone3.number+" and weight: "+phone3.weight);
        phone1.getNumber();
        phone2.getNumber();
        phone3.getNumber();
        phone1.receiveCall("Игорь");
        phone2.receiveCall("Василий");
        phone3.receiveCall("Ольга");




    }
}
