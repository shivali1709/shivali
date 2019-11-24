public class Vertex {

	String ID;
	int Num;
	double Latitude;
	double Longitude;

	public Vertex(String ID, int Num, double Latitude, double Longitude) {
		this.ID= ID;
		this.Num=Num;
		this.Latitude=Latitude;
		this.Longitude=Longitude;	
	}

	@Override
	public String toString() {
		return "Vertex [ID=" + ID + ", Num=" + Num + ", Latitude=" + Latitude + ", Longitude=" + Longitude + "]";
	}

}
