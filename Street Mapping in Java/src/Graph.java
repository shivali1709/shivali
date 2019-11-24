import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//code used from book
public class Graph extends JFrame{


	static int x1,y1,x2,y2;
	static Double minX, minY,scale;

	static LinkedList<String> eList= new LinkedList<String>();
	static HashMap<String, Vertex> map= new HashMap<String, Vertex>();
	static HashMap<String, Edge> edgeMap= new HashMap<String, Edge>();



	private double[][] matrix; // The edge matrix  //because we are using the matrix implementation
	private int numEdge; // Number of edges //check
	private int[] Mark; // The mark array //to see if it is visited or not


	public Graph() {
		doEverything();
		canvas canvas= new canvas();
		this.setResizable(true);
		this.add(canvas);
		pack();
		
	}
	


	public Graph(int n) {  //num of vertices
		Init(n);
	}
	
	
	public class canvas extends JComponent{
		
		public canvas() {
			System.out.println( "i am the canvas");
		}
		
		public void paintComponent(Graphics g) {
			//g.drawLine(100, 200, 300, 400);
			for(String temp: eList)	{

				Edge eTemp= edgeMap.get(temp);
				String source= eTemp.start;
				String target= eTemp.end;
				Vertex v1 = map.get(source);
				System.out.println(v1);
				Vertex v2 =map.get(target);
				System.out.println(v2);
				x1=(int)(((v1.Latitude-minX)/scale)*800)+200;
				x2=(int)(((v2.Latitude-minX)/scale)*800)+200;
				y1=(int)(((v1.Longitude-minY)/scale)*800)+100;
				y2=(int)(((v2.Longitude-minY)/scale)*800)+100;
				System.out.println(v1.Latitude);
				System.out.println(v1.Latitude-minX);
				System.out.println("before casting: "+((v1.Latitude-minX)/scale)*1000);
				
				
				int w= this.getWidth();
				int h= this.getHeight();
				
				
				g.drawLine((h-y1)*w/1000*h/1200, (h-x1)*w/1000*h/1200*4/6, (h-y2)*w/1000*h/1200,(h- x2)*w/1000*h/1200*4/6);
			}
			//
		}
	}
	
	

	//methods of the graph
	public void Init(int n) {  // @param v: number of vertices
		Mark = new int[n];
		Arrays.fill(Mark, -1);
		matrix = new double[n][n];
		numEdge = 0;	//Initially zero
	}
	public int n() { return Mark.length; } // # of vertices
	public int e() { return numEdge; } // # of edges


	/** @return v’s first neighbor */
	public int first(int v) {       
		for (int i=0; i<Mark.length; i++)
			if (matrix[v][i] != 0) return i;
		return Mark.length; // No edge for this vertex
	}

	/** @return v’s next neighbor after w */
	public int next(int v, int w) {
		for (int i=w+1; i<Mark.length; i++)
			if (matrix[v][i] != 0)
				return i;
		return Mark.length; // No next edge;
	}

	/** Set the weight for an edge */
	public void setEdge(int i, int j, double wt) {
		assert wt!=0 : "Cannot set weight to 0";
		if (matrix[i][j] == 0) numEdge++;
		matrix[i][j] = wt;
		matrix[j][i]= wt;
	}

	/** Delete an edge */
	public void delEdge(int i, int j) { // Delete edge (i, j)
		if (matrix[i][j] != 0) numEdge--;
		matrix[i][j] = 0;
	}

	/** Determine if an edge is in the graph */
	public boolean isEdge(int i, int j)
	{ return matrix[i][j] != 0; }

	/** @return an edge’s weight */
	public double weight(int i, int j) {
		return matrix[i][j];
	}

	/** Set/Get the mark value for a vertex */
	public void setMark(int v, int val) { Mark[v] = val; }
	public int getMark(int v) { return Mark[v]; 
	}



	public static void doEverything() {

		int noOfV=0;
		int noOfE=0;

		LinkedList<Double> listX= new LinkedList<Double>();
		LinkedList<Double> listY= new LinkedList<Double>();

		In in= new In("monroe.txt");
		while(!in.isEmpty()) {
			char test=in.readChar();
			if(test=='i') {
				String s=in.readString();
				double p1=Math.abs(in.readDouble());
				double p2=Math.abs(in.readDouble());
				listX.add(p1);
				listY.add(p2);

				//System.out.println(noOfV);
				Vertex v = new Vertex(s,noOfV,p1,p2);
				map.put(s,v);
				//System.out.println(v);
				noOfV++;	

			}
			else if(test=='r') {
				System.out.println("breaking out"); 
				break;} 
		}
		System.out.println("number of vertices"+ noOfV);
		Graph graph= new Graph(noOfV);

		while(true) {

			noOfE++;
			if( noOfE>=1) {
				char c= in.readChar();					
			}
			String s=in.readString();
			String s1= in.readString();
			String s2= in.readString();
			eList.add(s);

			Edge e= new Edge(s,s1,s2);
			edgeMap.put(s, e);


			//System.out.println(e);
			Vertex vStart=	map.get(s1);
			Vertex vEnd= map.get(s2);
			int pos1=vStart.Num;
			int pos2=vEnd.Num;


			double x1=vStart.Latitude;
			double y1=vStart.Longitude;		
			double x2=vEnd.Latitude;	
			double y2=vEnd.Longitude;


			double weight= distance(x1,y1,x2,y2);
			//calculate distance


			graph.setEdge(pos1, pos2, weight);

			if(in.hasNextChar()) {
				char c= in.readChar();	
			}else {
				break;	
			}

			//now will have to add all the edges to the graph and will have to assign them a weight
			//the weight will be the distance between these points calculated by god knows which weird formula;
			//g.setEdge(i, j, wt);
			//can also do this in a different formula			


		}
		//String[] IDlist = IDs.toArray(new String[IDs.size()]);
		Double[] arrX= listX.toArray(new Double[listX.size()]);
		Double[] arrY= listY.toArray(new Double[listY.size()]);
		Arrays.sort(arrX);
		Arrays.sort(arrY);
		minX= arrX[0];
		Double maxX= arrX[arrX.length-1];
		minY= arrY[0];
		Double maxY= arrY[arrY.length-1];
		Double a= maxX-minX;
		Double b= maxY-minY;
		scale= Math.max(a, b);
		// latitude-minX/scale 
		// longitude-minY/scale
		System.out.println(scale);



//		System.out.println(x1+ "   "+x2+ "   "+y1+ "   "+y2 );

	}


	public static void main(String[] args){
		Graph g= new Graph();
		g.setSize(1200,1200);
		g.setVisible(true);
		g.setResizable(true);
				
	}

	private static final double earthradius = 6371; 

	public static double distance(double stlat, double stlong,double endlat, double endlong) {

		double dLat  = Math.toRadians((endlat - stlat));
		double dLong = Math.toRadians((endlong - stlong));
		stlat = Math.toRadians(stlat);
		endlat   = Math.toRadians(endlat);
		double a = haversin(dLat) + Math.cos(stlat) * Math.cos(endlat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return earthradius * c;
	}

	public static double haversin(double value) {
		return Math.pow(Math.sin(value / 2), 2);
	}

}
