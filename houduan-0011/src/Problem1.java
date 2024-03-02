import java.util.concurrent.locks.ReentrantLock;

public class Problem1 {
    public static void main(String[] args) {
        Data deliciousBeef = new Data("Delicious beef");
        foodConsumer foodConsumer1 = new foodConsumer(deliciousBeef);
        foodProducer foodProducer1 = new foodProducer(deliciousBeef);
        Thread con1 = new Thread(foodConsumer1, "消费者1");
        Thread con2 = new Thread(foodConsumer1, "消费者2");
        Thread pro1 = new Thread(foodProducer1, "生产者1");
        Thread pro2 = new Thread(foodProducer1, "生产者2");
        con1.start();
        con2.start();
        pro1.start();
        pro2.start();
    }
}
interface Producer extends Runnable{
    void produce(Data date);
}
interface  Consumer extends  Runnable{
    void consumer(Data data);
}
class Data{
    private String content;

    public Data(String content) {
        this.content = content;
    }
    public String getContent(){
        return content;
    }
}
class foodProducer implements Producer{
    private Data data;

    public foodProducer(Data data) {
        this.data = data;
    }

    private final ReentrantLock Lock = new ReentrantLock();
    public void produce(Data data){
        Lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"Producing food:"+data.getContent());
        } finally {
            Lock.unlock();
        }
    }
    public void run(){
        this.produce(data);
    }
}
class foodConsumer implements Consumer{
    private Data data;

    public foodConsumer(Data data) {
        this.data = data;
    }

    public void consumer(Data data){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "Consuming food:" + data.getContent());
        }
    }

    @Override
    public void run() {
        this.consumer(data);
    }
}
