package com.racha.componets;

import com.racha.swing.ButtonOutline;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {

    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel discription;
    private JLabel discription1;
    private ButtonOutline button;
    private boolean isLogin;

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }

    private void init() {
        title = new JLabel("Welcome Back!");
        title.setFont(new Font("sansserif", 1, 30));
        title.setForeground(new Color(245, 245, 245));
        add(title);

        discription = new JLabel("To keep connected with us please");
        discription.setForeground(new Color(245, 245, 245));
        add(discription);
        discription1 = new JLabel("login with your personal info");
        discription1.setForeground(new Color(245, 245, 245));
        add(discription1);

        button = new ButtonOutline("SIGN UP");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                event.actionPerformed(evt);
            }
        });

        add(button, "w 60%");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint grad = new GradientPaint(0, 0, new Color(35, 166, 97), 0, getHeight(), new Color(22, 116, 66));
        g2.setPaint(grad);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }

    public void registerLeft(double v) {
        v = Math.floor(v * 1000) / 1000;
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(discription, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(discription1, "pad 0 -" + v + "% 0 0");

    }

    public void registerRight(double v) {
        v = Math.floor(v * 1000) / 1000;
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(discription, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(discription1, "pad 0 -" + v + "% 0 0");

    }

    public void loginLeft(double v) {
        v = Math.floor(v * 1000) / 1000;
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(discription, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(discription1, "pad 0 " + v + "% 0 " + v + "%");

    }

    public void loginRight(double v) {
        v = Math.floor(v * 1000) / 1000;
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(discription, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(discription1, "pad 0 " + v + "% 0 " + v + "%");

    }

    private void login(boolean login) {
        if (this.isLogin != login) {
            if (login) {
                title.setText("Hello, friend!");
                discription.setText("Enter your personal details");
                discription1.setText("and start your journey with us");
                button.setText("SIGN IN");
            } else {
                title.setText("Welcome Back!");
                discription.setText("To keep connected with us please");
                discription1.setText("login with your personal info");
                button.setText("SIGN UP");
            }
        }
        this.isLogin = login;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
