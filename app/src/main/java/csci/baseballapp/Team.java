package csci.baseballapp;

import java.io.Serializable;
import java.util.Iterator;
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

    public String searchPlayer(String position) //Function that searches for player in Player array
    {
        Iterator iterator = m_roster.iterator();

        for(int i = 0; i < m_roster.size(); i++)
        {
            if(position == m_roster.get(i).m_position)
            {
                return m_roster.get(i).m_lastName;
            }
        }
        return "No player designated";
    }

}
