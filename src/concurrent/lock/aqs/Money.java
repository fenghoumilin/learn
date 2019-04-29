package concurrent.lock.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Money {

    private static int li = 100;
    private static int wang = 20;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            ThreadTest2 test2 = new ThreadTest2();
            test2.start();
            System.out.println("李 扣钱开始----");
            li -= 20;
            condition.await();
            System.out.println("李 扣钱结束----");
            System.out.println("李 余钱 = " + li);
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }


    }

    public void del() {
        lock.lock();
        try {
            System.out.println("王 收钱开始----");
            wang += 20;
            condition.signal();
            System.out.println("王 收钱结束----");
            System.out.println("王 余钱 = " + wang);
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

}
