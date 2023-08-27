package javaPractice.lesson3.task2;

public class MyThreadDecr extends Thread {

    private MyCounter myCounter;

    public MyThreadDecr(MyCounter myCounter){
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myCounter.decrement();
        }

    }
}
