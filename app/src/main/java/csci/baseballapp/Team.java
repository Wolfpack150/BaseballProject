package csci.baseballapp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lumpy on 10/3/14.
 */
public class Team implements Serializable {
    //Team Variables
    public String m_teamName;
    public List<Player> m_roster;
    public int m_roster_size;

    //Default constructor for team
    public Team(String name, List<Player> roster, int size){
        m_teamName = name;
        m_roster = roster;
        m_roster_size = size;
    }

    //Class functions
    public void setTeamName(String name) {m_teamName = name;} // Function that allows user to enter the name of the team


    public void addPlayer() //Function that allows user to add new player to team
    {
        Player newPlayer = new Player();
        m_roster_size++; //Increments the size of the team by one each time new player is added

    }
}
