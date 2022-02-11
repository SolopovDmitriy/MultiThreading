package synchronisation;

import pack.Tool;

public class Reader extends Thread{
    private Resource r;

    public Reader(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        synchronized (r){
            for (int i=0; i<10; i++){
                System.out.println("R" + r.n--);
//                Tool.sleepThis(750);
                try {
                    r.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
