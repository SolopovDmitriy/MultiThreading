package hometask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class CopyFileThread extends Thread{

    private final String srcPath;
    private final String destPath;
    private final AtomicBoolean stopped;

    public CopyFileThread(String srcPath, String destPath) {
        this.srcPath = srcPath;
        this.destPath = destPath;
        stopped = new AtomicBoolean(false);
    }

    public void stopThis(){
        // stop = true;
        stopped.set(true);
    }

    public boolean isStopped() {
        return stopped.get();
    }

    @Override
    public void run() {
        System.out.println("start copy file");
        File src = new File(srcPath);
        File dest = new File(destPath);
        try(FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest)){
            byte[] buf = new byte[1024];
            int count;
            while((count=fis.read(buf)) > 0){
                fos.write(buf, 0, count);
                if(stopped.get()){
                    System.out.println("stop copying ");
                    break;
                }
                Thread.yield();
            }
            if(stopped.get()){
                boolean isDeleted = dest.delete();
                System.out.println("thread is stopped. File is deleted = " + isDeleted);
            }else{
                System.out.println("File is copied successfully");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            // stop = true;
            stopped.set(true);
        }
    }

}
