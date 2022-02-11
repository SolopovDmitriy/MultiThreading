package synchronisation;

public class Main {
    public static void main(String[] args) {
        Resource res = new Resource();
        Writer w = new Writer(res);
        Reader r = new Reader(res);
        Control c = new Control(res);
        w.start();
        r.start();
        c.start();
    }
}
