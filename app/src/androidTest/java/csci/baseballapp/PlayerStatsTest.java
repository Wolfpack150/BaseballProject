package csci.baseballapp;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by lumpy on 12/8/14.
 */
public class PlayerStatsTest extends TestCase {
    public void setUp() {}
    public void tearDown() {}
    public void testStats() {
        List<Player> homePlayers = new Player().getPlayers();

        homePlayers.add(new Player(1,"Dee", "Gordon", "9", "2B", "L", "R", 3));
        homePlayers.add(new Player(1,"Yasiel", "Puig", "66", "CF", "R", "R", 7));
        homePlayers.add(new Player(1,"Adrian", "Gonzalez", "23", "1B", "L", "L", 2));
        homePlayers.add(new Player(1,"Matt", "Kemp", "27", "RF", "R", "R", 8));
        homePlayers.add(new Player(1,"Hanley", "Ramirez", "13", "SS", "R", "R", 5));
        homePlayers.add(new Player(1,"Carl", "Crawford", "3", "LF", "L", "L", 6));
        homePlayers.add(new Player(1,"Juan", "Uribe", "5", "3B", "R", "R", 4));
        homePlayers.add(new Player(1,"A.J.", "Ellis", "17", "C", "R", "R", 1));
        homePlayers.add(new Player(1,"Clayton", "Kershaw", "22", "P", "L", "L", 0));

        Team homeTeam = new Team("Dodgers", homePlayers, homePlayers.size());

        List<Player> visPlayers = new Player().getPlayers();

        visPlayers.add(new Player(2, "Gregor", "Blanco", "7", "CF", "L", "L", 7));
        visPlayers.add(new Player(2, "Joe", "Panik", "12", "2B", "L", "R", 3));
        visPlayers.add(new Player(2, "Buster", "Posey", "28", "C", "R", "R", 1));
        visPlayers.add(new Player(2, "Pablo", "Sandoval", "48", "3B", "S", "R", 4));
        visPlayers.add(new Player(2, "Hunter", "Pence", "8", "RF", "R", "R", 8));
        visPlayers.add(new Player(2, "Brandon", "Belt", "9", "1B", "L", "L", 2));
        visPlayers.add(new Player(2, "Travis", "Ishikawa", "45", "LF", "L", "L", 6));
        visPlayers.add(new Player(2, "Brandon", "Crawford", "35", "SS", "L", "R", 5));
        visPlayers.add(new Player(2, "Madison", "Bumgarner", "40", "P", "L", "L", 0));

        Team visTeam = new Team ("Giants", visPlayers, visPlayers.size());

        Gameplay game = new Gameplay(homeTeam, visTeam, 9);

        game.singles();

        for(int i = 0; i < 3; i++)
            game.incrementStrike();

        for(int i = 0; i < 4; i++)
            game.incrementBall();

        assertEquals(game.m_pitcher.m_lastName, "Kershaw");
        assertEquals(game.m_hitter.m_lastName, "Sandoval");

        assertEquals(visTeam.getPlayerByPos(7).stats.m_hits, 1);
        assertEquals(visTeam.getPlayerByPos(3).stats.m_strikeouts, 1);
        assertEquals(visTeam.getPlayerByPos(1).stats.m_walks, 1);

        assertEquals(homeTeam.getPlayerByPos(0).stats.m_hitsGiven, 1);
        assertEquals(homeTeam.getPlayerByPos(0).stats.m_strikeoutsGiven, 1);
        assertEquals(homeTeam.getPlayerByPos(0).stats.m_walksGiven, 1);
        assertEquals(homeTeam.getPlayerByPos(0).stats.m_pitchesThrown, 8);
    }
}
