import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Graphics;

public class Canvas extends JComponent {
static int x=100;


//Vertex [ID=i11, Num=53, Latitude=43.130181, Longitude=77.631825]
//
//Vertex [ID=i12, Num=54, Latitude=43.129971, Longitude=77.631902]
//
//Vertex [ID=i13, Num=55, Latitude=43.129944, Longitude=77.631336]
//Vertex [ID=i82, Num=123, Latitude=43.131338, Longitude=77.625693]
//Vertex [ID=SAGE, Num=38, Latitude=43.131238, Longitude=77.625502]


double[] arrayX={43.120181,43.129971,43.129944,43.121338,43.131238};
double minX= 43.120181;


double[] arrayY={77.631825,77.631902,77.631336,77.625693,77.625502};
double minY= 77.625502;

double scale= 77.631902-77.625502;




int x1=(int)(((arrayX[0]-minX)/scale)*100);
int x2=(int)(((arrayX[1]-minX)/scale)*100);
int x3=(int)(((arrayX[2]-minX)/scale)*100);
int x4=(int)(((arrayX[3]-minX)/scale)*100);

int y1=(int)(((arrayY[0]-minY)/scale)*100);
int y2=(int)(((arrayY[1]-minY)/scale)*100);
int y3=(int)(((arrayY[2]-minY)/scale)*100);
int y4=(int)(((arrayY[3]-minY)/scale)*100);

public Canvas() {
		
	}

	
	public void paintComponent(Graphics g) {
//		for(int i=0; i<10; i++) {
//			x+=100;
//		g.drawLine(100,100 ,x,20);
//		}
		System.out.println("came here");
	System.out.println(x1+ "   "+ x2+ "   "+ x3+ "   "+ y1+ "   "+ y2+ "   "+ y3);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
		g.drawLine(x3, y3, x1, y1);
	}
	

	public static void main(String[] args)  {
		JFrame frame= new JFrame();
		Canvas canvas= new Canvas();
		Graph g= new Graph();
		frame.add(canvas);
		frame.setVisible(true);
		frame.setSize(800,800);
		
		
	
		
	}
}
