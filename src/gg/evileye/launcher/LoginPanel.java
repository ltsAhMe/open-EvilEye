package gg.evileye.launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Security;

import gg.evileye.launcher.Login;
public class LoginPanel {
    boolean gogogo = false;
    private static int alpha = 0;
    private int mouseX, mouseY;
    private static Color ButtonClicked =  new Color(172, 4, 40);
    private static Color ButtonExit =  new Color(253, 83, 83);
    private static Color ButtonHind =  new Color(165, 165, 165);

   private static Color S1 = new Color(217, 218, 225);
    private static Color S2 = new Color(217, 218, 225);

    public  void CreateChoosePanel() {
        JFrame jFrame = new JFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(850, 500);
        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(255, 255, 255));
        JPanel jPanel = definePanel2();
        jFrame.add(jPanel);
        GetUP(jPanel,jFrame);
          setPanel2(jPanel,jFrame);
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
    public void CreateLogin() {
        JFrame jFrame = new JFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(850, 500);
        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(255, 255, 255));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel jPanel = definePanel();
        setPanel(jPanel,jFrame);
        jFrame.add(jPanel);
        GetUP(jPanel,jFrame);

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
                int width = getWidth();
                int height = getHeight();
                int arcSize = 20; // 圆角的大小
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 绘制红色边框
                g2d.setColor(new Color(172, 4, 40));
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRoundRect(550, 190, 280, 50, arcSize, arcSize);

                g2d.setColor(new Color(172, 4, 40));
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRoundRect(550, 260, 280, 50, arcSize, arcSize);

                g2d.setColor(ButtonClicked);
                g2d.fillRoundRect(550, 350, 280, 50, arcSize, arcSize);

                g2d.setColor(ButtonExit);
                g2d.fillOval(825, 5, 16, 16);

                g2d.setColor(ButtonHind);
                g2d.fillOval(800, 5, 16, 16);
            }
        };
        return jpanel;
    }
    public static JPanel definePanel2() {
        Image java = Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/java.png"));
        Image profile = Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/profile.png"));
        JPanel jpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                int cornerRadius = 20; //
                g2d.setColor(new Color(237, 242, 246));
                g2d.fillRect(0,0,1000,1000);
                g2d.setColor(Color.white);
                g2d.fillRoundRect(50, 100, 740,350, cornerRadius, cornerRadius);

                g2d.setColor(S1);
                g2d.fillRoundRect(100, 140, 280,280, cornerRadius, cornerRadius);
                g2d.setColor(S2);
                g2d.fillRoundRect(460, 140, 280,280, cornerRadius, cornerRadius);

                g2d.drawImage(java,80,120,300,300,null,null);
                g2d.drawImage(profile,500,184,200,200,null,null);
                g2d.setColor(ButtonExit);
                g2d.fillOval(825, 5, 16, 16);
                g2d.setColor(ButtonHind);
                g2d.fillOval(800, 5, 16, 16);


            }
        };
        return jpanel;
    }
    private void setPanel(JPanel jPanel,JFrame jFrame) {
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(255, 255, 255));
        ImageIcon icon = new ImageIcon(getClass().getResource("/banner.jpg"));


        JLabel banner = new JLabel(icon);
        JLabel EvilEye = new JLabel("ElectronicEye");
        JLabel usernameshow = new JLabel("username");
        JLabel passwordshow = new JLabel("password");
        JTextField username = new JTextField();
        JPasswordField password = new  JPasswordField();
        JLabel Loginshow = new JLabel("Login");

               username.setBounds(560, 192, 260, 46);
               password.setBounds(560, 262, 260, 46);
        username.setBorder(BorderFactory.createEmptyBorder());
         password.setBorder(BorderFactory.createEmptyBorder());
        username.setFont(new Font("Helvetica", Font.PLAIN, 28));
        password.setFont(new Font("Helvetica", Font.PLAIN, 28));
        username.setOpaque(false);
        password.setOpaque(false);

        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle bounds = username.getBounds();
                Rectangle bounds2 = password.getBounds();
                Rectangle bounds3 = new Rectangle(550, 350, 280, 50);
                Rectangle boundsexit = new Rectangle(825, 5, 16, 16);
                Rectangle boundshid = new Rectangle(800, 5, 16, 16);
                Point point = e.getPoint();
                if (!bounds.contains(point)) {
                    username.setFocusable(false);
                }
                if (!bounds2.contains(point)) {
                    password.setFocusable(false);
                }
                if (bounds3.contains(point)) {
                    ButtonClicked = new Color(133, 4, 32);
                    jPanel.repaint();

                }
                if (boundsexit.contains(point)) {
                    ButtonExit = new Color(166, 54, 54);
                    jPanel.repaint();
                }

                if (boundshid.contains(point)) {
                    ButtonHind = new Color(131, 131, 131);
                    jPanel.repaint();
                }

            }
        });
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Rectangle boundsexit = new Rectangle(825, 5, 16, 16);
                Rectangle boundshid = new Rectangle(800, 5, 16, 16);
                Rectangle bounds3 = new Rectangle(550, 350, 280, 50);
                Point point = e.getPoint();
                if (bounds3.contains(point)) {
                    ButtonClicked = new Color(172, 4, 40);
                    jPanel.repaint();
                    if (username.getText() == null || username.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please input username");
                        ButtonClicked = new Color(172, 4, 40);
                        jPanel.repaint();
                    }else {
                        if (password.getText() == null || password.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Please input password");
                            ButtonClicked = new Color(172, 4, 40);
                            jPanel.repaint();
                        }else {
                            if(!GoToVerift(username.getText(),password.getText())){
                                JOptionPane.showMessageDialog(null, "Error");
                            }else {
                                gogogo=true;
                                Main.name =username.getText();
                                GetDown(jPanel,jFrame,true,false,0);

                            }
                        }
                    }
                }
                if (boundsexit.contains(point)) {
                    ButtonExit = new Color(253, 83, 83);
                    jPanel.repaint();
                    GetDown(jPanel,jFrame,true,true,0);
                }
                if (boundshid.contains(point)) {
                    ButtonHind = new Color(166, 166, 166);
                    jPanel.repaint();
                    GetDown(jPanel,jFrame,false,false,0);

                }
            }
        });
        username.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                username.setFocusable(true);
                username.requestFocus(); // 获得焦点
            }
        });
        password.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                password.setFocusable(true);
                password.requestFocus(); // 获得焦点
            }
        });

        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                username.setOpaque(true); // 获得焦点时设置为不透明
                username.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText() == null || username.getText().equals(""))
                    username.setOpaque(false); // 失去焦炯后设置为透明
                username.repaint();
            }
        });
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setOpaque(true); // 获得焦点时设置为不透明
                password.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getText() == null || password.getText().equals(""))
                    password.setOpaque(false); // 失去焦炯后设置为透明
                password.repaint();
            }
        });

        Loginshow.setBounds(650, 347, 280, 58);
        Loginshow.setFont(new Font("Helvetica", Font.PLAIN, 35));
        Loginshow.setForeground(new Color(253, 253, 253));

        usernameshow.setFont(new Font("Helvetica", Font.PLAIN, 28));
        passwordshow.setFont(new Font("Helvetica", Font.PLAIN, 28));

        usernameshow.setBounds(560, 190, 280, 50);
        passwordshow.setBounds(560, 260, 280, 50);

        usernameshow.setForeground(new Color(210, 210, 211));
        passwordshow.setForeground(new Color(210, 210, 211));
        EvilEye.setFont(new Font("Helvetica", Font.PLAIN, 40));
        EvilEye.setBounds(550, 100, 300, 65);
        EvilEye.setForeground(Color.BLACK);
        banner.setSize(icon.getIconWidth(), icon.getIconHeight());
        banner.setLocation(0, 0);

        jPanel.add(username);
        jPanel.add(password);
        jPanel.add(Loginshow);
        jPanel.add(usernameshow);
        jPanel.add(passwordshow);
        jPanel.add(EvilEye);
        jPanel.add(banner);

    }
    private void setPanel2(JPanel jPanel2,JFrame jFrame) {
        jPanel2.setLayout(null);
        jPanel2.setBackground(new Color(255, 255, 255));
        JLabel EvilEye = new JLabel("Choose a graphical version");

        jPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle s1 = new Rectangle(100, 140, 280,280);
                Rectangle s2 = new Rectangle(460, 140, 280,280);

                Rectangle boundsexit = new Rectangle(825, 5, 16, 16);
                Rectangle boundshid = new Rectangle(800, 5, 16, 16);
                Point point = e.getPoint();
                if (boundsexit.contains(point)) {
                    ButtonExit = new Color(166, 54, 54);
                    jPanel2.repaint();
                }

                if (boundshid.contains(point)) {
                    ButtonHind = new Color(131, 131, 131);
                    jPanel2.repaint();
                }
                if (s1.contains(point)) {
                    S1 = new Color(191, 197, 208);
                    jPanel2.repaint();
                }
                if (s2.contains(point)) {
                    S2 = new Color(191, 197, 208);
                    jPanel2.repaint();
                }
            }
        });
        jPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Rectangle s1 = new Rectangle(100, 140, 280,280);
                Rectangle s2 = new Rectangle(460, 140, 280,280);


                Rectangle boundsexit = new Rectangle(825, 5, 16, 16);
                Rectangle boundshid = new Rectangle(800, 5, 16, 16);
                Point point = e.getPoint();
                if (boundsexit.contains(point)) {
                    ButtonExit = new Color(253, 83, 83);
                    jPanel2.repaint();
                    GetDown(jPanel2,jFrame,true,true,0);
                }
                if (boundshid.contains(point)) {
                    ButtonHind = new Color(166, 166, 166);
                    jPanel2.repaint();
                    GetDown(jPanel2,jFrame,false,false,0);

                }
                if (s1.contains(point)) {
                  S1 = new Color(217, 218, 225);
                    jPanel2.repaint();
                               GetDown(jPanel2,jFrame,true,false,1);
                }
                if (s2.contains(point)) {
                    S2 = new Color(217, 218, 225);
                    jPanel2.repaint();
                    GetDown(jPanel2,jFrame,true,false,2);
                }
            }
        });



        EvilEye.setFont(new Font("Helvetica", Font.PLAIN, 40));
        EvilEye.setBounds(20, 10, 800, 65);
        EvilEye.setForeground(new Color(0, 0, 0, 240));

        jPanel2.add(EvilEye);

    }
    public void GetUP(JPanel jpanel, JFrame jFrame) {
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 2; // 每次减小透明度0.1
                if (alpha >= 255) {
                    ((Timer) e.getSource()).stop();
                    alpha =255;
                    jFrame.setOpacity(alpha / 255f); // 设置窗口透明度
                    jpanel.revalidate(); // 重新计算并应用布局
                }else {
                    jFrame.setOpacity(alpha / 255f); // 设置窗口透明度
                    jpanel.revalidate(); // 重新计算并应用布局
                }

            }
        });
        timer.start(); // 启动计时器
    }
    public void GetDown(JPanel jpanel, JFrame jFrame,Boolean isClose,Boolean isSystemClose,int number) {
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 2; // 每次减小透明度0.1
                if (alpha <= 0) {
                    if (gogogo){
                        CreateChoosePanel();
                        gogogo = false;
                    }
                    if (number != 0){
                        switch (number){
                            case 1:
                                Main.nothing =1;
                                break;

                            case 2:
                                Main.nothing =2;
                        }
                    }
                    if(isClose) {
                        jFrame.dispose();
                        ((Timer) e.getSource()).stop();
                        if (isSystemClose) {
                            System.exit(0);
                        }
                    }else {
                        ((Timer) e.getSource()).stop();
                        alpha = 255;
                        jFrame.setOpacity(alpha / 255f); // 设置窗口透明度
                        jpanel.revalidate();
                        jFrame.setState(JFrame.ICONIFIED);
                    }
                }else{

                    jFrame.setOpacity(alpha / 255f); // 设置窗口透明度
                    jpanel.revalidate(); // 重新计算并应用布局
                }
            }
        });

        timer.start(); // 启动计时器

    }

   public boolean GoToVerift(String username,String password) {
       Login login = new Login();
       return login.verifyAccount(username,password);
   }
}