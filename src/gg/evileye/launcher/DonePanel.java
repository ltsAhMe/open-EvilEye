package gg.evileye.launcher;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import mjt.lef.letsgo;
import mapping.MinecraftVersion;

public class DonePanel {

    public static int nothing = 0;
   private static int nowchoose = 0;
    private static int[] nowChoose = new int[3];

   private static Color NMC = new Color(255, 255, 255);
    private static Color ClickColor = new Color(247, 190, 97);
public void CreateDonePanel() {
    nowChoose = new int[]{0, 60, 120};

    JFrame jFrame = new JFrame("ElectronicEye");
    jFrame.setSize(470, 275);
    jFrame.setLocationRelativeTo(null);
    jFrame.setBackground(new Color(45, 48, 56));
    JPanel jPanel = definePanel();
    jPanel.setBackground(new Color(45, 48, 56));
    jPanel.setLayout(null);
    jFrame.setResizable(false);
    setPanel(jPanel);
    jFrame.add(jPanel);

jPanel.setVisible(true);
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
                // 绘制红色边框
                g2d.setColor(new Color(255, 255, 255));
                g2d.drawLine( 0, 40, 500, 40);

                g2d.setColor(ClickColor);
                g.fillRect(nowChoose[nowchoose], 38,80,3);

                if (nowchoose == 0){
                    g2d.setColor(new Color(80, 85, 100));
                    g.fillRect(10, 95,260,105);
                    g2d.setColor(ColorUIResource.white);
                    g2d.drawRect(300,170,100,30);
                }
                if (nowchoose == 1){
                    g2d.setColor(new Color(80, 85, 100));
                    g2d.fil
                    return jpanel;
                }
                private void setPalRect(10, 50,430,160);
                }
            }
        };nel(JPanel jPanel){
    Font normo = new Font("Helvetica", Font.PLAIN, 16);
     JLabel HomeShow = new JLabel("Home");
     JLabel HelpShow = new JLabel("Help");
     JLabel OptionsShow = new JLabel("Options");

     HomeShow.setFont(normo);
     HelpShow.setFont(normo);
     OptionsShow.setFont(normo);

     HomeShow.setBounds(15,7,60,30);
     HelpShow.setBounds(80,7,60,30);
     OptionsShow.setBounds(135,7,60,30);

        HomeShow.setForeground(NMC);
        HelpShow.setForeground(NMC);
        OptionsShow.setForeground(NMC);

        updateColor(HomeShow,HelpShow,OptionsShow);
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle HomeBound = new Rectangle(HomeShow.getBounds());
                Rectangle HelpBound = new Rectangle(HelpShow.getBounds());
                Rectangle OptionBound = new Rectangle(OptionsShow.getBounds());
                Point point = e.getPoint();
                if (HomeBound.contains(point)) {
                    nowchoose = 0;
                    updateColor(HomeShow, HelpShow, OptionsShow);
                    jPanel.removeAll();
                    setPanel1(jPanel);
                    jPanel.add(HomeShow);
                    jPanel.add(HelpShow);
                    jPanel.add(OptionsShow);
                    jPanel.repaint();
                }
                if (HelpBound.contains(point)) {
                    nowchoose = 1;
                    updateColor(HomeShow, HelpShow, OptionsShow);
                    jPanel.removeAll();
                    setPanel2(jPanel);
                    jPanel.add(HomeShow);
                    jPanel.add(HelpShow);
                    jPanel.add(OptionsShow);
                    jPanel.repaint();
                }
                if (OptionBound.contains(point)) {
                    nowchoose = 2;
                    updateColor(HomeShow, HelpShow, OptionsShow);
                    jPanel.removeAll();
                    setPanel3(jPanel);
                    jPanel.add(HomeShow);
                    jPanel.add(HelpShow);
                    jPanel.add(OptionsShow);
                    jPanel.repaint();
                }

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
        });
        setPanel1(jPanel);
     jPanel.add(HomeShow);
     jPanel.add(HelpShow);
     jPanel.add(OptionsShow);
    }
    private void setPanel1(JPanel jPanel){
    JButton inject = new JButton("Inject");
    setButton(inject);
    inject.setBounds(300,170,100,30);
    jPanel.add(inject);
    }
    private void setPanel2(JPanel jPanel){
        Font normo = new Font("Helvetica", Font.PLAIN, 15);
    JLabel HelpShow = new JLabel("Press \"home\" to open click gui");

HelpShow.setFont(normo);

   HelpShow.setBounds(10, 55,260,30);
   HelpShow.setForeground(Color.white);
    jPanel.add(HelpShow);
    }
    private void setPanel3(JPanel jPanel){

    }
    private void setButton(JButton button){
    ActionListener gotoInject = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Main.go2Inject();
                JOptionPane.showMessageDialog( null, "Inject Successfully");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };
    button.addActionListener(gotoInject);
    }
   private void updateColor(JLabel HomeShow,JLabel HelpShow,JLabel OptionsShow){
    switch (nowchoose){
        case 0:
            HomeShow.setForeground(ClickColor);
            HelpShow.setForeground(NMC);
            OptionsShow.setForeground(NMC);
            break;
        case 1:
            HelpShow.setForeground(ClickColor);
            OptionsShow.setForeground(NMC);
            HomeShow.setForeground(NMC);
            break;
        case 2:
            OptionsShow.setForeground(ClickColor);
            HomeShow.setForeground(NMC);
            HelpShow.setForeground(NMC);
            break;
    }
   }
}

