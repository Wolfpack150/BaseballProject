package csci.baseballapp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lumpy on 9/24/14.
 */
public class Gameplay implements Serializable {
    // Player Variables
    public int m_numInnings;
    public int m_home_score;
    public int m_away_score;
    public int m_inningtype;// this is for top or bottom of the inning
    public int m_inning;
    public int m_outs;
    public int m_balls;
    public int m_strikes;
    public int homeCounter;
    public int awayCounter;
    public int counter;
    public List<Player> m_hitting;
    public List<Player> m_fielding ;
    public Player m_hitter, m_pitcher, m_onDeck, m_inHole;
    public Team m_home, m_away;
    public Player m_home_pitcher, m_away_pitcher;
    public Player[] basePosition = {m_hitter,null,null,null,null};


    //Default constructor
    public Gameplay(Team homeTeam, Team visTeam, int innings){
        m_home = homeTeam;
        m_away = visTeam;
        m_hitting = m_away.m_roster;
        m_fielding = m_home.m_roster;
        homeCounter = 0;
        awayCounter = 0;
        counter = awayCounter;
        m_hitter = m_hitting.get(awayCounter);
        m_onDeck = m_hitting.get(awayCounter + 1);
        m_inHole = m_hitting.get(awayCounter + 2);

        m_home_pitcher= m_home.m_roster.get(8);
        m_away_pitcher = m_away.m_roster.get(8);

        m_pitcher = m_home_pitcher;
        m_numInnings = innings;
        m_home_score = 0;
        m_away_score = 0;
        m_inningtype = 0;
        m_inning = 1; // game starts in the first inning
        m_outs = 0;
        m_balls = 0;
        m_strikes = 0;
    }
    /********************
     Overload constructor:
     Example:

     public Gameplay(){

     }
     *********************/
    /******************************************************************
     *                                                                 *
     *                            BASIC                                *
     *                                                                 *
     *                                                                 *
     ******************************************************************/
    public String inningToString(){
        if(m_inningtype == 0) return "Top ";
        else return "Bot ";
    }

    public void nextBatter(){
        if(counter != m_hitting.size() - 1) {
            counter++;
        }
        else{
            counter = 0;
        }

        m_hitter = m_hitting.get(counter);
        m_onDeck = m_hitting.get((counter + 1) % m_hitting.size());
        m_inHole = m_hitting.get((counter + 2) % m_hitting.size());

        basePosition[0] = m_hitter;
    }

    public void changeInning (){
        if(m_inningtype == 0) m_inningtype = 1;
        else {m_inningtype = 0; m_inning++;}

        if(m_hitting == m_away.m_roster){
            awayCounter = counter;
            counter = homeCounter;
            m_hitting = m_home.m_roster;
            m_fielding = m_away.m_roster;
            m_pitcher = m_away_pitcher;
        }
        else{
            homeCounter = counter;
            counter = awayCounter;
            m_hitting = m_away.m_roster;
            m_fielding = m_home.m_roster;
            m_pitcher = m_home_pitcher;
        }
        m_hitter = m_hitting.get(counter);
        m_onDeck = m_hitting.get((counter + 1) % m_hitting.size());
        m_inHole = m_hitting.get((counter + 2) % m_hitting.size());

        for(int i = 1; i < 4; i++){
            if(basePosition[i] != null)
                basePosition[i] = null;
        }
    }
    /**
     * ***************************************************************
     * Reset Count
     * For new batter or resets outs for new inning
     * ****************************************************************
     */

    public void resetCount() {
        if (m_outs == 3)
            m_outs = 0;
        m_strikes = 0;
        m_balls = 0;
    }

    /**
     * ***************************************************************
     * Increment Out Function
     * ****************************************************************
     */
    public void incrementOut() {
        m_outs++;
        if (m_outs == 3)
            m_pitcher.stats.m_innings += .8;
        else
            m_pitcher.stats.m_innings += .1;

        resetCount();
        nextBatter();
        if (m_outs == 0) changeInning(); // change innings and swap current teams
    }
    /******************************************************************
     *                                                                 *
     *                            Pitching                             *
     *                                                                 *
     *                                                                 *
     ******************************************************************/
    /**
     * ***************************************************************
     * Increment Strike function
     * Changes the number of pitches/strikes by the pitcher and
     * checks for strikeout
     * ****************************************************************
     */
    public void incrementStrike() {
        m_strikes++;
        m_pitcher.stats.m_pitchesThrown++;
        m_pitcher.stats.m_strikesThrown++;
        if (m_strikes == 3) {
            m_pitcher.stats.m_battersFaced++;
            m_pitcher.stats.m_strikeoutsGiven++;
            m_hitter.stats.m_strikeouts++;
            m_hitter.stats.m_plateAppearances++;
            m_hitter.stats.m_atBats++;
            incrementOut();

        }
    }

    /**
     * **************************************************************
     * Increment Ball function
     * Changes the number of pitches/balls by the pitcher and checks
     * for walk
     * ****************************************************************
     */
    public void incrementBall() {
        m_balls++;
        m_pitcher.stats.m_pitchesThrown++;
        m_pitcher.stats.m_ballsThrown++;
        if (m_balls == 4) {
            m_pitcher.stats.m_battersFaced++;
            m_pitcher.stats.m_walksGiven++;
            m_hitter.stats.m_walks++;
            m_hitter.stats.m_plateAppearances++;
            if(basePosition[1] != null) {
                if (basePosition[2] != null) {
                    if (basePosition[3] != null)
                        move(basePosition[3], 3, 4);
                    move(basePosition[2], 2, 3);
                }
                move(basePosition[1],1,2);
            }
            move(m_hitter,0,1);
            resetCount();
            nextBatter();
        }
    }

    /**
     * **************************************************************
     * Increment Intentional Ball function
     * Changes the number of pitches/balls by the pitcher and checks
     * for intentional walk
     * ****************************************************************
     */
    public void incrementIntentionalBall() {
        m_balls++;
        m_pitcher.stats.m_pitchesThrown++;
        m_pitcher.stats.m_intentionalBallsThrown++;
        if (m_balls == 4) {
            m_pitcher.stats.m_battersFaced++;
            m_pitcher.stats.m_intentionalWalksGiven++;
            m_hitter.stats.m_intentionalWalks++;
            m_hitter.stats.m_plateAppearances++;
            move(m_hitter,0,1);
            resetCount();
            nextBatter();
        }
    }

    /**
     * **************************************************************
     * Foul Ball function
     * Changes the number of pitches/strikes by the pitcher and
     * makes sure it doesn't increment if there are 2 strikes
     * ****************************************************************
     */
    public void foulball() {
        if (m_strikes != 2)
            incrementStrike();
        else {
            m_pitcher.stats.m_pitchesThrown++;
            m_pitcher.stats.m_strikesThrown++;
        }
    }

    /**
     * ***************************************************************
     * Foul Tip Out
     * Batter fouls off pitch but its caught by the catcher
     * Only available on 2 strikes
     * Is actually the same function as increment strike
     * ****************************************************************
     */
    public void foulTipout() {
        incrementStrike();
    }

    /**
     * ***************************************************************
     * Hit by pitch
     * ****************************************************************
     */
    public void hitByPitch() {
        m_pitcher.stats.m_battersFaced++;
        m_pitcher.stats.m_pitchesThrown++;
        m_pitcher.stats.m_ballsThrown++;
        m_pitcher.stats.m_hitByPitchGiven++;
        m_hitter.stats.m_hitByPitch++;
        m_hitter.stats.m_plateAppearances++;
        move(m_hitter,0,1);
        resetCount();
        nextBatter();
        // change runners on base
    }

    /**
     * ***************************************************************
     * Wild pitch
     * Only counts as a wild pitch if a runner advances a base because
     * of the bad pitch. Make sure we know if its a wild pitch or passed
     * ball
     * LOOK TO PASSED BALL
     * ****************************************************************
     */
    public void wildPitch() {
        m_pitcher.stats.m_wildPitch++;
        // change runners on base
    }

    /**
     * ***************************************************************
     * Hit by pitch
     * ****************************************************************
     */
    public void balk() {
        m_pitcher.stats.m_balks++;
        // advance runners
    }
    /******************************************************************
     *                                                                 *
     *                            HITTING                              *
     *                                                                 *
     *                                                                 *
     ******************************************************************/
    /**
     * ***************************************************************
     * Hit
     * Any time a player gets a hit, then each of the following
     * statistics are affected: Plate appearances, at bats, hits
     * Pitcher's statistics affected: hits given, batters faces,
     * pitches thrown, pitch will be a strike.
     * ****************************************************************
     */
    public void hit() {
        m_pitcher.stats.m_hitsGiven++;
        m_pitcher.stats.m_battersFaced++;
        m_pitcher.stats.m_pitchesThrown++;
        m_pitcher.stats.m_strikesThrown++;
        m_hitter.stats.m_plateAppearances++;
        m_hitter.stats.m_atBats++;
        m_hitter.stats.m_hits++;
    }

    /**
     * ***************************************************************
     * Single
     * Will call hit function, but there are a few differences betweeen
     * singles, doubles, triples, and home runs, which include:
     * Hitter- the type of hit, total bases and possible RBI's and runs
     * Pitcher- type of hit given, possible RBI's and runs given
     * ****************************************************************
     */
    public void singles() {
        hit();
        m_pitcher.stats.m_singlesGiven++;
        m_hitter.stats.m_singles++;
        m_hitter.stats.m_totalBases++;
        move(m_hitter,0,1);
        resetCount();
        nextBatter();
    }

    /**
     * ***************************************************************
     * Double
     * ****************************************************************
     */
    public void doubles() {
        hit();
        m_pitcher.stats.m_doublesGiven++;
        m_hitter.stats.m_doubles++;
        m_hitter.stats.m_totalBases += 2;
        move(m_hitter,0,2);
        resetCount();
        nextBatter();
    }

    /**
     * ***************************************************************
     * Triple
     * ****************************************************************
     */
    public void triples() {
        hit();
        m_pitcher.stats.m_triplesGiven++;
        m_hitter.stats.m_triples++;
        m_hitter.stats.m_totalBases += 3;
        move(m_hitter,0,3);
        resetCount();
        nextBatter();
    }

    /**
     * ***************************************************************
     * Home Run
     * This is the only one of the hit functions that need to access
     * RBI's and runs directly.
     * ****************************************************************
     */
    public void homeruns() {
        hit();
        m_pitcher.stats.m_homerunsGiven++;
        //m_pitcher.stats.m_runsGiven++;
        //  m_pitcher.stats.m_earnedRuns++;
        m_hitter.stats.m_homeruns++;
        //m_hitter.stats.m_runs++;
        //m_hitter.stats.m_runsBattedIn++;
        m_hitter.stats.m_totalBases += 4;
        moveAllHome();
        move(m_hitter,0,4);
        resetCount();
        nextBatter();
    }

    /**
     * ***************************************************************
     * Sacrifice Bunt
     * ****************************************************************
     */
    public void sacrificeBunt() {
        m_hitter.stats.m_sacrificeBunt++;
        // advance runner?
        // RBI?
    }

    /**
     * ***************************************************************
     * Sacrifice Fly
     * ****************************************************************
     */
    public void sacrificeFly() {
        m_hitter.stats.m_sacrificeFly++;
        // advance runner?
        // RBI?
    }
    /******************************************************************
     *                                                                 *
     *                            FIELDING                             *
     *                                                                 *
     *                                                                 *
     ******************************************************************/
    /**
     * ***************************************************************
     * Assist
     * Since an assist involves a thrower, then someone must have
     * caught the ball. Therefore, this function includes both an
     * assist and a putout.
     * ****************************************************************
     */
    public void assist(Player thrower, Player receiver) {
        thrower.stats.m_assists++;
        receiver.stats.m_putOuts++;
    }

    /**
     * ***************************************************************
     * Putout
     * This function is for plays where an out is made where a throw is
     * not made. EX: Fly ball to the outfield, ground ball to 1st base
     * where the first baseman tags the bag (called 3U or 3 unassisted)
     * ****************************************************************
     */
    public void putOut(Player fielder) {
        fielder.stats.m_putOuts++;
    }

    /**
     * ***************************************************************
     * Error
     * This will be one of our hardest functions. Errors can be very
     * complicated at times, so this will most likely be one of the
     * last functions we do. This function must:
     * 1. Hold each player involved
     * 2. Ask who made the error
     * 3. Fielding or throwing error
     * 4. Ask what happened with other runners
     * ****************************************************************
     */
    public void error() {

    }

    /**
     * ***************************************************************
     * Passed Ball
     * How to access catcher?
     * Should this function (as well as wild pitch) be with balls
     * and strikes in the first menu, or should it take place seperate
     * of that menu by moving the runner over manually?
     * ****************************************************************
     */
    public void passedBall() {

        // m_catcher.m_passedBalls++;
    }

    /******************************************************************
     *                                                                 *
     *                            BASERUNNING                          *
     *                                                                 *
     *                                                                 *
     ******************************************************************/
    /**
     * ***************************************************************
     * Stolen base
     * Player will be input to the function
     * ****************************************************************
     */
    public void stolenBase(Player stealer) {
        stealer.stats.m_stolenBases++;
        // change position on basepath?
    }

    /**
     * ***************************************************************
     * Caught Stealing
     * Player will be input to the function
     * Will increment outs
     * ****************************************************************
     */
    public void caughtStealing(Player runnner, Player thrower, Player reciever) {
        runnner.stats.m_caughtStealing++;
        assist(thrower, reciever);
        // change position on basePath?
        incrementOut();
    }


    public void move(Player P, int currBase, int base) {
        basePosition[base] = P;
        basePosition[currBase] = null;
        if(basePosition[4] != null){
            if(m_inningtype == 0)
                m_away_score++;
            else
                m_home_score++;
            basePosition[4].stats.m_runs++;
            m_hitter.stats.m_runsBattedIn++;
            m_pitcher.stats.m_earnedRuns++;
            m_pitcher.stats.m_runsGiven++;
            basePosition[4] = null;
        }
    }

    public void moveAllHome(){
        for(int i = 3; i > 0; i--)
            move(basePosition[i], i, 4);
    }
}