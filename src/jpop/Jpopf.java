package jpop;

import Signup.Sign;
import java.awt.geom.RoundRectangle2D;


public class Jpopf extends javax.swing.JFrame {


    public Jpopf() {
        initComponents();
        int arcWidth = 20; // Width of the rounded corners
        int arcHeight = 20; // Height of the rounded corners
        this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), arcWidth, arcHeight));

        // Add a window listener to handle resizing
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TItle = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        aa = new javax.swing.JLabel();
        aaa = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        bb = new javax.swing.JLabel();
        bbb = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        ccc = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        dd = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        ee = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(760, 342));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TItle.setFont(new java.awt.Font("Home Video", 0, 23)); // NOI18N
        TItle.setText("Conserving water is important because:");
        getContentPane().add(TItle, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 35, 510, 45));

        a.setFont(new java.awt.Font("Home Video", 1, 16)); // NOI18N
        a.setText("Limited Supply:");
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 100, 160, -1));

        aa.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        aa.setText(" Freshwater is scarce, and we need to manage it");
        getContentPane().add(aa, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 101, 500, -1));

        aaa.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        aaa.setText("carefully to ensure water is enough for everyone.");
        getContentPane().add(aaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 120, 650, -1));

        b.setFont(new java.awt.Font("Home Video", 1, 16)); // NOI18N
        b.setText("Sustainability:");
        b.setToolTipText("");
        getContentPane().add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 140, 150, -1));

        bb.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        bb.setText(" Overuse can lead to shortages, threatening");
        getContentPane().add(bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 141, 500, -1));

        bbb.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        bbb.setText("future availability of our water.");
        getContentPane().add(bbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 160, 650, -1));

        c.setFont(new java.awt.Font("Home Video", 1, 16)); // NOI18N
        c.setText("Energy Savings:");
        c.setToolTipText("");
        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 180, 150, -1));

        cc.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        cc.setText("Using less water saves energy and reduces costs");
        getContentPane().add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 180, 490, -1));

        ccc.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        ccc.setText("for pumping, treating, and heating.");
        getContentPane().add(ccc, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 200, 650, -1));

        d.setFont(new java.awt.Font("Home Video", 1, 16)); // NOI18N
        d.setText("Environmental Protection:");
        getContentPane().add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 220, 250, -1));

        dd.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        dd.setText(" Wasting water harms ecosystems & wildlife");
        getContentPane().add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 220, 410, -1));

        e.setFont(new java.awt.Font("Home Video", 1, 16)); // NOI18N
        e.setText("Cost Savings:");
        getContentPane().add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 240, 130, -1));

        ee.setFont(new java.awt.Font("Home Video", 0, 15)); // NOI18N
        ee.setText(" Less water use means lower water bills.");
        getContentPane().add(ee, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 240, 520, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/artarrowbottom_13048276.png"))); // NOI18N
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/jpop/left_12663513.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, -1, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpop/Pixilart-Liveon-ezgif.com-resize.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 810, 520));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpop/why consernving water is important (4).png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpop/why consernving water is important (4).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 760, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
            this.dispose();
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jpopf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jpopf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jpopf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jpopf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jpopf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel TItle;
    private javax.swing.JLabel a;
    private javax.swing.JLabel aa;
    private javax.swing.JLabel aaa;
    private javax.swing.JLabel b;
    private javax.swing.JButton back;
    private javax.swing.JLabel bb;
    private javax.swing.JLabel bbb;
    private javax.swing.JLabel c;
    private javax.swing.JLabel cc;
    private javax.swing.JLabel ccc;
    private javax.swing.JLabel d;
    private javax.swing.JLabel dd;
    private javax.swing.JLabel e;
    private javax.swing.JLabel ee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
