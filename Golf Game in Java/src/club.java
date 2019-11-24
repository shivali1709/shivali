//this class gives the choice of a club to  the user and defines properties of different clubs

public class club {
	static int stddev;//standard deviation
	static int mean;//mean
	static int power;
	static int choice;
	

	public club(int stddev, int mean) {
		club.stddev = stddev;
		club.mean = mean;
	}
	
	public static void shot() {
	
		switch(club.choice)//case conditional to choose a club
		{
		case 1:
			mean=230;
			stddev=30;
			break;
			
		case 2:
			mean=215;
			stddev=20;

			break;
			
		case 3:
			mean=180;
			stddev=20;
		
			break;
			
		case 4:
			mean=170;
			stddev=17;
			
			break;
			
		case 5:
			mean=155;
			stddev=15;
			
			break;
			
		case 6:
			mean=145;
			stddev=15;
		
			break;
			
		case 7:
			mean=135;
			stddev=15;
		
			break;
			
		case 8:
			mean=125;
			stddev=15;
		
			break;
			
		case 9:
			mean=110;
			stddev=10;
			break;
			
		case 10:
			mean=50;
			stddev=10;
			break;
			
		case 0:
			  System.out.println("***********");
			  methods.resetGameplay();//method to reset all variables for a new game
			  golf.welcome();
			  
		default:
			 System.out.println("Invalid input");
			 methods.checkProgress();//method to check progress in the gameplay
		}
	
	}

	
	public static void putt() {
		methods.power();
		switch(power)
		{
		case 10:
			mean=40;
			stddev=5;
			break;
		
		case 9:
			mean=30;
			stddev=5;
			break;
	
		case 8:
			mean=25;
			stddev=4;
			break;
			
		case 7:
			mean=20;
			stddev=4;
			break;
			
		case 6:
			mean=16;
			stddev=3;
			break;
			
		case 5:
			mean=12;
			stddev=3;
			break;
			
		case 4:
			mean=8;
			stddev=2;
			break;
			
		case 3:
			mean=4;
			stddev=2;
			break;
			
		case 2:
			mean=2;
			stddev=1;
			break;
			
		case 1:
			mean=1;
			stddev=1;
			break;
			
		case 0:
			  System.out.println("***********");
			  methods.resetGameplay();
			  golf.welcome();
			  
		default:
			System.out.println("Invalid input");
			putt();
		}
		
	}
}


