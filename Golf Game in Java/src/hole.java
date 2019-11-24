//this class defines a hole and declares import variables for each hole
public class hole {
	static int distance;//stores the distance of ball from the hole
	static int par;//stores the expected par of a hole
	static int stroke=0;//to store the number of attempts

	static int holeNo=1;
	static int points=0;

	public hole(int distance, int par) {//constructor
		hole.distance = distance;
		hole.par=par;
		methods.holeInfo();//prints details of the current hole
	}	
	public static int getPar() {
		return par;
	}

	public static void setPar(int par) {
		hole.par = par;
	}

	public static int getDistance() {
		return distance;
	}

	public static void setDistance(int distance) {
		hole.distance = distance;
	}
}
