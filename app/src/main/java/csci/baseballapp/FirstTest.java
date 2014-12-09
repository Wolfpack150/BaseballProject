package csci.baseballapp;

import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.robolectric.RobolectricTestRunner;

import android.app.Activity;
import android.widget.TextView;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.lang.System;

import csci.baseballapp.Player;

@RunWith(RobolectricTestRunner.class)
public class FirstTest extends TestCase{
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