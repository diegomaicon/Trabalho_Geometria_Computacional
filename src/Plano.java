import javax.swing.*;
import java.awt.*;

public class Plano extends JPanel {


    public Plano() {
        init();
    }

    public Plano init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        return null;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);

        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());

    }
}