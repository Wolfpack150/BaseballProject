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

    public String searchPlayer(String position) //Function that searches for player in Player array
    {
        for(int i = 0; i < m_roster.size(); i++)
        {
            if(position.equals(m_roster.get(i).m_position))
            {
                return m_roster.get(i).m_lastName;
            }
        }
        return "No player designated";
    }

}
