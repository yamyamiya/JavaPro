package javaPractice.lesson3.task2;

public class MyThreadInc extends Thread{

    private MyCounter myCounter;

    public MyThreadInc(MyCounter myCounter){
        this.myCounter = myCounter;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myCounter.increment();
        }

    }
}
