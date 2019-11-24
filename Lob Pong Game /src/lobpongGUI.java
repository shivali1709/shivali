import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class lobpongGUI extends JFrame implements ActionListener {
	protected static Color color;
	protected String color2;
	protected JOptionPane Instructions;
	protected JPanel panel;
	protected JButton Play;
	protected JComboBox ballcolor, paddlecolor;
	@SuppressWarnings("rawtypes")
	protected JComboBox ColorType;
	@SuppressWarnings("rawtypes")
	protected JComboBox PaddleColorType;
	protected JLabel Menu, BallColor, PaddleColor;
	protected Color ballColor, colors;
	protected Color paddleColor;

	public static void main(String[]args) {
		//Sets the GUI to be visible
		new lobpongGUI().setVisible(true);

	}
	//Constructor
	public lobpongGUI() {
		//sets layout of the GUI
		setLayout(new BorderLayout());
		setSize(500,400);
		setResizable(false);
		setTitle("Launch");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		Menu = new JLabel("Welcome to Lob Pong!");
		Menu.setBounds(180,0,400,20);
		panel.add(Menu);
		//Instructions
		Instructions = new JOptionPane();
		Instructions.setMessage("Let's Play Lob Pong!\r\n" + 
				"You have five lives to play this game.\r\n" + 
				"The goal is to hit the ball with the paddle before it touches the bottom of your \nscreen. " + 
				"\nYou score a point everytime you hit the ball and lose a life if the ball touches the \nbottom of the screen.\r\n" + 
				"After five lives, you lose the game!\r\n" + 
				"The game increases with difficulty as the levels progress.\r\n" +
				"You will see different colored obstacles that do different things.\r\n" + 
				"Reach level 15 to win!!\r\n" + 
				"Choose the color of your ball and paddle and click Play to begin!");
		Instructions.setBounds(0,20,475,200);
		panel.add(Instructions);	
		
		//JButton that launches game
		Play = new JButton("Play!");
		Play.addActionListener(this);
		Play.setBounds(170,300,120,35);
		panel.add(Play);
		
		//Ball Color JLabel
		BallColor = new JLabel("Ball Color");
		BallColor.setBounds(150,220,100,20);
		panel.add(BallColor);

		//Ball Color choice.
		String[] colors = {"White","Crimson", "Teal", "Navy", "Magenta", "Light Coral", "Orange","Red","Medium Spring Green","Aqua"+
				"Aquamarine","Cornflower Blue", "Blue Violet", "Deep Pink", "Hot Pink","Sky Blue"};
		ballcolor = new JComboBox(colors);
		ballcolor.addActionListener(this);
		ballcolor.setBounds(150,240,100,20);
		panel.add(ballcolor);

		//Paddle Color JLabel
		PaddleColor = new JLabel("Paddle Color");
		PaddleColor.setBounds(260,220,100,20);
		panel.add(PaddleColor);
		
		//Paddle Color choice
		String[] colors2 = {"White","Crimson", "Teal", "Navy", "Magenta", "Light Coral", "Orange","Red","Medium Spring Green","Aqua"+
				"Aquamarine","Cornflower Blue", "Blue Violet", "Deep Pink", "Hot Pink","Sky Blue"};
		paddlecolor = new JComboBox(colors2);
		paddlecolor.addActionListener(this);
		paddlecolor.setBounds(260,240,100,20);
		panel.add(paddlecolor);

	}
	public Color colorSelect(String colorObject, String colorString) {
		Color color = Color.WHITE;
		//Identifies the color and changes the selected color to the user's choice.
		switch (colorString) {
		case "White":
			colors = new Color(255,255,255);
			color = colors;
			break;
		case "Crimson":
			colors = new Color(220,20,60);
			color = colors;
			break;
		case "Teal":
			colors = new Color(0,128,128);
			color = colors;				
			break;
		case "Navy":
			colors = new Color(0,0,128);
			color = colors;				
			break;
		case "Magenta":
			colors = new Color(255,0,255);
			color = colors;				
			break;
		case "Light Coral":
			colors = new Color(240,128,128);
			color = colors;				
			break;
		case "Orange":
			colors = new Color(255,155,0);
			color = colors;				
			break;
		case "Red":
			colors = new Color(255,0,0);
			color = colors;				
			break;
		case "Medium Spring Green":
			colors = new Color(0,250,154);
			color = colors;				
			break;
		case "Aqua":
			colors = new Color(0,255,255);
			color = colors;				
			break;
		case "Aquamarine":
			colors = new Color(127,255,212);
			color = colors;				
			break;
		case "Cornflower Blue":
			colors = new Color(100,149,237);
			color = colors;				
			break;
		case "Blue Violet":
			colors = new Color(138,43,226);
			color = colors;				
			break;
		case "Deep Pink":
			colors = new Color(255,20,147);
			color = colors;				
			break;
		case "Hot Pink":
			colors = new Color(255,105,180);
			color = colors;				
			break;
		case "Sky Blue":
			colors = new Color(135,206,235);
			color = colors;				
			break;

		}
		System.out.println(colorObject + " color changed to " + colorString + ".");
		return color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String colorchoice = (String) ballcolor.getSelectedItem();
		String colorchoice2 = (String) paddlecolor.getSelectedItem();
		//If the play button is pressed, game starts
		if (source == Play ) {
			System.out.println("You are playing Lob Pong!");
			new lobpong(ballColor, paddleColor).setVisible(true);
			// TODO Auto-generated method stub

		}
		//Changes ball color once the user changes it
		else if(source == ballcolor) {
			String colorString = (String) ballcolor.getSelectedItem();
			//Which object's color will change. To make the console print more informative.
			String colorObject = "The ball's";
			ballColor = colorSelect(colorObject, colorString);

		}
		//Changes paddle color once the user changes it
		else if(source == paddlecolor) {
			String colorString = (String) paddlecolor.getSelectedItem();
			//Which object's color will change. To make the console print more informative.
			String colorObject = "The paddle's";
			paddleColor = colorSelect(colorObject, colorString);
		}
	}
}