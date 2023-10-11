package gg.evileye.launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.IOException;

public class oldDonePanel {
    static Color normolRED = new Color(172, 4, 40);
    static Color clickRED = new Color(128, 3, 30);
    static Color injectC = normolRED;
    static Color normol = new Color(213, 217, 219);
   static Color clicked = new Color(189, 193, 196);
    static boolean s1,s2,s3 = false;
    static   Color S1c,S2c,S3c = normol;
    static Image java = Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/java.png"));
    static Image profile = Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/profile.png"));
    static Font Nfont = new Font("Helvetica", Font.PLAIN, 26);
    LoginPanel loginPanel = new LoginPanel();
    static int yZhou = 230;
    static int[] s;
    private static Color ButtonExit = new Color(253, 83, 83);
    private static Color ButtonHind = new Color(165, 165, 165);
    private int mouseX, mouseY;
    private static int now = 1;


    public void createolddonepanel() {

        JFrame jFrame = new JFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(850, 500);
        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(255, 255, 255));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = definePanel();
        setPanel(jPanel, jFrame);
        jFrame.add(jPanel);
        loginPanel.GetUP(jPanel, jFrame);

        jPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        jPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = jFrame.getLocation().x + e.getX() - mouseX;
                int y = jFrame.getLocation().y + e.getY() - mouseY;
                jFrame.setLocation(x, y);
            }
        });

        jFrame.setVisible(true);
    }

    public static JPanel definePanel() {
        JPanel jpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                FontMetrics metrics = g2d.getFontMetrics(Nfont);
                int textWidth = metrics.stringWidth(Main.name);
                int x = (getWidth() - textWidth) / 2;
                int cornerRadius = 30;
                int width = getWidth();
                int height = getHeight();
                int arcSize = 20; // 圆角的大小
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 绘制红色边框
                g2d.setColor(new Color(237, 242, 246));
                g2d.fillRect(0, 0, width, height);
                g2d.setColor(Color.white);
                g2d.fillRoundRect(180, 50, 700, 420, cornerRadius, cornerRadius);

                g2d.drawImage(profile, 40, 10, 100, 100, null, null);
                g2d.setColor(Color.BLACK);
                g2d.setFont(Nfont);
                g2d.drawString(Main.name, x - 338, 151);
                g2d.setColor(new Color(213, 217, 219));
                if (s1) {
                    g2d.setColor(S1c);
                    g2d.fillRoundRect(31, 226, 120, 50, cornerRadius, cornerRadius);
                }
                if (s2) {
                    g2d.setColor(S2c);
                    g2d.fillRoundRect(31, 285, 120, 50, cornerRadius, cornerRadius);
                }
                if (s3) {
                    g2d.setColor(S3c);
                    g2d.fillRoundRect(31, 345, 120, 50, cornerRadius, cornerRadius);
                }
                g2d.setColor(Color.BLACK);
                g2d.drawString("Main", 65, 260);
                g2d.drawString("Modules", 45, 320);
                g2d.drawString("Options", 48, 380);
                g2d.setColor(Color.RED);
                g2d.fillRect(16, yZhou, 3, 42);
                switch (now) {
                    case 1:
                        g2d.setColor(new Color(237, 242, 246));
                        g2d.fillRoundRect(200, 80, 300, 160, cornerRadius, cornerRadius);
                        g2d.fillRoundRect(525, 80, 285, 160, cornerRadius, cornerRadius);
                        g2d.fillRoundRect(200, 255, 300, 200, cornerRadius, cornerRadius);
                        g2d.setColor(injectC);
                        g2d.fillRoundRect(650, 400, 160, 50, cornerRadius, cornerRadius);
                        g2d.setColor(Color.white);
                        g2d.drawString("Inject",700,435);
                        break;
                    case 2:
                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font("Helvetica", Font.PLAIN, 60));
                        g2d.drawString("懒得画了",200, 150);
                        break;
                    case 3:
                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font("Helvetica", Font.PLAIN, 60));
                        g2d.drawString("懒得画了",200, 150);
                        break;

                }

                g2d.setColor(ButtonExit);
                g2d.fillOval(825, 5, 16, 16);

                g2d.setColor(ButtonHind);
                g2d.fillOval(800, 5, 16, 16);
            }
        };
        return jpanel;
    }

    private void setPanel(JPanel jPanel, JFrame jFrame) {
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(255, 255, 255));
        jPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                Rectangle s1n = new Rectangle(31,226,120,50);
                Rectangle s2n = new Rectangle(31,285,120,50);
                Rectangle s3n = new Rectangle(31,345,120,50);
                Point point = e.getPoint();

                if (s1n.contains(point)){
                    s1 = true;
                    jPanel.repaint();
                }else {
                    s1 = false;
                    jPanel.repaint();
                }
                if (s2n.contains(point)){
                    s2 = true;
                    jPanel.repaint();
                }else {
                    s2 = false;
                    jPanel.repaint();
                }
                if (s3n.contains(point)){
                    s3 = true;
                    jPanel.repaint();
                }else {
                    s3 = false;
                    jPanel.repaint();
                }

            }
        });

        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle inject = new Rectangle(650, 400, 160, 50);
                Rectangle s1n = new Rectangle(31,226,120,50);
                Rectangle s2n = new Rectangle(31,285,120,50);
                Rectangle s3n = new Rectangle(31,345,120,50);

                Rectangle s1 = new Rectangle(100, 140, 280, 280);
                Rectangle s2 = new Rectangle(460, 140, 280, 280);

                Rectangle boundsexit = new Rectangle(825, 5, 16, 16);
                Rectangle boundshid = new Rectangle(800, 5, 16, 16);
                Point point = e.getPoint();
                if (now ==1){
if (inject.contains(point)){
    injectC = clickRED;
    jPanel.repaint();
}
                }
                if (boundsexit.contains(point)) {
                    ButtonExit = new Color(166, 54, 54);
                    jPanel.repaint();
                }

                if (boundshid.contains(point)) {
                    ButtonHind = new Color(131, 131, 131);
                    jPanel.repaint();
                }
                if (s1n.contains(point)){
                    S1c = clicked;
                    jPanel.repaint();

                }  if (s2n.contains(point)){
                    S2c = clicked;
                    jPanel.repaint();
                }
                if (s3n.contains(point)){
                    S3c = clicked;
                    jPanel.repaint();
                }


            }
        });
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Rectangle inject = new Rectangle(650, 400, 160, 50);
                Rectangle s1n = new Rectangle(31,226,120,50);
                Rectangle s2n = new Rectangle(31,285,120,50);
                Rectangle s3n = new Rectangle(31,345,120,50);

                Rectangle boundsexit = new Rectangle(825, 5, 16, 16);
                Rectangle boundshid = new Rectangle(800, 5, 16, 16);
                Point point = e.getPoint();
                if (now ==1){
                    if (inject.contains(point)){
                        injectC = normolRED;
                        jPanel.repaint();
                        try {
                            Main.go2Inject();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (boundsexit.contains(point)) {
                    ButtonExit = new Color(253, 83, 83);
                    jPanel.repaint();
                    loginPanel.GetDown(jPanel, jFrame, true, true, 0);
                }
                if (boundshid.contains(point)) {
                    ButtonHind = new Color(166, 166, 166);
                    jPanel.repaint();
                    loginPanel.GetDown(jPanel, jFrame, false, false, 0);
                }
                if (s1n.contains(point)){
               S1c = normol;
                    now=1;
                    jPanel.repaint();
                    Anima(1,jPanel);
                }  if (s2n.contains(point)){
                    S2c = normol;
                    now=2;
                    jPanel.repaint();
                    Anima(2,jPanel);
                }
                if (s3n.contains(point)){
                    S3c = normol;
                    now=3;
                    jPanel.repaint();
                    Anima(3,jPanel);
                }
            }
        });


    }
    public void Anima(int number,JPanel jPanel) {
        int Done = getNumber(number);
        int temp = yZhou;
        int how = Done - temp;
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                 if (how >0){
                                                                        yZhou++;
                                                           jPanel.repaint();
                                 }
                if (how <0){
                    yZhou--;
                    jPanel.repaint();
                }
                if (how ==0){
                    ((Timer) e.getSource()).stop();
                }
                                 if (yZhou == Done){
                                     ((Timer) e.getSource()).stop();
                                     jPanel.repaint();
                                 }
            }
        });
        timer.start(); // 启动计时器
    }
    private int getNumber(int in){
        int done = 0;
        switch (in){
            case 1:
                done = 230;
                break;
            case 2:
                done = 290;
                break;
            case 3:
                done = 350;
                break;
        }
        return done;
    }
}
