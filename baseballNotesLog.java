// File Name: baseballNotesLog.java

/*******************************************************************
	We can use this file to keep track of any general notes/questions
	we have. Post your name and date of the log like this. I'm sure we 
	will be able to do a lot of this in a more efficient way in the
	future, but for now this will work.
********************************************************************/
/********************************************************************
	Sources that may be beneficial to us:
--	http://www.i-programmer.info/programming/android/5914-android-adventures-activity-and-ui.html
	Doing numbers 1 and 2 on this site will help you understand how to
	add buttons and texts to an application and how to link them together
-- 	http://stackoverflow.com/questions/16644946/how-do-you-sync-projects-to-github-with-android-studio
	 down vote accepted
	
	This is how I pushed the project to GitHub.
	1. Open the project you want to push in Android Studio.
	2. Click VCS -> Enable version Control -> Git
	3. There does't seem to be a way to add a remote through the GUI. So open Git Bash in the root of the project and do git remote add <remote_name> <remote_url>
	4. Now when you do VCS -> Commit changes -> Commit & Push you should see your remote and everything should work through the GUI.
	5. If you are getting the error: fatal: remote <remote_name> already exists that means you already added it. To see your remotes do git remote -v and git remote rm <remote_name> to remove.
	To open the project
	I did a pull request from the terminal and did Open Project > Your GitHub repository to find it
********************************************************************/
//EXAMPLE:
/********************************************************************
	Note by: Brandon
	Date: 14 Sept 2014
	Subject: Classes, stats, general notes about GameChanger app
*********************************************************************/ 
/********************************************************************
Just some notes I took on possible classes and in game options
	for the user. Check it out and let me know what you think.

Classes:

1. Game
	a. Type
		i. Softball/baseball
	b. Number Innings
	c. Teams involved
	d. Score
	e. Current Inning

2. Team
	a. Name
	b. Roster (List of Players)

3. Player
	a. Name
		i. First
		ii. Last
	b. Number
	c. Position
	d. Hits
	e. Throw

Should the following just be variables for a player or classes?

4. Position
	a. Pitcher - Yolololololo
	b. C
	c. 1B
	d. 2B
	e. 3B
	f. SS
	g. LF
	h. CF
	i. RF
	j. DH
	k. EH
	l. Bench (Default?)
5. Hits
	a. Right
	b. Left
c. Switch (Right and Left)
	6. Throw
	a. Right
	b. Left

Baseball stats

Pitchers
	Innings pitched (IP)
	Hits (H)
	Runs (R)
	Earned Runs (ER)
	Walks/Base on Balls (BB)
	Intentional Walk (IBB)
	Hit By Pitch (HBP)
	Strikeouts (SO)
	Hits Given Up By Type
		Single (1B)
		Double (2B)
		Triple (3B)
		Home Runs (HR)
	Wild Pitch (WP)
	Wins (W)
	Losses (L)
	Save (S)
	Batters Faced (BF)
	Pitches Thrown (P)
	Strikes (S)
	Balls (B)
	Intentional Balls (IB) 
	Balk

Hitters
	Plate Appearances (PA)
	At Bat (AB)
	Runs (R)
	Hits (H)
	Single (1B)
	Double (2B)
	Triple (3B)
	Home Run (HR)
	Runs Batted In (RBI)
	Total Bases (TB)
	Walk/Base on Balls (BB)
	Intentional Walk (IBB)
	Strikeout (SO)
	Sacrifice Bunt (SAC)
	Sacrifice Fly (SF)
	Fielder’s Choice (FC)
	Catcher’s Interference (CI)

Fielding
	Assist (A)
	Put Out (PO)
	Error (E)
	Passed Ball (PB) (Catcher’s Only)

Baserunning
	Stolen Base (SB)
	Caught Stealing (CS)
	Defensive Indifference (DI)

Options Available through “Pitch” command
Ball
Strike
Foul
	In Play
		Ground ball
			Out
				Options
			Safe
				Single
				Double
				Triple
				Homerun
				Error
				Fielder’s Choice
		Line drive
			Out
				Options
			Safe
				Single
				Double
				Triple
				Homerun
				Error
				Fielder’s Choice
		Fly ball
			Out
				Options
			Safe
				Single
				Double
				Triple
				Homerun
				Error
				Fielder’s Choice
		Pop fly
			Out
				Options
			Safe
				Single
				Double
				Triple
				Homerun
				Error
				Fielder’s Choice
		Bunt 
			Out
				Options
		Safe
			Single
			Double
			Triple
			Homerun
			Sacrifice Bunt
			Error
			Fielder’s Choice
Other
	Intentional Ball
	Intentional Walk (only if last pitch is an intentional ball)
	HBP
	Catcher’s Interference
	Balk
*/

/* More notes from earlier GameChanger app usage:
		Plays in order or backwards (bottom p to top 1 OR top 1 to bottom 9)
		attempted pickoff by pitcher or catcher
		foul tip out/dropped 3rd strike on 2 strike only
		exit on “pitch” menu
		slide runner to base, with sliding into safe or out
		bottom of screen shows last thing that was done, with undo or redo option
		scoring menu shows who scored on that play
		different displays per team
		saves draft when closed
		3U
		out/safe option for fielders choice
		Set lineup after 9, asking for extra batters until it is set
		never has 2 players at same position
		can drag player to same base
		same error/different error movement
*/
/***********************************************************************/

/**********************************************************************
17 Sept 2014
***********************************************************************/
/*********************************************************************
Java Essential Training notes - lynda.com

Everything in java is an object

Examples of easy classes:
	public class SimpleApp{
		public static void main(String[] args){
			Welcomer welcomer = new Welcomer();
			welcomer.sayHello();
		}
	}
	public class Welcomer {
		private String welcome = "Hello";
		public void sayHello(){
			System.out.println(welcome);
		}
	}

These two statements are identical, proving that everything is an object
	String welcome = "Hello!";
	String welcome = new String("Hello!");

variables
	-primitive
		-numerics- ints and floats
		-single chars
		-boolean
	-complex
		-strings
		-dates
		-everything else

How to declare java variables
	-data Type
	-variable name
	-initialization(optional)
How to declare java classes
	-data Type
	-variable name
	-initial value
	
Calls constructor (just like C++)
	Date newDate = new Date(); (calls constructor)

Class variables (fields)
	public class MyClass{
		String sayHello = new String("Hello!");
		void doSomething(){				<---------- class vairable
			System.out.println(sayHello);
		}
	}

static- class method, can be called from  the class definition

must import classes if its needed in a seperate class
	type in class, Ctrl + o to look through packages, select
	This will create "import <package name>"\

Ctrl + click brings you to code that needs to be resolved

Ctrl + space adds the neccesary imports for a function
Ex: ArrayList needs the library  "import java.util.ArrayList;"


public class Olive {
	public String name = "Kalamata";
	public String flavor = "grassy";
	public long color = 0x000000;
	public int oil = 3;  <---- Since oil is only accessed within class, make it private

	public void crush(){
		System.out.println("Ouch!");
	}
}

Print results:
	System.out.println("You got " + <variable> + " units of oil"); <--- looks like data type is not needed

Public- if needed throughout project
Private- only used throughout class

constructor

public class Olive {
	public String name = "Kalamata";
	public String flavor = "grassy";
	public long color = 0x000000;
	private int oil = 3;
	Default constructor
	public Olive(){
		System.out.println("Constructor of " + this.name);  <-- prints "Constructor of Kalamata"
	}
	Overload constructor:
		Right Click > Generate Constructor Using Fields > Click variables to include
		Shows:
		public Olive(int oil){
			super(); <-super class, not yet needed until inheritance
			this.oil = oil;
		}
		If Run with:
		"olive = new Olive(1);"
		it will set the oil for this olive to 1

	Always make a no argument default constructor!!!

	public void crush(){
		System.out.println("Ouch!");
	}
}

getters and setters can be generated