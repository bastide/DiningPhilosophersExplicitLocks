package diningphilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class ChopStick {

    private final Lock verrou = new ReentrantLock();
    private static int stickCount = 0;
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    public boolean tryTake(int delay) throws InterruptedException {
        return verrou.tryLock(delay, TimeUnit.MILLISECONDS);
    }

    public void release() {
            verrou.unlock();
    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
