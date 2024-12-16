package com.racha.swing;

import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * Custom password field with prefix icon, hint, and stylized appearance.
 */
public class MyPasswordField extends JPasswordField {
    private JLabel prefixLabel; // Label for the prefix icon
    private String hint = ""; // Hint text to display
    private Color bgColor = new Color(240, 255, 240); // Whitish-green background color

    /**
     * Default constructor for MyPasswordField.
     */
    public MyPasswordField() {
        super();
        init();
    }

    /**
     * Constructor with initial text.
     *
     * @param text The initial text.
     */
    public MyPasswordField(String text) {
        super(text);
        init();
    }

    /**
     * Constructor with columns.
     *
     * @param columns The number of columns for the password field.
     */
    public MyPasswordField(int columns) {
        super(columns);
        init();
    }

    /**
     * Constructor with text and columns.
     *
     * @param text    The initial text.
     * @param columns The number of columns.
     */
    public MyPasswordField(String text, int columns) {
        super(text, columns);
        init();
    }

    private void init() {
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setForeground(Color.GRAY);
        setBackground(bgColor);
        setBorder(new EmptyBorder(5, 30, 5, 5)); // Padding inside the password field
        setEchoChar('●'); // Default echo character for hidden password
    }

    /**
     * Sets the prefix icon for the password field.
     *
     * @param icon The prefix icon.
     */
    public void setPrefixIcon(Icon icon) {
        if (prefixLabel == null) {
            prefixLabel = new JLabel(icon);
            prefixLabel.setBounds(5, 5, 20, 20);
            add(prefixLabel);
        } else {
            prefixLabel.setIcon(icon);
        }
    }

    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded rectangle background
        g2.setColor(bgColor);
        Shape roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fill(roundedRectangle);

        // Call the original paintComponent to draw the text and hint
        super.paintComponent(g);

        // Draw the hint text if field is empty and unfocused
        if (hint != null && getPassword().length == 0 && !hasFocus()) {
            g2.setColor(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.drawString(hint, getInsets().left + 5, g.getFontMetrics().getHeight() + getInsets().top - 5);
        }

        g2.dispose();
    }

    @Override
    public void setText(String text) {
        super.setText(text != null ? text.trim() : "");
    }
}
