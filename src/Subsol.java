import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Subsol extends JPanel
{
	private static final long serialVersionUID = 1L;
	public JLabel t1, t2;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.fillPolygon(new int[] {22, 35, 10}, new int[] {10, 30, 30}, 3);
		g2.setColor(Color.GREEN);
		g2.fillPolygon(new int[] {22, 35, 10}, new int[] {35, 55, 55}, 3);
	}
	
	Subsol()
	{
		this.setLayout(null);
		this.setBounds(50, 320, 200, 60);
		this.setBackground(Color.decode("#212121"));
		
		t1 = new JLabel(" Eroare in valori !");
		t1.setFont(new Font("Verdena", 0, 15));
		t1.setForeground(Color.YELLOW);
		t1.setBounds(60, 5, 150, 30);
		
		t2 = new JLabel(" Valori corecte !");
		t2.setFont(new Font("Verdena", 0, 15));
		t2.setForeground(Color.YELLOW);
		t2.setBounds(60, 30, 150, 30);
		
		this.add(t1);
		this.add(t2);
	}
}
