/*Team Class
  created by Leonel Gasca
 */
package csci.baseballapp;

import java.lang.String;

public class Team {
    //Team Variables
    public String m_teamname;
    public String roster[];
    public int roster_size = 0;

    //Default constructor for team
    public Team(){

    }

    //Class functions
    public void setM_teamname() // Function that allows user to enter the name of the team
    {

    }

    public void addPlayer(/*player new_player*/) //Function that allows usert to add new player to team
    {
        roster_size = roster_size +1; //Increments the size of the team by one each time new player is added
    }
}