//this class defines has the definition of all the methods used in the program
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class methods {
	static Scanner s= new Scanner(System.in);//scanner instance
	static Random random= new Random();//random instance
	static int temp;
	static int initial;
	
	public static void holeInfo() {//method to print details of the hole
		System.out.print("\nDistance of the hole from Tee: "+ hole.distance);
		System.out.print("\nPar for this hole is: "+ hole.par);
		initial=hole.distance;
		checkProgress();//calls the checkProgress method
	}

	public static void checkProgress() {//method to check location of ball and act accordingly
		while(course.run) {	

			if(hole.distance<=60&& hole.distance>1 || hole.distance<-1 && hole.distance>=-60) {
				club.putt();
				afterShot();

			}
			else if (hole.distance<=1&&hole.distance>=-1) {
				course.run=false;
				System.out.println("It's in the hole!!!");

			}
			else {

				System.out.print("\nChoose a club [1 to 10] (or press 0 to exit): ");
				club.choice= s.nextInt();
				club.shot();
				power();//calls the power method
				afterShot();//calls the afterShot method
			}
		}
		course.run=true;
		tally();
	}

	public static void power() {//method to define the power
		System.out.print("Enter a power[1-10]: ");
		int a= s.nextInt();
		if( a<=10&& a>0) {
			club.power=a;
		}
		else {
			System.out.println("Invalid input");
			power();
		}
	}

	public static void afterShot() {//method to calculate how after the hole is after every shot

		int distanceHit=nextDistance(club.mean, club.stddev, club.power);
		temp=hole.distance;
		hole.distance=Math.abs(hole.distance-distanceHit);
		hole.stroke++;
		System.out.println("\nShots played:"+ hole.stroke);

		if(!(hole.distance<=1&&hole.distance>=-1)){

			System.out.println("You hit the ball at a distance of "+ distanceHit);
			System.out.println("Distance from Hole:"+ hole.distance);
			hazard();
			
			
		}

	}


	public static int nextDistance(int mean, int stddev, int power) {//method to calculate how far the ball travels
		double mean_adj = mean * power / 10.0;
		double stddev_adj = stddev * power / 10.0;
		double val = Math.abs(random.nextGaussian()) * stddev_adj + mean_adj;
		return (int) Math.ceil(val);
	}

	public static void hazard() {//method to check if the ball landed in some hazard
		double a= (double) initial;
		double b=(0.1)*a;

		double d= (double) hole.distance;
		if( d>7*b && d<8*b ) {
			System.out.println("BUT SPLASH! WATER HAZARD");
			hole.distance=temp;
			System.out.println("Start from previous location again");
			System.out.println("Distance from Hole:"+ hole.distance);
		}
		else if( d>4*b && d<5*(b) ) {

			System.out.println("OOPS! BUNKER HAZARD");
			System.out.println("You must use the wedge to get out of the bunker");
			club.mean=50;
			club.stddev=10;
			power();
			afterShot();
		}
	}

	public static void tally() {//method to calculate score after completion of a hole
		hole.points= hole.par-hole.stroke;
		terminology();

		if( hole.points>0) {
			System.out.println("Under par");
		}
		else if(hole.points<0) {
			System.out.println("Over par");
		}
		else {
			System.out.println("You Made Par");
		}

		course.roundStrokes+=hole.stroke;
		hole.stroke=0;
		exit();
	}


	public static void terminology() {//method to print Scottish golf terms based on score
		switch (hole.points) {
		case 1:
			System.out.println("BIRDIE");// A birdie is 1-under par on a hole.
			break;
		case 2:
			System.out.println("EAGLE");     //  An eagle is 2-under par on a hole.
			break;  
		case 3:
			System.out.println("ALBATROSS");// A double eagle (very rare) is 3-under par (also called an "albatross").
			break;   
		case (-1):
			System.out.println("BOGEY");    // A bogey is 1-over par on a hole.
			break;   
		case(-2):
			System.out.println("DOUBLE BOGEY");// A double bogey is 2-over par on a hole.
			break;
		case(-3):
			System.out.println("TRIPLE BOGEY");// A triple bogey is 3-over par.
			break;
		}	 
	}

	public static void roundTally() {//method to calculate score after completion of all holes in course

		course.roundPoints= course.roundPar-course.roundStrokes ;
		if(course.roundPoints<0) 
			System.out.println("Your total score on this course was " + course.roundPoints + " over");
		else if(course.roundPoints>0)
			System.out.println("Your total score on this course was " + course.roundPoints + " under");
		else
			System.out.println("You made par on this course"  );
	}

	public static void exit() {//method to exit the game 
		if(hole.holeNo<18) {//conditional for when all holes aren't completed
			System.out.println("Enter 0 to exit or any other number to continue");
			int input=s.nextInt();
			if(input==0) {
				System.out.println("####");
				resetGameplay();
				golf.welcome();
			}
			else {
				hole.holeNo++;
				System.out.println("\n\n\t\t\t\t\t Hole:"+hole.holeNo);
			}
		}
		else {//conditional for when all holes are completed
			System.out.println("Thanks for playing \nYou have finished this course");
		}	
	}

	public static void resetGameplay() {//method to reset all values 
		course.roundStrokes=0;
		course.roundPoints=0;
		course.roundStrokes=0;
		course.run=true;
		hole.points=0;
		hole.stroke=0;
		hole.holeNo=1;
	}
}
