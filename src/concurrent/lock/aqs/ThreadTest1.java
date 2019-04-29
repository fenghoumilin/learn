package concurrent.lock.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest1 extends Thread {

    private static int total = 100;
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            System.out.println(getName() + "start");
            Money money = new Money();
            money.add();

            System.out.println(getName() + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
