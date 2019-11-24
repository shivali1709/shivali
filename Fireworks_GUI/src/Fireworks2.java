/*
 * Kashish Dewnani
 * Net ID- kdewnani
 * Assignment- Project 3
 * LAB TR 11:05-12:20
 * I collaborated with Shivali Singh (ssingh53)
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//This is the GUI
@SuppressWarnings("serial")
public class Fireworks2 extends JFrame implements ActionListener, ChangeListener {
	JSlider angle, speed, timelapse;
	JButton launch, plus, cross;
	@SuppressWarnings("rawtypes")
	JComboBox colorb, shapeb, typeb;
	JLabel anglelabel, speedlabel, timelabel, colorl, shapel, typel;
	static Color color = Color.WHITE;
	String color2, shape2;
	static double anglenum, speednum, timenum;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Fireworks2() {
		setLayout(new FlowLayout()); 
		setTitle("Fireworks");

		launch = new JButton("Launch!!");
		launch.addActionListener(this);
		add(launch);

		anglelabel = new JLabel("Angle: (Not Selected)");
		add(anglelabel);

		angle = new JSlider(JSlider.HORIZONTAL, 45, 65, 45);
		angle.setMajorTickSpacing(5);
		angle.setMinorTickSpacing(1);
		angle.setPaintTicks(true);
		angle.addChangeListener(this);
		add(angle);

		speedlabel = new JLabel("Speed: (Not Selected) ");
		add(speedlabel);

		speed = new JSlider(JSlider.HORIZONTAL, 70, 120, 70);
		speed.setMajorTickSpacing(5);
		speed.setMinorTickSpacing(1);
		speed.setPaintTicks(true);
		speed.addChangeListener(this);
		add(speed);


		timelabel = new JLabel("Fuse Time(s): (Not Selected) ");
		add(timelabel);

		timelapse = new JSlider (JSlider.HORIZONTAL,1, 3 ,1);
		timelapse.setMajorTickSpacing(1);
		timelapse.setPaintTicks(true);
		timelapse.addChangeListener(this);
		add(timelapse);

		colorl = new JLabel("Color");
		add(colorl);

		String[] colors = {"Null","White","Red", "Blue", "Green", "Cyan", "Yellow"};
		colorb = new JComboBox(colors);
		colorb.addActionListener(this);
		add(colorb);

		shapel = new JLabel("Shape");
		add(shapel);

		String[] types = {"Null","Lines", "Circles","Star", "Diamonds", "Squares","Flower", "Sparkler"};
		shapeb = new JComboBox(types);
		shapeb.addActionListener(this);
		add(shapeb);

		typel = new JLabel("Type");
		add(typel);

		String[] stringnumberf = {"Null","Single","Colliding", "Multiple Dispersion", "Multiple Convergence"};
		typeb = new JComboBox(stringnumberf);
		typeb.addActionListener(this);
		add(typeb);

	}
	public static void main(String[]args) {
		Fireworks2 f = new Fireworks2();
		f.setSize(1600,100);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String colorchoice = (String) colorb.getSelectedItem();
		if (source == launch) {
			System.out.println("You have launched the Firework!");
			Frame f = new Frame();
			f.setVisible(true);
		}else if(source == colorb) {
			switch(colorchoice) {
			case "White":
				color = Color.WHITE;
				color2 = "White";
				break;
			case "Red":
				color = Color.RED;
				color2 = "Red";
				break;
			case "Blue":
				color = Color.BLUE;
				color2 = "Blue";
				break;
			case "Green":
				color = Color.GREEN;
				color2 = "Green";
				break;
			case "Cyan":
				color = Color.CYAN;
				color2 = "Cyan";
				break;
			case "Yellow":
				color = Color.YELLOW;
				color2 = "Yellow";
				break;
			}
			System.out.println("The color has been changed to: "+ color2);
		}else if(source == shapeb) {
			shape2 = (String) shapeb.getSelectedItem();
			System.out.println("The type has been changed to: "+shape2);
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		if(source == angle ) {
			anglelabel.setText("Angle: "+ String.valueOf(angle.getValue()));
			System.out.println("The angle has been changed.");
			anglenum = angle.getValue();
			anglenum = Math.toRadians(anglenum);
		}else if(source == speed) {
			speedlabel.setText("Speed: "+ String.valueOf(speed.getValue()));
			System.out.println("The speed has been changed.");
			speednum = speed.getValue();
		}else if (source == timelapse) {
			timelabel.setText("Fuse Time(s): " + String.valueOf(timelapse.getValue()));
			System.out.println("The fuse time has been changed.");
			timenum = timelapse.getValue();
		}

	}

	public class Frame extends JFrame {
		public Frame() {
			setTitle("Fireworks Launch");
			setSize(750, 750);
			Canvas c = new Canvas();
			c.setVisible(true);
			add(c);
		}
	}
	public class Canvas extends JComponent{
		String type2launch = (String) typeb.getSelectedItem();
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(color.BLACK);
			Fireworks x= new Fireworks();
			x.setHeight(getHeight());
			x.setWidth(getWidth());
			g.fillRect(0,0,getWidth(), getHeight());
			g.setColor(color);
			if (type2launch == "Single") {
				Fireworks.Projectile(g);
				Fireworks.Endpoint();
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
			}else if (type2launch == "Colliding" ) {
				Fireworks.DoubleProjectile(g);
				Fireworks.DoubleEndpoint();
				Fireworks.Collision(g);
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
				Fireworks.DoubleEndpoint2();
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
			}else if (type2launch == "Multiple Convergence") {
				Fireworks.Endpoint4();
				Fireworks.Multipleprojectiles(g);
				Fireworks.Endpoint3();
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
			}else if (type2launch == "Multiple Dispersion") {
				Fireworks.Endpoint4();
				Fireworks.Multipleprojectiles2(g);
				Fireworks.Endpoint5();
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
				Fireworks.Endpoint6();
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
				Fireworks.Endpoint7();
				switch (shape2) {
				case"Circles":
					Fireworks.Circles(g);
					break;
				case"Squares":
					Fireworks.Squares(g);
					break;
				case"Lines":
					Fireworks.Lines(g);
					break;
				case"Sparkler":
					Fireworks.Sparkler(g);
					break;
				case"Diamonds":
					Fireworks.Diamonds(g);
					break;
				case"Flower":
					Fireworks.Flower(g);
					break;
				case"Star":
					Fireworks.Star(g);
					break;
				case"Null":
					break;
				}
			}
		}
	}
}