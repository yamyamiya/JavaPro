package javaPractice.lesson3.task2;

import java.util.concurrent.atomic.AtomicReference;


// Методы: increment()/decrement()/getOperationsCount()/getCounterValue()

public class MyCounter {

    private final AtomicReference<State> referenceState = new AtomicReference<>(new State());

    public void increment() {
        referenceState.updateAndGet(state -> {
            State state1 = new State();
            state1.counter = state1.counter+1;
            state1.operationCounter = state.operationCounter+1;
            return state1;
        });
    }

    public void decrement() {
        referenceState.updateAndGet(state -> {
            State state1 = new State();
            state1.counter = state1.counter - 1;
            state1.operationCounter = state.operationCounter + 1;
            return state1;
        });
    }

    public int getOperationsCount() {
        return referenceState.get().operationCounter;
    }

    public int getCounterValue(){
        return referenceState.get().counter;


    }

}
class State {
    public int counter;
    public int operationCounter;
}
