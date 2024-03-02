public class Problem2 {
    public static void main(String[] args) {
        Player1 Player1 = new Player1(100);
        Thread a = new Thread(Player1, "Creep-A");
        Thread b = new Thread(Player1, "Creep-B");
        a.start();
        try {
            a.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        b.start();
    }
}
class Player1 implements Runnable{
    private int hp;

    public Player1(int hp) {
        this.hp = hp;
    }

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                if (hp <= 0) {
                    System.out.println(Thread.currentThread().getName() + ":当前Player1的ph值= " + hp);
                    System.out.println(Thread.currentThread().getName() + " Player1 is dead");
                    System.out.println(Thread.currentThread().getName() + " end");
                    break;
                } else {
                    hp -= 20;
                    System.out.println(Thread.currentThread().getName() + " attack...");
                    if(hp!=0)
                        System.out.println(Thread.currentThread().getName() + ":当前Player1的ph值= " + hp);
                }
            }
            if(hp!=0)
                System.out.println(Thread.currentThread().getName() + " end");
        }
    }
}
