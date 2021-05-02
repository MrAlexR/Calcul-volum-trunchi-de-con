import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Interfata extends JFrame
{
	private static final long serialVersionUID = 1L;
	public JPanel p_fundal, p_r1, p_r2, p_h;
	public Grafic g;
	public Subsol l;
	public JLabel l_r1, l_r2, l_h, l_result;
	public JTextField tf_r1, tf_r2, tf_h;
	public JButton s, r;
	public float rezultat = 0;
	public boolean b_r1 = false, b_r2 = false, b_h = false;
	
	public void warn(String row, boolean value)
	{
		switch(row)
		{
		case "r1":
			l_r1.setForeground(value == true ? Color.GREEN : Color.red);
			b_r1 = value == true ? true : false;
			break;
		case "r2":
			l_r2.setForeground(value == true ? Color.GREEN : Color.red);
			b_r2 = value == true ? true : false;
			break;
		case "h":
			l_h.setForeground(value == true ? Color.GREEN : Color.red);
			b_h = value == true ? true : false;
			break;
		}
		
		g.modify(b_r1, b_r2, b_h);
		
		if(b_r1 && b_r2 && b_h) 
			s.setEnabled(true);
		else 
			s.setEnabled(false);
	}
	
	public Interfata()
	{
		//setari fereastra-----------------------------------------
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//setari panouri-------------------------------------------
		p_fundal = new JPanel();
		p_fundal.setLayout(null);
		p_fundal.setBackground(Color.decode("#303030"));
		
		p_r1 = new JPanel();
		p_r1.setLayout(null);
		p_r1.setBackground(Color.decode("#212121"));
		p_r1.setBounds(50, 50, 200, 80);
		
		p_r2 = new JPanel();
		p_r2.setLayout(null);
		p_r2.setBackground(Color.decode("#212121"));
		p_r2.setBounds(50, 140, 200, 80);
		
		p_h = new JPanel();
		p_h.setLayout(null);
		p_h.setBackground(Color.decode("#212121"));
		p_h.setBounds(50, 230, 200, 80);
		
		g = new Grafic();
		l = new Subsol();
		
		//setare elemente text------------------------------------
		l_result = new JLabel("Rezultatul calcului este: " + String.valueOf(rezultat) + " m^3");
		l_result.setFont(new Font("Verdena", 0, 15));
		l_result.setForeground(Color.GREEN);
		l_result.setBounds(100, 10, 320, 20);
		p_fundal.add(l_result);
		
		l_r1 = new JLabel("Raza cercului din baza:");
		l_r1.setFont(new Font("Verdena", 0, 15));
		l_r1.setForeground(Color.red);
		l_r1.setBounds(10, 10, 180, 20);
		p_r1.add(l_r1);
		
		l_r2 = new JLabel("Raza cercului din varf:");
		l_r2.setFont(new Font("Verdena", 0, 15));
		l_r2.setForeground(Color.red);
		l_r2.setBounds(10, 10, 180, 20);
		p_r2.add(l_r2);
		
		l_h = new JLabel("Inaltimea trunchiului");
		l_h.setFont(new Font("Verdena", 0, 15));
		l_h.setForeground(Color.red);
		l_h.setBounds(10, 10, 180, 20);
		p_h.add(l_h);
		
		//setare elemente input-------------------------------------
		tf_r1 = new JTextField();
		tf_r1.setFont(new Font("Verdena", 0, 15));
		tf_r1.setForeground(Color.LIGHT_GRAY);
		tf_r1.setBackground(Color.DARK_GRAY);
		tf_r1.setBounds(60, 40, 80, 30);
		tf_r1.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  warn("r1", ErrorCheck.checkValue(tf_r1.getText()));
			  }
			  public void removeUpdate(DocumentEvent e) {
				  warn("r1", ErrorCheck.checkValue(tf_r1.getText()));
			  }
			  public void insertUpdate(DocumentEvent e) {
				  warn("r1", ErrorCheck.checkValue(tf_r1.getText()));
			  }
		});
		p_r1.add(tf_r1);
		
		tf_r2 = new JTextField();
		tf_r2.setFont(new Font("Verdena", 0, 15));
		tf_r2.setForeground(Color.LIGHT_GRAY);
		tf_r2.setBackground(Color.DARK_GRAY);
		tf_r2.setBounds(60, 40, 80, 30);
		tf_r2.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  warn("r2", ErrorCheck.checkValue(tf_r2.getText()));
			  }
			  public void removeUpdate(DocumentEvent e) {
				  warn("r2", ErrorCheck.checkValue(tf_r2.getText()));
			  }
			  public void insertUpdate(DocumentEvent e) {
				  warn("r2", ErrorCheck.checkValue(tf_r2.getText()));
			  }
		});
		p_r2.add(tf_r2);
		
		tf_h = new JTextField();
		tf_h.setFont(new Font("Verdena", 0, 15));
		tf_h.setForeground(Color.LIGHT_GRAY);
		tf_h.setBackground(Color.DARK_GRAY);
		tf_h.setBounds(60, 40, 80, 30);
		tf_h.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  warn("h", ErrorCheck.checkValue(tf_h.getText()));
			  }
			  public void removeUpdate(DocumentEvent e) {
				  warn("h", ErrorCheck.checkValue(tf_h.getText()));
			  }
			  public void insertUpdate(DocumentEvent e) {
				  warn("h", ErrorCheck.checkValue(tf_h.getText()));
			  }
		});
		p_h.add(tf_h);
		
		//elemente secundare----------------------------------------------------
		s = new JButton("Calculeaza");
		s.setBackground(Color.decode("#212121"));
		s.setForeground(Color.GREEN);
		s.setBounds(300, 340, 100, 50);
		s.setEnabled(false);
		s.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             float h = Float.parseFloat(tf_h.getText());
	             float R = Float.parseFloat(tf_r1.getText());
	             float r = Float.parseFloat(tf_r2.getText());
	             rezultat = (float) (3.14159 * h * (r * r + R * R + r * R) / 3);
	             l_result.setText("Rezultatul calcului este: " + String.valueOf(rezultat) + " m^3");
	         }
	    });
		
		r = new JButton("Reseteaza");
		r.setBackground(Color.decode("#212121"));
		r.setForeground(Color.RED);
		r.setBounds(410, 340, 100, 50);
		r.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             tf_r1.setText("");
	             tf_r2.setText("");
	             tf_h.setText("");
	         }
	    });
		
		//adaugare panouri----------------------------------------------
		p_fundal.add(p_r1);
		p_fundal.add(p_r2);
		p_fundal.add(p_h);
		p_fundal.add(g);
		p_fundal.add(l);
		p_fundal.add(s);
		p_fundal.add(r);
		this.add(p_fundal);
	}
}