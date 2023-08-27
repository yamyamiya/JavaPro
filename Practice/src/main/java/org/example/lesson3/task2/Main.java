package org.example.lesson3.task2;

import org.example.lesson3.task2.MyCounter;
import org.example.lesson3.task2.MyThreadDecr;
import org.example.lesson3.task2.MyThreadInc;

public class Main{

    public static void main(String[] args) {

        // Задача 2:
        // Требуется создать потокобезопасный класс, который отвечает за счётчик с суммой. Предложите две реализации.
        // Методы: increment()/decrement()/getOperationsCount()/getCounterValue()


        MyCounter counter = new MyCounter();
        MyThreadInc incr = new MyThreadInc(counter);
        MyThreadDecr decr = new MyThreadDecr(counter);



        incr.start();
        decr.start();
        try {
            incr.join();
            decr.join();
      } catch (InterruptedException e){
            System.out.println("Error");
        }


        System.out.println(counter.getOperationsCount());
        System.out.println(counter.getCounterValue());






    }

}
