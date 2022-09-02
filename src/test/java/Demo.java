import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        A a=new A();
        a.start();
        B b=new B();
        Thread thread=new Thread(b);
        thread.start();
        C c=new C();
        FutureTask<String> futureTask=new FutureTask<String>(c);
        Thread thread1=new Thread(futureTask);
        thread1.start();
        System.out.println(futureTask.get());
    }

}
class A extends Thread{
    public void run(){
        Thread.currentThread().setName("继承Thread类的线程一");
        System.out.println(Thread.currentThread().getName());
    }
}
class B implements Runnable{

    @Override
    public void run() {
        Thread.currentThread().setName("实现Runnable接口的线程二");
        System.out.println(Thread.currentThread().getName());
    }
}
class C implements Callable{


    @Override
    public Object call() throws Exception {
        Thread.currentThread().setName("实现Runnable接口的线程三");
        System.out.println(Thread.currentThread().getName());
        return "adad";
    }
}