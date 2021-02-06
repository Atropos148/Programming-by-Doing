import java.awt.*;
import javax.swing.JFrame;

public class Graphics1 extends Canvas {
    private static final long serialVersionUID = -840111553580546282L;

    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.drawRect(50, 20, 100, 200); // draw a rectangle
        g.fillOval(160, 20, 100, 200); // draw a filled-in oval
        g.setColor(Color.blue);
        g.fillRect(200, 400, 200, 20); // a filled-in rectangle
        g.drawOval(200, 430, 200, 100);
        g.setColor(Color.red);
        g.fillRect(500, 400, 100, 100);

        g.setColor(Color.black);
        g.drawString("Graphics are pretty neat.", 500, 100);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g.drawString("The first letter of this string is at (" + x + "," + y + ")", x, y);
    }

    public static void main(String[] args) {
        // You can change the title or size here if you want.
        JFrame win = new JFrame("GraphicsDemo1");
        win.setSize(800, 600);
        win.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Graphics1 canvas = new Graphics1();
        win.add(canvas);
        win.setVisible(true);
    }
}