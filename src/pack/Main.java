package pack;

public class Main {

    public static void main(String[] args) {
       /* Thread thread = Thread.currentThread();
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());*/

        /*MyThread th = new MyThread();
        th.setDaemon(true);
        th.start();*/

        /*Thread th2 = new Thread(new MyRunnable());
        th2.start();*/

        /*new Thread(() -> {
            try{
                for (int i=0; i<10; i++){
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();*/

        /*Thread t = new Thread(() -> {
            int i=0;
            while(true) {
                System.out.println(i++);
                Tool.sleepThis(500);
            }
        });
        t.start();*/

        StopThread s = new StopThread();
        s.start();

        Tool.sleepThis(5000);
        s.stopThis();
//        s.cont = false;
//        t.interrupt();
        System.out.println("END");


    }
}
