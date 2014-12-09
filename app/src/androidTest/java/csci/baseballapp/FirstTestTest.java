package csci.baseballapp;

import junit.framework.TestCase;
//@Test
public void setUp () {}
public void tearDown () {}
public void testInstantiation() {

        Player addPlayer = new Player(0,"Brandon", "Lundberg", "21", "R", "R", "P", 0);

        Assert.assertEquals(addPlayer.m_firstName, "Brandon");
        //System.out.println("Hey");

        Assert.assertEquals(addPlayer.m_lastName, "Lundberg");
        /*
        assertEquals(addPlayer.m_number, "21");
        assertEquals(addPlayer.m_bats, "R");
        assertEquals(addPlayer.m_throws, "R");
        assertEquals(addPlayer.m_position, "P");
        assertEquals(addPlayer.m_positionArray, 0);
        */
        }
        }
public class FirstTestTest extends TestCase {

}