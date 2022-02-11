package synchronisation;

import pack.Tool;

public class Resource {
    public volatile int n;

    public synchronized void write(){
        for (int i=0; i<10; i++){
            System.out.println(n++);
            Tool.sleepThis(750);
        }
    }

    public synchronized void read(){
        for (int i=0; i<10; i++){
            System.out.println(n--  );
            Tool.sleepThis(750);
        }
    }
}
