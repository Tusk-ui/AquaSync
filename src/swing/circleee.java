package swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class circleee extends JPanel {

    public circleee() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set gradient color from top to bottom
        g2.setPaint(new GradientPaint(0, 0, new Color(83, 70, 102), getWidth(), getHeight(), new Color(83, 70, 102)));

        // Create the circle shape
        int diameter = Math.min(getWidth(), getHeight());
        Ellipse2D circle = new Ellipse2D.Double(0, 0, diameter, diameter);

        g2.fill(circle); // Fill the circle with the gradient
        g2.dispose(); // Dispose of the graphics context
        super.paintComponent(grphcs); // Paint other components if needed
    }
}
