package csci.baseballapp;

/**
 * Created by lumpy on 10/3/14.
 */
public class Team {
    //Team Variables
    public String m_teamName;
    public Player[] m_roster;
    public int m_roster_size;

    //Default constructor for team
    public Team(){
        m_teamName = "New Team";
        m_roster_size = 0;
    }

    //Class functions
    public void setTeamName() // Function that allows user to enter the name of the team
    {

    }

    public void addPlayer() //Function that allows user to add new player to team
    {
        Player newPlayer = new Player();
        m_roster_size++; //Increments the size of the team by one each time new player is added

    }
}
