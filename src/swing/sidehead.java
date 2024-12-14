package swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class sidehead extends JPanel {

    private int arcWidth = 0;  // Width of the rounded arc
    private int arcHeight = 0; // Height of the rounded arc

    public sidehead() {
        setOpaque(false); // Ensure transparency for rounded corners
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
        repaint(); // Repaint the panel with updated arc width
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
        repaint(); // Repaint the panel with updated arc height
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set gradient color
        g2.setPaint(new GradientPaint(0, 0, new Color(255, 175, 189), getWidth(), getHeight(), new Color(255, 195, 160)));

        // Create a single rounded rectangle
        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcHeight);

        g2.fill(roundRect); // Fill the rounded rectangle with the gradient
        g2.dispose(); // Dispose of the graphics context
        super.paintComponent(grphcs); // Paint child components if needed
    }
}
