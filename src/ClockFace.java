import java.awt.*;
import javax.swing.JFrame;

public class ClockFace extends Canvas {
    public static void main(String[] args) {
        JFrame win = new JFrame("ClockFace");
        win.setSize(800, 600);
        win.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ClockFace canvas = new ClockFace();
        win.add(canvas);
        win.setVisible(true);
    }

    public void paint(Graphics g) {
        // lines
        g.setColor(Color.gray);
        g.drawLine(400, 300, 400, 110);
        g.setColor(Color.black);
        g.drawLine(400, 300, 500, 250);

        g.setColor(Color.black);
        g.drawOval(200, 100, 400, 400);

        g.setColor(Color.gray);
        g.fillOval(390, 290, 20, 20);

        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans", Font.BOLD, 30));
        g.drawString("12", 390, 135);
    }

}
