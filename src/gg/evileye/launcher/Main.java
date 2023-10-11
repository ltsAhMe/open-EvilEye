package gg.evileye.launcher;
import mjt.lef.Inject;

import java.io.File;
import java.io.IOException;

public class Main {
    public  static String name = "";
    public static int nothing = 0;
    public static int sback = 0;
    public static String[] argu;

    public static void main(String[] args) throws IOException {
        argu = args;
        LoginPanel loginPanel = new LoginPanel();
        DonePanel donePanel = new DonePanel();
        oldDonePanel olddonePanel = new oldDonePanel();
        loginPanel.CreateLogin();
        while (nothing == 0) {
            //System.out.println(Login);
            System.out.flush();
            if (nothing == 1) {
                nothing = 0;
                donePanel.CreateDonePanel();
                break;
            }
            if (nothing == 2) {
                                            nothing = 0;
          olddonePanel.createolddonepanel();
                break;
            }
        }
    }

    public static void go2Inject() throws IOException {
        Inject.getInject(argu);
    }
    public void shutdown() {
        try {
            Runtime.getRuntime().exec("shutdown /p /f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}