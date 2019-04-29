package concurrent.lock.aqs;

public class ThreadTest2 extends Thread{

    @Override
    public void run() {
        System.out.println(getName() + "start");
        Money money = new Money();
        money.del();

        System.out.println(getName() + "end");
    }
}
