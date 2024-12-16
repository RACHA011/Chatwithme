package com.racha.swing;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class ButtonOutline extends JButton {
    private Color hoverBorderColor = new Color(7, 164, 121); 
    private Color borderColor = new Color(5, 140, 105); 
    private Color pressedBorderColor = new Color(3, 115, 90); 
    private Color textColor = new Color(240, 240, 240); 
    private Color hoverTextColor = Color.WHITE; 
    private Color pressedTextColor = Color.WHITE; 
    private Color backgroundColor = Color.WHITE; 

    public ButtonOutline() {
        super();
        init();
    }

    public ButtonOutline(String text) {
        super(text);
        init();
    }

    private void init() {
        setFont(new Font("SansSerif", Font.BOLD, 14));
        setForeground(textColor);
        setBackground(backgroundColor);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false); // Disable default painting
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Determine colors based on the button state
        if (getModel().isPressed()) {
            g2.setColor(pressedBorderColor);
            setForeground(pressedTextColor);
        } else if (getModel().isRollover()) {
            g2.setColor(hoverBorderColor);
            setForeground(hoverTextColor);
        } else {
            g2.setColor(borderColor);
            setForeground(textColor);
        }

        // Draw the border
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        // Paint the button's text
        super.paintComponent(g2);
        g2.dispose();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    public void setHoverBorderColor(Color color) {
        this.hoverBorderColor = color;
    }

    public void setPressedBorderColor(Color color) {
        this.pressedBorderColor = color;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        setForeground(color);
    }

    public void setHoverTextColor(Color color) {
        this.hoverTextColor = color;
    }

    public void setPressedTextColor(Color color) {
        this.pressedTextColor = color;
    }
}
