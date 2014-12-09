package csci.baseballapp;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;
//@Test

public class FirstTestTest extends TestCase {
    public void setUp () {}
    public void tearDown () {}

    public void testPlayer() {

        Player addPlayer = new Player(0,"Brandon", "Lundberg", "21", "P", "R", "R", 0);

        Assert.assertEquals(addPlayer.m_firstName, "Brandon");
        Assert.assertEquals(addPlayer.m_lastName, "Lundberg");
        Assert.assertEquals(addPlayer.m_number, "21");
        Assert.assertEquals(addPlayer.m_bats, "R");
        Assert.assertEquals(addPlayer.m_throws, "R");
        Assert.assertEquals(addPlayer.m_position, "P");
        Assert.assertEquals(addPlayer.m_positionArray, 0);


        List<Player> teamPlayers = new Player().getPlayers();
        teamPlayers.add(addPlayer);
        Team newTeam = new Team ("Dodgers",teamPlayers,teamPlayers.size());
        Assert.assertTrue("Team has a size that is greater than 0", newTeam.m_roster_size > 0);
    }
    public void testTeam () {
        Player player = new Player();
        List<Player> teamPlayers = new Player().getPlayers();
        teamPlayers.add(player);
        Team newTeam = new Team ("Dodgers",teamPlayers,teamPlayers.size());

        Assert.assertTrue("Team has a size that is greater than 0", newTeam.m_roster_size > 0);
    }
}