/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Graphic.java
 *
 * Created on 24/08/2011, 09:44:41 PM
 */

package plot;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rick
 */
public class Graphic extends javax.swing.JFrame {
    private javax.swing.JPanel jPanel1;


    /** Creates new form graphic */
    public Graphic() {
        super("Plano Cartesiano");
        this.setSize(1024,700);
        this.setLocationRelativeTo(null);
        jPanel1 =  new JPanel(new BorderLayout());
        jPanel1.setOpaque(true);
        JDesktopPane desktop =  new JDesktopPane() {

            Image im  =   ( new ImageIcon("plano.png")).getImage().getScaledInstance(1024,650,Image.SCALE_DEFAULT);

            public void paintComponent(Graphics g) {
                g.drawImage(im,0,0,this);

            }
        };

        jPanel1.add(desktop).setVisible(true);

        jPanel1.setVisible(true);
        getContentPane().add(jPanel1);


    }





}
