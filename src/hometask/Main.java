package hometask;

public class Main {
    public static void main(String[] args) {
        ControlThread c = new ControlThread();
        c.setPriority(10);
        c.start();
    }
}
