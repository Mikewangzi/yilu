public class Problem2_ {
    public static void main(String[] args) {
        Player2 player = new Player2(100);
        Thread a = new Thread(player, "Creep-A");
        Thread b = new Thread(player, "Creep-B");
        a.start();
        try {
            a.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        b.start();
    }
}
class Player2 implements Runnable{
    private int hp;

    public Player2(int hp) {
        this.hp = hp;
    }

    public synchronized void run() {
        attack();
    }
    public void attack(){
        for (int i = 0; i < 3; i++) {
            if (hp <= 0) {
                System.out.println(Thread.currentThread().getName() + ":当前Player2的ph值= " + hp);
                System.out.println(Thread.currentThread().getName() + " Player2 is dead");
                System.out.println(Thread.currentThread().getName() + " end");
                break;
            } else {
                hp -= 20;
                System.out.println(Thread.currentThread().getName() + " attack...");
                if(hp!=0)
                    System.out.println(Thread.currentThread().getName() + ":当前Player2的ph值= " + hp);
            }
        }
        if(hp!=0)
            System.out.println(Thread.currentThread().getName() + " end");
    }
}

