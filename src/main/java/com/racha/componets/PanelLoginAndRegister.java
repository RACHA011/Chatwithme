package com.racha.componets;

import com.racha.swing.MyButton;
import com.racha.swing.MyPasswordField;
import com.racha.swing.MyTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        //login.setVisible(true);
        //register.setVisible(false);
    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/racha/icon/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 60%");

        MyTextField txtMail = new MyTextField();
        txtMail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/racha/icon/mail.png")));
        txtMail.setHint("Email");
        register.add(txtMail, "w 60%");

        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/racha/icon/pass.png")));
        txtPassword.setHint("Password");
        register.add(txtPassword, "w 60%");

        MyButton cmd = new MyButton();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");

    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]25[]10[]push"));
        JLabel label = new JLabel("Sign in");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);

        MyTextField txtMail = new MyTextField();
        txtMail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/racha/icon/mail.png")));
        txtMail.setHint("Email");
        login.add(txtMail, "w 60%");

        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/racha/icon/pass.png")));
        txtPassword.setHint("Password");
        login.add(txtPassword, "w 60%");

        JButton cmdForgot = new JButton("Forgot your Password?");
        cmdForgot.setFont(new Font("sansserif", 1, 14));
        cmdForgot.setForeground(new Color(100, 100, 100));
        cmdForgot.setContentAreaFilled(false);
        cmdForgot.setBorder(null);
        cmdForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForgot);

        MyButton cmd = new MyButton();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        }else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
