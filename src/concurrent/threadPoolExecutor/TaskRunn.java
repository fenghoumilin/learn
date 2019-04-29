package concurrent.threadPoolExecutor;

import java.util.Random;
import java.util.concurrent.Callable;

public class TaskRunn implements Callable<String> {

     private int id;
     public TaskRunn(int id) {
         this.id = id;
     }

    /**
    39      * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行
    40      */
    @Override
    public String call() throws Exception {

        System.out.println("call() begin..."+id+"//"+Thread.currentThread().getName());
        if (new Random().nextInt(10) > 5) {
            throw new TaskException("task err:"+id+"//"+Thread.currentThread().getName());
        }
         // 模拟业务耗时
        for (int i = 0; i < 10; i++) {
             Thread.sleep(1000);
        }
        return "result:"+id+"//" +Thread.currentThread().getName();
    }
}
