package synchronisation;

import pack.Tool;

public class Control extends Thread{
    private Resource r;

    public Control(Resource resource) {
        this.r = resource;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            synchronized (r){
                Tool.sleepThis(300);
                r.notifyAll();
            }
        }
    }
}
