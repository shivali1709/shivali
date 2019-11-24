import java.awt.Graphics;

import javax.swing.JComponent;

public class Edge {
	String ID;
	String start;
	String end;

	
	
	public Edge(String ID, String start, String end) {
		
		this.ID= ID;
		this.start=start;
		this.end=end;	
	}


//
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		// TODO Auto-generated method stub
//		
//		String source=start;
//		String target=end;
//		Vertex v1 = Graph.map.get(source);
//		System.out.println(v1);
//		Vertex v2 = Graph.map.get(target);
//		System.out.println(v2);
//		 int x1=(int)(((v1.Latitude-Graph.minX)/Graph.scale)*1000);
//		 int x2=(int)(((v2.Latitude-Graph.minX)/Graph.scale)*1000);
//		 int y1=(int)(((v1.Longitude-Graph.minY)/Graph.scale)*1000);
//		 int y2=(int)(((v2.Longitude-Graph.minY)/Graph.scale)*1000);
//		 System.out.println(x1+ "   "+ x2+ "   "+y1+ "   "+y2);
//		g.drawLine(x1, y1, x2, y2);		
//		g.fillOval(0, 500, 500, 500);
//		g.drawLine(100,200,500,600);
//		
//	}

	public String getstart(String ID) {
		
		return ID;
	}
	
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getstart() {
		return start;
	}

	public void setstart(String latitude) {
		start = latitude;
	}

	public String getend() {
		return end;
	}

	public void setend(String longitude) {
		end = longitude;
	}

	@Override
	public String toString() {
		return "Edge [ID=" + ID + ", start=" + start + ", end=" + end + "]";
	}


}
