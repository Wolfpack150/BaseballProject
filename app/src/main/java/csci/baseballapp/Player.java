package csci.baseballapp;

/**
 * Created by lumpy on 10/3/14.
 */
public class Player {
    // Player Variables
    public String m_firstName = "New";
    public String m_lastName = "Player";
    public int m_number;// = null; <--- ??
    public String m_position = "Bench";
    public char m_bats = 'R';
    public char m_throws = 'R';
    public PlayerStats stats;
    // Player statistics in new class?

    //NOTE:
	/*	1. These are all public for now, but will most likely be set to private.
		2. The "m_" is added in front of each variable to specify that it is the
		   member variable for this class. This makes it easier to tell which variable
		   is being updated. For example:

			   	public Player(int number){
\					this.number = number;  <--- hard to know what is what
				}

				public Player(int number){
					this.m_number = number; <--- much easier
		}
		However, this is up for discussion!

	*/

    //Default constructor
    public Player(){
        //System.out.println("Constructor of " + this.m_firstName + " " + this.m_lastName);
    }

    public void setFirstName(){
        // m_firstName = some function that lets user type in first name
    }
    public void setLastName(){
        // m_LastName = some function that lets user type in Last name
    }
    public void setNumber(some input){
        // m_number = input
    }
    public void setPosition(){
        // m_position = input
    }
    public void setBats(some input){
        // m_bats = input
    }
    public void setThrows(some input){
        // m_throws = input
    }


    // NOTE:
	/*When the "Create Player" screen is opened, the user wiil fill
	out as many of the categories as they know. As these variables are inserted,
	temporary variable will hold those values. Once the user hits the "Done"
	button on the screen, a "createPlayer()" function will be called using the
	data from the temporary variables. For example imagine the user has this
	screen:

	Create Player
	First Name: Brandon
	Last Name: <no user entry.
	Number: 21
	Position: P (pitcher)
	Bats: R
	Throws: <no user entry>

	In this situation, assume the user did not know the last name of the player
	or which hand he throws with. In this case, we should set those values to either
	a default value or keep them blank to avoid user confusion.

	Any variable not defined by the user will be set to a default value. We need to
	find a way to input data so that the user understands that no data has been entered OR
	give it a value and find a way to keep it hidden from the user.

	We also need to figure out what the minimum data must be for the user to create a player.
	Do we require a name, number and/or position? Or do we put placeholders in for the user until
	they get the correct information.
	*/
}
