package org.example.task2;

public class Phone {
     String number;
     String model;
     String weight;
    public void receiveCall(String name){
        System.out.println("Звонит "+name);
    }

    public String getNumber() {
        return number;
    }
}
