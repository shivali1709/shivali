/*
* Name: Kashish Dewnani
* NetID: kdewnani
* Assignment: Project 4
* Lab Section: WF
* I collaborated with Shivali Singh (ssingh53)
*/
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class lobpong extends JFrame {
	protected Timer timer, timer2, timer3;
	protected int paddlex, paddley, ballx, bally, Velx, Vely;
	protected double ballAngle;
	protected int paddleMov = 0;
	protected int paddleW = 120;
	protected int paddleL = 20;
	protected int ballW = 20;
	protected int ballL = 20;
	protected int ballSpeed = 10;
	protected int ballSpeedX = 10;
	protected int ballSpeedY = -10;
	protected int Directiony = 1;
	protected int Directionx = 1;
	protected int lives = 5;
	protected int score = 0;
	protected int timeRemaining = 30;
	long levelTime = System.currentTimeMillis() + (timeRemaining * 1000);
	protected int level = 1;
	protected JLabel timeLabel;
	protected double t = 0;
	protected Random rand = new Random();
	static int height,x1,y1,x2,y2, pointx, pointy;
	protected Color ballColor, color, C, C2, paddleColor,c;

	boolean change;
	int randomcolor; 
	int randomcolor2;
	int z1 = 0;
	int z2;
	int z3;
	int setarc = 360;
	int arc = 360;

	int angle = 0;
	public lobpong(Color ballColor, Color paddleColor){
		this.ballColor = ballColor; 
		this.paddleColor = paddleColor;
		//new canvas
		Canvas c = new Canvas();
		add(c);
		setSize(1000,900);
		c.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public class Canvas extends JPanel implements KeyListener, ActionListener{
		int x=10, y=200;
		public Canvas(){
			change = true;
			//Randomizes starting ball angle
			int anglesize = rand.nextInt(5);
			//switch case statement for angle
			switch (anglesize) {
			case 0:
				ballAngle = Math.PI/3;
				break;
			case 1:
				ballAngle = Math.PI/4;
				break;
			case 2:
				ballAngle = 2*(Math.PI/3);
				break;
			case 3:
				ballAngle = 5*(Math.PI/3);
				break;
			case 4:
				ballAngle = 3*(Math.PI/4);
				break;
			}
			//New timers
			timer = new Timer(10, this);
			timer2 =new Timer(25,new TimerCallBack());
			timer3 = new Timer(1000, new TimerCallBack2());
			timer.start();

			timer2.start();
			timer3.start();
			paddlex = 1000/2 -120/2;
			paddley = 870 - 20-10;
			ballx = 1000/2 - 20/2;
			bally = 880/2 - 20/2;

			setResizable(false);
			addKeyListener(this);
			setFocusable(true);

		}
		//TimerCallBack class for timer2
		public class TimerCallBack implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				z1+=5;
			}

		}
		//TimerCallBack class for timer3
		public class TimerCallBack2 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				arc= arc- 12;
			}

		}
		public void paintComponent(Graphics g) {
			int height = getHeight();
			int width = getWidth();
			Color c1 = Color.RED;
			Color c2 = Color.BLUE;
			Color c3 = Color.GREEN;
			Color c4 = new Color(102, 0, 153);
			super.paintComponent(g);
			//sets background to black
			g.setColor(color.BLACK);
			g.fillRect(0,0,getWidth(), getHeight());
			//Non-Stationary obstacle/power-up for levels b/w 1 and 16
			if(level >= 6&&level<16) {
				if(randomcolor ==0&&change ==true) {
					C = c1;
					g.setColor(C);
				}else if(randomcolor ==1&&change ==true) {
					C = c2;
					g.setColor(C);
				}else if(randomcolor ==2&&change ==true) {
					C = c3;
					g.setColor(C);
				}else if(randomcolor ==3&&change ==true) {
					C = c4;
					g.setColor(C);
				}
				g.fillOval(z1, z2, 75, 75);
				if(Math.abs(ballx-z1)<=50 &&Math.abs(bally-z2)<=50&&change ==true) {
					//reduces score by 3
					if (C== c1) {
						score-=3;
					}
					//increases lives by 1
					if (C== c2) {
						lives++;
					}
					//reduces lives by 1
					if (C== c3) {
						lives--;
					}
					//increases score by 3
					if (C== c4) {
						score+=3;
					}
					g.setColor(Color.BLACK);
					g.fillOval(z1, z2, 75, 75);
					change = false;
				}

			}
			//Lives cannot go higher than 10
			if(lives >= 10) {
				lives =10;
			}
			//Stationary obstacle/power-up for level greater than or equal to 11
			if(level >=11) {
				if(randomcolor2 ==0) {
					C = c1;
					g.setColor(C);
				}else if(randomcolor2 ==1) {
					C = c2;
					g.setColor(C);
				}else if(randomcolor2 ==2) {
					C = c3;
					g.setColor(C);
				}else if(randomcolor2 ==3) {
					C = c4;
					g.setColor(C);
				}
				g.setColor(C);
				g.fillRect(0, height/2-z3, 20, 60);
				g.fillRect(width-20, height/2-z3, 20, 60);
				//changes score and lives based on the color and which rectangle the ball hits.
				if(Math.abs(ballx)>=1&&Math.abs(ballx)<=2 &&Math.abs(bally)>=height/2-z3&&Math.abs(bally)<=height/2+z3) {
					if (C== c1) {
						score--;
					}
					if (C== c2) {
						lives++;
					}
					if (C== c3) {
						lives--;
					}
					if (C== c4) {
						score++;
					}
				}else if(Math.abs(ballx)>=width-25&&Math.abs(ballx)<=width-20 &&Math.abs(bally)>=height/2-z3&&Math.abs(bally)<=height/2+z3) {
					if (C== c1) {
						score--;
					}
					if (C== c2) {
						lives++;
					}
					if (C== c3) {
						lives--;
					}
					if (C== c4) {
						score++;
					}
				}
			}
			//Changes number and color of rectangles based on the number of lives
			switch(lives) {
			case(10):
				g.setColor(Color.YELLOW);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			g.fillRect(width/4+30, 40,15 ,15);
			g.fillRect(width/4+60, 40,15 ,15);
			break;
			case(9):
				g.setColor(Color.YELLOW);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			g.fillRect(width/4+30, 40,15 ,15);
			c = new Color(0, 0, 205);
			g.setColor(c);
			g.fillRect(width/4+60, 40,15 ,15);
			break;
			case(8):
				g.setColor(Color.YELLOW);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			c = new Color(0, 0, 205);
			g.setColor(c);
			g.fillRect(width/4+30, 40,15 ,15);
			g.fillRect(width/4+60, 40,15 ,15);
			break;
			case(7):
				g.setColor(Color.YELLOW);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			c = new Color(0, 0, 205);
			g.setColor(c);
			g.fillRect(width/4, 40,15 ,15);
			g.fillRect(width/4+30, 40,15 ,15);
			g.fillRect(width/4+60, 40,15 ,15);
			break;
			case(6):
				g.setColor(Color.YELLOW);
			g.fillRect(width/4-60, 40,15,15);
			c = new Color(0, 0, 205);
			g.setColor(c);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			g.fillRect(width/4+30, 40,15 ,15);
			g.fillRect(width/4+60, 40,15 ,15);
			break;
			case(5):
				c = new Color(0, 0, 205);
			g.setColor(c);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			g.fillRect(width/4+30, 40,15 ,15);
			g.fillRect(width/4+60, 40,15 ,15);
			break;
			case(4):
				g.setColor(c);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			g.fillRect(width/4+30, 40,15 ,15);
			break;
			case(3):
				g.setColor(c);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			g.fillRect(width/4, 40,15 ,15);
			break;
			case(2):
				g.setColor(c);
			g.fillRect(width/4-60, 40,15,15);
			g.fillRect(width/4-30, 40,15,15);
			break;
			case(1):
				g.setColor(c);
			g.fillRect(width/4-60, 40,15,15);
			break;
			case(0):
				break;
			}
			//Launches fireworks at the end of level 15 if the user wins
			if(level >15) {
				g.setColor(Color.BLUE);
				for (double i = 0; i <= 4; i += 0.005) {
					x1 = (int) ((200)*(Math.cos(1.047)*i));
					y1 = height - (int) ((200*Math.sin(1.047)*i)-(0.5*9.8*Math.pow(i, 2)));
					g.fillOval(x1 - (4/2), y1 - (4/2), 4, 4);
					x2 = width -(int) ((200)*(Math.cos(1.047)*i));
					y2 = height - (int) ((200*Math.sin(1.047)*i)-(0.5*9.8*Math.pow(i, 2)));
					g.fillOval(x2 - 2, y2 - 2, 4, 4);
				}
				pointx = (int) ((200)*(Math.cos(1.047)*4));
				pointy = height - (int) (((200*Math.sin(1.047)*4)-(0.5*9.8*Math.pow(4, 2))));
				Star(g);
				pointx = width -(int) ((200)*(Math.cos(1.047)*4));
				pointy = height - (int) (((200*Math.sin(1.047)*4)-(0.5*9.8*Math.pow(4, 2))));
				Star(g);
			}
			//Sets and updates score
			g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
			g.setColor(new Color(255,215,0));
			g.drawString("Score: "+score,10,60);

			//Sets and updates level
			g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
			g.setColor(new Color(248,248,255));
			g.drawString("Level "+level,width/4+450,50);

			//Sets and updates lives remaining
			g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
			g.setColor(Color.RED);
			g.drawString("Lives Remaining",width/4-60,30);

			//Title of the game
			g.setFont(new Font("TimesRoman", Font.BOLD, 50)); 
			g.setColor(new Color(255,215,0));
			g.drawString("LOB PONG!!!",width/4+110,58);

			g.setColor(Color.WHITE);
			g.setColor(paddleColor);
			//Draws the paddle
			g.fillRect(paddlex, paddley, paddleW, paddleL);
			g.setColor(ballColor);
			//Draws the ball
			g.fillOval(ballx,bally,ballW, ballL);

			g.setColor(new Color(0,255, 51));
			//Draws the timer
			g.fillArc(850, 20, 70, 70,90, arc);
			//If lives<0 or level is grater than 15 then game over
			if (lives <= 0||level>15) {
				timer.stop();
				timer3.stop();//timer stops

				Graphics2D g2=(Graphics2D)g;
				g2.setFont(new Font("TimesRoman", Font.BOLD, 50)); 
				g2.setColor(Color.RED);
				g2.drawString("GAME OVER!",x,y);//Draws Game Over
				g2.drawString("Your score is: "+score,x,y+100);

				try {
					Thread.sleep(25);
				}
				catch(Exception e) {
				}
				x+=5;
				repaint();
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int c = e.getKeyCode ();
			//Moves paddle left when the left arrow key is pressed
			if (c == KeyEvent.VK_LEFT)
			{
				System.out.println("Move Left");
				paddleMov = -8;
			}
			//Moves paddle right when the right arrow key is pressed
			if (c == KeyEvent.VK_RIGHT)
			{
				System.out.println("Move Right");
				paddleMov = 8;
			}
			// TODO Auto-generated method stub
		}
		//Sets paddle movement to 0 when the key is released
		@Override
		public void keyReleased(KeyEvent e) {
			paddleMov=0;
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {

			// TODO Auto-generated method stub

		}



		@Override

		public void actionPerformed(ActionEvent e) {
			//Makes game harder by increasing ballSpeed after level 6
			if(level>=6) {
				ballSpeed =12;
			}
			t+=0.005;
			ballx += Directionx * ballSpeed * Math.cos(ballAngle)*t;
			bally -= Directiony * ballSpeed * Math.sin(ballAngle)*t - 0.5 * 9.8*Math.pow(t, 2);
			//Reflects the ball off the paddle
			if(ballx+ballW/2>=paddlex&&ballx+ballW/2<=paddlex+paddleW) {
				if(bally + ballL >=paddley) {
					bally = paddley-ballL;
					Directiony*=-1;
					score++;
				}
			}
			//Prevents ball from going past the top of the canvas
			if (bally<=0) {
				Directiony *= -1;
				t=0.5;
			}
			//Prevents the ball from going past the left side of the canvas
			if(ballx<0) {
				Directionx *= -1;
				t=0.4;
			}
			//Prevents the ball from going past the right side of the canvas
			if(ballx>=getWidth() - ballW) {
				Directionx *= -1;
				t=0.4;
			}
			else {
				ballAngle= (5 * Math.PI / 3);
			}
			//prevents the paddle from going past the left side of the canvas
			if (paddlex < 0) {
				paddleMov = 0;
				paddlex = 0;
			}
			//prevents the paddle from going past the right side of the canvas
			else if (paddlex > 880)
			{
				paddleMov = 0;
				paddlex = 880;
			}
			//Carries out certain operations if the ball goes past the paddle
			if(bally > getHeight()) {
				timer2.stop();
				timer3.stop();
				timer.stop();
				System.out.println("Round Over.");
				lives -= 1;
				System.out.println("Lives remaining: " + lives);
				paddlex = 1000/2 -120/2;
				paddley = 870 - 20-10;
				ballx = 1000/2 - 20/2;
				bally = 880/2 - 20/2;
				t=0;
				ballSpeed = 10;
				levelTime = System.currentTimeMillis() + (timeRemaining * 1000);
				arc = setarc;

				timer.start();
				timer2.start();
				timer3.start();

			}
			//Carries out operations if level has been completed and the 30 seconds time has passed
			if (((levelTime-System.currentTimeMillis())/1000)==0){
				level++;
				randomcolor = rand.nextInt(4);
				randomcolor2= rand.nextInt(4);
				z1 =0;
				z2 = rand.nextInt(700)+100;
				z3 = rand.nextInt(10)+25;
				change = true;
				timeRemaining = 30;
				levelTime = System.currentTimeMillis() + (timeRemaining * 1000);
				arc = setarc;
				timer.restart();
				timer2.restart();
				timer3.restart();

			}

			paddlex = paddlex + paddleMov;
			repaint ();
		}
	}
	public void setHeight(int Height) {
		height= Height;
	}
	//Draws Star fireworks when you win the game
	public static void Star(Graphics g) {
		int c1 = 0;
		int r = 25;
		int r2 = 75;
		for (int angle = 0; angle < 360; angle+=30) {
			for(int angle2 = 0; angle2<360;angle2+=30) {
				if (c1==6) {
					c1 = 0;
				}
				Color[] colors = {Color.MAGENTA, Color.RED, Color.BLUE, Color.WHITE, Color.RED, Color.BLUE};
				g.setColor(colors[c1]);
				g.drawLine(pointx+(int)(r*Math.sin(Math.toRadians(angle))), pointy+(int)(r*Math.cos(Math.toRadians(angle))),pointx+(int)
						(r2*Math.sin(Math.toRadians(angle2))), pointy+(int)(r2*Math.cos(Math.toRadians(angle2))));
			}
			c1++;
		}
	}

}