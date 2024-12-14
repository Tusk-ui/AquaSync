package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class SETTINGS extends JPanel {

    private int arcWidth = 25;  // Default rounded arc width
    private int arcHeight = 25; // Default rounded arc height

    public SETTINGS() {
        setOpaque(false); // Make the panel non-opaque for transparency
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
        repaint();
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define 3-color gradient
        float[] fractions = {0f, 0.5f, 1f};
        Color[] colors = {
            new Color(255, 204, 112), // #1FA0FF
            new Color(200, 80, 192), // #12DAFB
            new Color(65, 88, 208) // #A7FDCC
        };
        LinearGradientPaint gradient = new LinearGradientPaint(
            0, 0, getWidth(), getHeight(), fractions, colors
        );

        g2.setPaint(gradient);

        // Create and fill the rounded rectangle
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        g2.fill(roundRect);

        g2.dispose();
        super.paintComponent(grphcs); // Ensure child components are painted
    }
}
