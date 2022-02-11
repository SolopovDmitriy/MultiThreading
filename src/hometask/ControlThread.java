package hometask;

import java.util.Scanner;

public class ControlThread extends Thread{

    private String srcPath;
    private String destPath;
    CopyFileThread copyFileThread;


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
//        synchronized (this) {
            while (true) {
                String line = scanner.nextLine();
                switch (line) {
                    case "/f":
                        srcPath = scanner.nextLine();
                        break;
                    case "/d":
                        if (srcPath == null) {
                            System.out.println("You must enter src first!");
                            break;
                        }
                        if (copyFileThread == null || copyFileThread.isStopped()) {
                            destPath = scanner.nextLine();
                            copyFileThread = new CopyFileThread(srcPath, destPath);
                            copyFileThread.setPriority(1);
                            copyFileThread.run();
                        } else {
                            System.out.println("Another file is copying now! Wait or input /s to stop");
                        }
                        break;
                    case "/s":
                        if (copyFileThread != null) {
                            System.out.println("try to stop");
                            System.out.println(copyFileThread.isStopped());
                            copyFileThread.stopThis();
                            copyFileThread.interrupt();
                        }
                        break;
                    case "/q":
                        if (copyFileThread != null) {
                            copyFileThread.stopThis();
                        }
                        return; // exit
                    default:
                        System.out.println("Enter only /f, /d, /s, /q");
                        break;
                }

            }

//        }

    }




}
