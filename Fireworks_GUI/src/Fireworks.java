import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

@SuppressWarnings("serial")
public class Fireworks extends Fireworks2 {
	static Random rand=new Random();
	static int pointx, pointy,prevpointx,prevpointy,x,y,x2,y2;
	static int height;
	static int width;

	public void setHeight(int Height) {
		height= Height;
	}
	public void setWidth(int Width) {
		width= Width;
	}
	public static void Projectile(Graphics g) {
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum)*i));
			y = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x - (4/2), y - (4/2), 4, 4);
		}
	}
	public static void Endpoint() {
		pointx = (int) ((speednum)*(Math.cos(anglenum)*timenum));
		pointy = height - (int) (((speednum*Math.sin(anglenum)*timenum)-(0.5*9.8*Math.pow(timenum, 2))));
	}
	public static void DoubleProjectile(Graphics g) {
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum)*i));
			y = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x - (4/2), y - (4/2), 4, 4);
			x2 = width -(int) ((speednum)*(Math.cos(anglenum)*i));
			y2 = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x2 - 2, y2 - 2, 4, 4);
			if (Math.abs(x-x2)<=50 && Math.abs(y-y2)<=50) {
				break;
			}
		}
	}

	//Calculates the final point of the Firework.
	public static void DoubleEndpoint() {
		if (Math.abs(x-x2)<=50&&Math.abs(y-y2)<=50) {
			pointx = x;
			pointy = y;

		}else {
			pointx = (int) ((speednum)*(Math.cos(anglenum)*timenum));
			pointy = height - (int) (((speednum*Math.sin(anglenum)*timenum)-(0.5*9.8*Math.pow(timenum, 2))));
		}
	}

	//Calculates the final point of the Firework
	public static void DoubleEndpoint2() {
		if (Math.abs(x-x2)<=50&&Math.abs(y-y2)<=50) {
			pointx = x2;
			pointy = y2;

		}else {
			pointx = width -(int) ((speednum)*(Math.cos(anglenum)*timenum));
			pointy = height - (int) (((speednum*Math.sin(anglenum)*timenum)-(0.5*9.8*Math.pow(timenum, 2))));
		}
	}
	public static void Collision(Graphics g) {
		if (Math.abs(x-x2)<=50&&Math.abs(y-y2)<=50) {

			int c= 0;
			int r = 200;
			int angle = 0;
			for (angle = 0; angle < 360; angle+=10) {
				for (int i = 0; i <= 10; i ++) {
					if (c==6) {
						c = 0;
					}
					Color[] colors = {color, Color.BLUE, color, Color.WHITE, color, Color.GREEN};
					g.setColor(colors[c]);
					g.drawLine(pointx, pointy, pointx+(int)(r*Math.sin(Math.toRadians(angle))), pointy+(int)(r*Math.cos(Math.toRadians(angle))));
				}
				c++;
			}


		}
	}
	public static void Multipleprojectiles(Graphics g) {
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum)*i));
			y = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x - 2, y - 2, 4, 4);
		}
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum)*i));
			y = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x+prevpointx -2, y-(height-prevpointy) -2,  5, 5);
		}
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum+10)*i));
			y = height - (int) ((speednum*Math.sin(anglenum+10)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x+prevpointx -2, y-(height-prevpointy) -2,  5, 5);
		}
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum-10)*i));
			y = height - (int) ((speednum*Math.sin(anglenum-10)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x+prevpointx -2, y-(height-prevpointy) -2,  5, 5);
		}
	}
	public static void Endpoint3() {
		pointx = (int) ((speednum)*(Math.cos(anglenum)*timenum))+prevpointx;
		pointy = height - (int) (((speednum*Math.sin(anglenum)*timenum)-(0.5*9.8*Math.pow(timenum, 2))))-(height-prevpointy);
	}
	public static void Multipleprojectiles2(Graphics g) {
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum)*i));
			y = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x - 2, y - 2, 4, 4);	
		}
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum)*i));
			y = height - (int) ((speednum*Math.sin(anglenum)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x+prevpointx -2, y-(height-prevpointy) -2,  3, 3);
		}
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum+0.5)*i));
			y = height - (int) (((speednum)*Math.sin(anglenum+0.5)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x+prevpointx -2, y-(height-prevpointy) -2,  3, 3);
		}
		for (double i = 0; i <= timenum; i += 0.005) {
			x = (int) ((speednum)*(Math.cos(anglenum-0.5)*i));
			y = height - (int) ((speednum*Math.sin(anglenum-0.5)*i)-(0.5*9.8*Math.pow(i, 2)));
			g.fillOval(x+prevpointx -2, y-(height-prevpointy) -2,  3, 3);
		}
	}
	public static void Endpoint4() {
		prevpointx = (int) ((speednum)*(Math.cos(anglenum)*timenum));
		prevpointy = height - (int) (((speednum*Math.sin(anglenum)*timenum)-(0.5*9.8*Math.pow(timenum, 2))));
	}
	public static void Endpoint5() {
		pointx = (int) ((speednum)*(Math.cos(anglenum)*timenum))+prevpointx;
		pointy = height - (int) (((speednum*Math.sin(anglenum)*timenum)-(0.5*9.8*Math.pow(timenum, 2))))-(height-prevpointy);
	}
	public static void Endpoint6() {
		pointx = (int) ((speednum)*(Math.cos(anglenum+0.5)*timenum))+prevpointx;
		pointy = height - (int) (((speednum*Math.sin(anglenum+0.5)*timenum)-(0.5*9.8*Math.pow(timenum, 2))))-(height-prevpointy);
	}
	public static void Endpoint7() {
		pointx = (int) ((speednum)*(Math.cos(anglenum-0.5)*timenum))+prevpointx;
		pointy = height - (int) (((speednum*Math.sin(anglenum-0.5)*timenum)-(0.5*9.8*Math.pow(timenum, 2))))-(height-prevpointy);
	}

	public static void Circles(Graphics g) {
		int c = 0;
		for (int i = 0; i <= 10; i ++) {
			if (c==6) {
				c = 0;
			}
			int diameter = rand.nextInt(25)+5;
			Color[] colors = {color, Color.BLUE, color, Color.RED, color, Color.CYAN};
			g.setColor(colors[c]);
			g.drawOval(pointx + rand.nextInt(30)+5 - diameter/2, pointy + rand.nextInt(30)+5 - diameter/2, diameter, diameter);
			g.drawOval(pointx + rand.nextInt(30)+5 - diameter/2, pointy - rand.nextInt(30)+5 - diameter/2, diameter, diameter);
			g.drawOval(pointx - rand.nextInt(30)+5 - diameter/2, pointy + rand.nextInt(30)+5 - diameter/2, diameter, diameter);
			g.drawOval(pointx - rand.nextInt(30)+5 - diameter/2, pointy - rand.nextInt(30)+5 - diameter/2, diameter, diameter);
			c++;
		}

	}
	public static void Squares(Graphics g) {
		int c= 0;
		for (int i = 0; i <= 5; i ++) {
			if (c==6) {
				c = 0;
			}
			Color[] colors = {color, Color.YELLOW, color, Color.MAGENTA, color, Color.ORANGE};
			g.setColor(colors[c]);
			int length = rand.nextInt(25)+5;
			g.drawRect(pointx + rand.nextInt(20)+5 -  length/2, pointy + rand.nextInt(20)+5 - length/2, length, length);
			g.drawRect(pointx + rand.nextInt(20)+5 - length/2, pointy - rand.nextInt(20)+5 - length/2, length, length);
			g.drawRect(pointx - rand.nextInt(20)+5 -  length/2, pointy + rand.nextInt(20)+5 - length/2, length, length);
			g.drawRect(pointx - rand.nextInt(20)+5 -  length/2, pointy - rand.nextInt(20)+5 - length/2, length, length);
			c++;
		}

	}
	public static void Lines(Graphics g) {
		int c= 0;
		int r = 100;
		int angle = 0;
		for (angle = 0; angle < 360; angle+=10) {
			for (int i = 0; i <= 10; i ++) {
				if (c==6) {
					c = 0;
				}
				Color[] colors = {color, Color.YELLOW, color, Color.MAGENTA, color, Color.ORANGE};
				g.setColor(colors[c]);
				g.drawLine(pointx, pointy, pointx+(int)(r*Math.sin(Math.toRadians(angle))), pointy+(int)(r*Math.cos(Math.toRadians(angle))));
			}
			c++;
		}
	}
	public static void Sparkler(Graphics g) {

		int r = 100;
		int angle = 0;
		for (angle = 0; angle < 360; angle+=30) {
			g.setColor(Color.BLUE);
			g.drawLine(pointx, pointy, pointx+(int)(r*Math.sin(Math.toRadians(angle))), pointy+(int)(r*Math.cos(Math.toRadians(angle))));
		}

		for (angle = 15; angle < 360; angle+=20) {
			r=50;
			g.setColor(color);
			g.drawLine(pointx, pointy, pointx+(int)(r*Math.sin(Math.toRadians(angle))), pointy+(int)(r*Math.cos(Math.toRadians(angle))));

		} 
		for (int j = 10; j<360; j+=10) {
			r=20;
			g.setColor(Color.MAGENTA);
			g.drawLine(pointx, pointy, pointx+(int)(r*Math.sin(Math.toRadians(j))), pointy+(int)(r*Math.cos(Math.toRadians(j))));
		}	

	}

	public static void Diamonds(Graphics g) {	
		int c1= 0;
		for (int i = 0; i <= 5; i ++) {
			if (c1==6) {
				c1 = 0;
			}
			Color[] colors = {color, Color.YELLOW, color, Color.MAGENTA, color, Color.ORANGE};
			g.setColor(colors[c1]);
			int length = rand.nextInt(25)+5;
			g.drawRect(pointx + length, (pointy-16) +length , length, length);
			g.drawRect(pointx + length, (pointy-32) +length , length, length);
			g.drawRect(pointx + length, pointy + length, length, length);
			g.drawRect(pointx + 16 + length, (pointy - 16) + length, length, length);
			g.drawRect((pointx - 16) + length, (pointy - 16) + length, length, length);
			g.drawLine((pointx+8)+length,(pointy+24)+length,(pointx-24)+length,(pointy-8)+length);
			g.drawLine((pointx+8)+length,(pointy+24)+length,(pointx+40)+length,(pointy-8)+length);
			g.drawLine((pointx+8)+length,(pointy-40)+length,(pointx-24)+length,(pointy-8)+length);
			g.drawLine((pointx+8)+length,(pointy-40)+length,(pointx+40)+length,(pointy-8)+length);
			c1++;
		}
		for (int i = 0; i <= 5; i ++) {
			if (c1==6) {
				c1 = 0;
			}
			Color[] colors = {color, Color.YELLOW, color, Color.MAGENTA, color, Color.ORANGE};
			g.setColor(colors[c1]);
			int length = rand.nextInt(25)+5;
			g.drawRect(pointx - length, (pointy-16) -length , length, length);
			g.drawRect(pointx - length, (pointy-32) -length , length, length);
			g.drawRect(pointx - length, pointy - length, length, length);
			g.drawRect(pointx + 16 - length, (pointy - 16) - length, length, length);
			g.drawRect((pointx - 16) - length, (pointy - 16) - length, length, length);
			g.drawLine((pointx+8)-length,(pointy+24)-length,(pointx-24)-length,(pointy-8)-length);
			g.drawLine((pointx+8)-length,(pointy+24)-length,(pointx+40)-length,(pointy-8)-length);
			g.drawLine((pointx+8)-length,(pointy-40)-length,(pointx-24)-length,(pointy-8)-length);
			g.drawLine((pointx+8)-length,(pointy-40)-length,(pointx+40)-length,(pointy-8)-length);
			c1++;
		}
	}
	public static void Flower(Graphics g) {
		int c1=0;
		for (int i = 0; i<800;i++) {
			if (c1==6) {
				c1 = 0;
			}
			Color[] colors = {color, Color.PINK, color, Color.GREEN, color, Color.BLUE};
			g.setColor(colors[c1]);
			g.fillOval(pointx + (int)(50*Math.cos((Math.PI * i) / 400.0)*(1-Math.cos(8*Math.PI*i/400.0))),pointy + (int) (50*Math.sin(Math.PI*i
					/400.0)*(1-Math.cos(8*Math.PI*i/400.0))),3,3);
			c1++;
		}
	}
	public static void Star(Graphics g) {
		int c1 = 0;
		int r = 25;
		int r2 = 75;
		for (int angle = 0; angle < 360; angle+=30) {
			for(int angle2 = 0; angle2<360;angle2+=30) {
				if (c1==6) {
					c1 = 0;
				}
				Color[] colors = {color, Color.RED, color, Color.WHITE, color, Color.BLUE};
				g.setColor(colors[c1]);
				g.drawLine(pointx+(int)(r*Math.sin(Math.toRadians(angle))), pointy+(int)(r*Math.cos(Math.toRadians(angle))),pointx+(int)
						(r2*Math.sin(Math.toRadians(angle2))), pointy+(int)(r2*Math.cos(Math.toRadians(angle2))));
			}
			c1++;
		}
	}
}