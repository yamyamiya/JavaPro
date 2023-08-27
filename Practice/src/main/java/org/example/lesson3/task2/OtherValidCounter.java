package javaPractice.lesson3.task2;

public class OtherValidCounter {

    private int counter = 0;
    private int operationsCounter = 0;

    public synchronized void increment(){
        counter++;
        operationsCounter++;
    }

    public synchronized void decrement(){
        counter--;
        operationsCounter++;
    }

    public synchronized int getOperationsCounter(){
        return operationsCounter;
    }

    public synchronized int getCounterValue(){
        return counter;
    }
}
