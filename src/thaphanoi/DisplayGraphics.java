package thaphanoi;
import java.awt.*;
import javax.swing.JFrame;

public class DisplayGraphics extends Canvas{
	
	public void paint(Graphics g) {
		g.drawString("hello", 40, 40);
		setBackground(Color.WHITE);
		g.fillRect(130, 30, 100, 80);
		setForeground(Color.RED);
		g.fillOval(130, 130, 50, 60);
		
	}
	public static void main(String[] args) {
		DisplayGraphics m = new DisplayGraphics();
		JFrame f = new JFrame();
		f.add(m);
		f.setSize(400,400);
		f.setVisible(true);

	}

}
