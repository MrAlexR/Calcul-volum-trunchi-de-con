import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Grafic extends JPanel
{
	private static final long serialVersionUID = 1L;
	public Color c1 = Color.red;
	public Color c2 = Color.red;
	public Color c3 = Color.red;
	public Color c4 = Color.red;
	Graphics2D g2;

	public void modify(boolean c1, boolean c2, boolean c3)
	{
		this.c1 = (c1 ? Color.GREEN : Color.red);
		this.c2 = (c2 ? Color.GREEN : Color.red);
		this.c3 = (c3 ? Color.GREEN : Color.red);
		this.c4 = (c1 && c2 && c3 ? Color.GREEN : Color.red);
		this.repaint();
		this.revalidate();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		g2.setColor(c1);
		g2.fill(new Ellipse2D.Double(45, 170, 120, 50));
		g2.setColor(Color.decode("#212121"));
		g2.fill(new Ellipse2D.Double(45 + 2, 170 + 2, 120 - 4, 50 - 4));
		
		g2.setColor(c2);
		g2.fill(new Ellipse2D.Double(65, 50, 80, 40));
		g2.setColor(Color.decode("#212121"));
		g2.fill(new Ellipse2D.Double(65 + 2, 50 + 2, 80 - 4, 40 - 4));
		
		g2.setColor(c4);
		g2.setStroke(new BasicStroke(2f));
		g2.drawLine(65, 70, 45, 195);
		g2.drawLine(145, 70, 165, 195);
		
		g2.setColor(c3);
		float[] dashingPattern2 = {10f, 4f};
		g2.setStroke(new BasicStroke(4f, BasicStroke.CAP_BUTT,
		        BasicStroke.JOIN_MITER, 1.0f, dashingPattern2, 0.0f));
		g2.drawLine(105, 70, 105, 195);
	}
	
	public Grafic()
	{
		this.setLayout(null);
		this.setBackground(Color.decode("#212121"));
		this.setBounds(300, 50, 210, 260);
	}
}