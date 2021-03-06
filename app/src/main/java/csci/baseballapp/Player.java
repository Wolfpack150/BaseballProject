package csci.baseballapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lumpy on 10/3/14.
 */
public class Player implements Serializable {
    // Player Variables
    public int playerID;
    public int teamID;
    public String m_firstName ;
    public String m_lastName;
    public String m_number;
    public String m_position;
    public String m_bats;
    public String m_throws;
    public int m_positionArray;
    public int currBase;
    public int base;
    public PlayerStats stats;

    private List<Player> Players = new ArrayList<Player>();
    public List<Player> getPlayers() {return Players;}

    public void addPlayer(Player item) {
        Players.add(item);
    }

    public Player(){
        m_firstName = "New";
        m_lastName = "Player";
        m_number = "00";// = null; <--- ??
        m_position = "Bench";
        m_bats = "R";
        m_throws = "R";
        //public String m_hitter = "h";
        stats = new PlayerStats();
        currBase = 0;
    }
    // Player statistics in new class?

    //Overload constructor
    public Player(int tID, String Fname,String Lname,String number,String pos,String bats,String Throws,int posArr)


    {
        this.teamID = tID;
        this.m_positionArray = posArr;
        this.m_firstName = Fname;
        this.m_lastName = Lname;
        this.m_number = number;
        this.m_position = pos;
        this.m_bats = bats;
        this.m_throws = Throws;
        stats = new PlayerStats();
        currBase = 0;
    }

    @Override
    public String toString(){
        return m_firstName + " " + m_lastName + "       #" + m_number +"     " + m_position;
    }

    public void setFirstName(){
        // m_firstName = some function that lets user type in first name
    }
    public void setLastName(){
        // m_LastName = some function that lets user type in Last name
    }
    public void setNumber(){
        // m_number = input
    }
    public void setPosition(){
        // m_position = input
    }
    public void setBats(){
        // m_bats = input
    }
    public void setThrows(){
        // m_throws = input
    }
    private void initBatter () {
        //basePosition[0] = m_hitter;
        }
    private void move(int currBase, int newBase, int Player) {
       // basePosition[1] = null;
       // base position[3] = Player;
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
