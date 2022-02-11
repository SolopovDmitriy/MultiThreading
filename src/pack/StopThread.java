package pack;

public class StopThread extends Thread{
    public volatile boolean cont=true;
    public void stopThis(){
        cont=false;
    }

    @Override
    public void run() {
        int i=0;
        while(cont) {
            System.out.println(i++);
            Tool.sleepThis(500);
        }
    }
}
