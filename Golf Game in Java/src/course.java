//this class defines the properties of both the course. it has the primary for loop inside which the complete course runs
public class course {
	public static  int roundPar;//contains the sum of total par of all 18 holes
	public static int roundStrokes;// to store the total attempts in 1 round
	public static int roundPoints;//to store the difference of the above two
	static boolean run=true;// to run the loop
	
	

	public static void course1() {//method which runs the course 1
		
		System.out.println("You are playing Pacific Dunes");
		System.out.println("\n\t\t\t\t\tHOLE:"+hole.holeNo);
		//defining the holes of this course
		hole[] H= { new hole(370,4), new hole(368,4),new hole(449,5), new hole(463,4), new hole(199,3), new hole(316,4), 
				new hole(464,4), new hole(400,4), new hole(406,4), new hole(206,3), new hole(148,3), new hole(529,5),
				new hole(444,4), new hole(145,3), new hole(539,5), new hole(338,4), new hole(208,3), new hole(591,5)};
		roundPar=71;
		for(hole val: H);//to loop through all the holes in the course
		methods.roundTally();//after completion of a round it does the final tally to give the result
	}
	
	public static void course2() {
	
		System.out.println("You are playing Bandon Dunes");
		System.out.println("\n\t\t\t\t\tHole:"+hole.holeNo);
		hole[] H= { new hole(386,4), new hole(189,3), new hole(543,5), new hole(410,4), new hole(428,4), new hole(161,3),
				new hole(383,4), new hole(359,4), new hole(558,5), new hole(362,4), new hole(384,4), new hole(199,3),
				new hole(553,5), new hole(359,4), new hole(163,3), new hole(363,4), new hole(389,4), new hole(543,5)};	
	
	roundPar=72;
	for(hole val: H);
	methods.roundTally();
	}

}

