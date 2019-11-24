




Welcome to the world of golf.



INSTRUCTIONS FOR THE PLAYER:



The rules of my game are very simple
.
There are two courses. You start by choosing the one you wish to play.
Each course has 18 holes and you have to finish all holes to complete the round. 

When
 you begin the program will inform you how far the hole is from the Tee and the expected number of strokes it should take you to complete the hole (called
 its “par”). What you have to do is choose a club (1-10) and a power to hit the ball with. Club 1 hits the farthest and club 10 the closest. Once you fit
 the ball travels some distance and then you take another hit from where the ball landed. Your aim should be to get the ball in the hole in minimum possible number of strokes.



When the ball reaches within 60 feet of the hole you start putting. Here you only have to specify the power (1 to 10) and aim at getting the ball in the 
hole, popularly known as sinking the hole.

The program will keep you informed of the number of strokes you took and the remaining distance of the hole. Once 
you complete a whole the program will tell you if you were over par, under par or if you made par. Thereafter you can choose to exit the round or move onto 
the next hole in the same course. You will also have the option to quit the round anytime ( even without completing the hole) by just entering 0 when given 
the club choice.



When and if you shall be able to finish the game (Oh yea forgot to tell yea it’s really hard, only the best can finish it) then you will be informed about 
your performance in the round, that’s cumulative of all performance in all the holes, and how close you were to making par. 



But wait there is a catch!!!!!!
 The course isn’t all green. Every hole has a bunker hazard and a water hazard. If the ball goes in the water you have to restart from the previous location and you lose a shot. If the ball goes in a bunker you play from there only but you have to use your wedge (club 10) to be
able to get out of it, this also slows you down.



Okay you are all set! But have you got what it takes? 

See for yourself…GO GOLF…




 




TECHNICAL ASPECTS OF THE PROGRAM-


Classes-
 
1.	Golf

2.	Course

3.	Club

4.	Hole

5.	Methods



Methods-

1.	main

2.	welcome

3.	course1 & course 2

4.	hole

5.	holeInfo

6.	checkProgress

7.	shot

8.	putt

9.	afterShot

10.	nextDistance

11.	power

12.	hazard

13.	tally

14.	roundTally

15.	terminology

16.	exit

17.	resetGameplay



All methods are self-explanatory and include block  comments in the code to explain their purpose.



Variables:

All variables are self-explanatory and include comments in the code to explain their purpose.



Functioning:
	

The best part of this code is its appreciably short length. And this means increased complexity of the code. All the methods are nested in one another (mostly linearly). Looping has been used to keep the program going. The variable run is used to run the loop until its value becomes false.  Also almost all methods have some time of conditionals( if else or switch case) to account for all the possibilities.



To explain a basic outline the following method calls are followed-



main()-> welcome() -> course1()/course2()-> hole()-> holeInfo()-> checkProgress->shot()/put() & power() & aftershot()-> nextDistance() …



The most important part of this code is the for loop in class course. It loops through an array of constructors of class hole, activating one at a time and hence declaring the hole distance and par. This greatly reduces the length of the code.



EXTRA-CREDITS:



•	the gamer has been given the functionality of quitting the game anytime he feels like (after every shot, after every hole and after finishing the game.) he can also quit the current course and choose a different course any time.

•	The program incorporates some cool and original Scottish terminologies of the golf game like birdie, bogey, eagle…

•	Every hole has a water hazard starting from 2/10th and ending at 3/10th of its length. Similarly, every hole has a bunker hazard starting from 5/10th and ending at 6/10th of its length. A water hazard resets the ball to its previous location and costs the player shot. The bunker hazard is hard to play out of and hence slows down the player.