package com.racha.swing;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class MyButton extends JButton {

    private Color normalBackgroundColor = new Color(7, 164, 121); // Default background color
    private Color hoverBackgroundColor = new Color(5, 140, 105);  // Hover background color
    private Color pressedBackgroundColor = new Color(3, 115, 90); // Pressed background color
    private Color textColor = Color.WHITE;                        // Default text color
    private int borderRadius = 40;                                // Border radius for rounded corners

    /**
     * Default constructor for MyButton.
     */
    public MyButton() {
        super();
        init();
    }

    /**
     * Constructor with text.
     *
     * @param text The text to display on the button.
     */
    public MyButton(String text) {
        super(text);
        init();
    }

    private void init() {
        setFont(new Font("SansSerif", Font.BOLD, 14));
        setForeground(textColor);
        setBackground(normalBackgroundColor);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false); // Disable default painting
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * Sets the border radius for the button.
     *
     * @param borderRadius The radius for the rounded corners.
     */
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint();
    }

    /**
     * Sets the button's normal background color.
     *
     * @param color The normal background color.
     */
    public void setNormalBackgroundColor(Color color) {
        this.normalBackgroundColor = color;
        repaint();
    }

    /**
     * Sets the button's hover background color.
     *
     * @param color The hover background color.
     */
    public void setHoverBackgroundColor(Color color) {
        this.hoverBackgroundColor = color;
    }

    /**
     * Sets the button's pressed background color.
     *
     * @param color The pressed background color.
     */
    public void setPressedBackgroundColor(Color color) {
        this.pressedBackgroundColor = color;
    }

    /**
     * Sets the button's text color.
     *
     * @param color The text color.
     */
    public void setTextColor(Color color) {
        this.textColor = color;
        setForeground(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Determine the background color based on the button's state
        if (getModel().isPressed()) {
            g2.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g2.setColor(hoverBackgroundColor);
        } else {
            g2.setColor(normalBackgroundColor);
        }

        // Draw rounded rectangle as the button background
        Shape roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        g2.fill(roundedRectangle);

        // Paint the button's text and other components
        super.paintComponent(g2);

        g2.dispose();
    }
}
