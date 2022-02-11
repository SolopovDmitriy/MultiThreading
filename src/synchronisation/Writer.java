package synchronisation;

import pack.Tool;

public class Writer extends Thread{
    private Resource r;

    public Writer(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        synchronized (r){
            for(int i=0 ; i<10; i++){
                System.out.println("W" + r.n++);
//                Tool.sleepThis(750);
                try{
                    r.wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
//        r.write();
    }
}
