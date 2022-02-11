package pack;

public class Tool {
    public static void sleepThis(long millis){
        try{
            Thread.sleep(millis);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
