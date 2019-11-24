// this is the primary class. It displays the main menu.


import java.util.Scanner;
public class golf {

	public static void main(String[] args) {
		System.out.println("\t\t\t Welcome To The World Of Golf!");
		welcome();
		}
		
		public static void welcome() { // the primary method
			System.out.println("Choose A Course To Play:");
			System.out.println("1. PACIFIC DUNES");
			System.out.println("2. BANDON  DUNES");
			System.out.println("\n0. EXIT");
			Scanner s1= new Scanner( System.in);//scanner instance
			int input= s1.nextInt();
			
			if( input==1) { 
				course.course1();//if user chooses the first course
			}
			else if(input==2) {
				course.course2();//if user chooses the second course
			}
			else if(input==0) {
				System.out.println("Thanks for playing! \n\t\t\t\t"
						+ "HAVE A GOOD DAY");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input");
				welcome();
			}
		s1.close();
	
	}
}