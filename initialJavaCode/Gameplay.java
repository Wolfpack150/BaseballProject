/**
 * Created by lumpy on 9/24/14.
 */
public class Gameplay{
    // Player Variables
    public int m_home_score;
    public int m_away_score;
    public int m_inningtype;// this is for top or bottom of the inning
    public double m_inning; 
    public int m_outs;
    public int m_balls;
    public int m_strikes;
//  public Player m_first, m_second, m_third;
//  public Team m_home, m_away;
//  public Player m_home_pitcher, m_away_pitcher;
//  public Plays possibles;

    //Default constructor
    public Gameplay(){
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
    /******************************************************************
    Reset Count
        For new batter or resets outs for new inning
    ******************************************************************/
    public void resetCount(){
        if(m_outs == 3)
            m_outs = 0;
        m_strikes = 0;
        m_balls = 0;
    }
    /******************************************************************
    Increment Out Function
    ******************************************************************/
    public void incrementOut(){
        m_outs++;
        if(m_outs == 3)
            m_pitcher.m_innings += .8;
        else
            m_pitcher.m_innings += .1;

        resetCount();
        if(m_outs == 0);// change innings and swap current teams
    }
    /******************************************************************
    *                                                                 *
    *                            Pitching                             *
    *                                                                 *
    *                                                                 *
    ******************************************************************/
    /******************************************************************
    Increment Strike function
        Changes the number of pitches/strikes by the pitcher and 
        checks for strikeout
    ******************************************************************/
    public void incrementStrike(){
        m_strikes++;
        m_pitcher.m_pitchesThrown++;
        m_pitcher.m_strikesThrown++;
        if(m_strikes == 3){
            m_pitcher.m_battersFaced++;
            m_pitcher.m_strikeoutsGiven++;
            m_hitter.m_strikeouts++;
            m_hitter.m_plateAppearances++;
            m_hitter.m_atBats++;
            incrementOut();
        }
    }
    /*****************************************************************  
        Increment Ball function
        Changes the number of pitches/balls by the pitcher and checks
        for walk
    ******************************************************************/
    public void incrementBall(){
        m_balls++;
        m_pitcher.m_pitchesThrown++;
        m_pitcher.m_ballsThrown++;
        if(m_balls == 4){
            m_pitcher.m_battersFaced++;
            m_pitcher.m_walksGiven++;
            m_hitter.m_walks++;
            m_hitter.m_plateAppearances++;
            // change runners on base
        }
    }
    /*****************************************************************  
    Increment Intentional Ball function
        Changes the number of pitches/balls by the pitcher and checks
        for intentional walk
    ******************************************************************/
    public void incrementIntentionalBall(){
        m_balls++;
        m_pitcher.m_pitchesThrown++;
        m_pitcher.m_intentioanlBallsThrown++;
        if(m_balls == 4){
            m_pitcher.m_battersFaced++;
            m_pitcher.m_intentionalWalksGiven++;
            m_hitter.m_intentionalWalks++;
            m_hitter.m_plateAppearances++;
            // change runners on base
        }
    }
    /***************************************************************** 
    Foul Ball function
        Changes the number of pitches/strikes by the pitcher and 
        makes sure it doesn't increment if there are 2 strikes
    ******************************************************************/
    public void foulball(){
        if(m_strikes != 2)
            incrementStrike();
        else{
            m_pitcher.m_pitchesThrown++;
            m_pitcher.m_strikesThrown++;
        }
    }
    /******************************************************************
    Foul Tip Out
        Batter fouls off pitch but its caught by the catcher
        Only available on 2 strikes
        Is actually the same function as increment strike
    ******************************************************************/
    public void foulTipout(){
        incrementStrike();
    }
    /******************************************************************
    Hit by pitch
    ******************************************************************/
    public void hitByPitch(){
        m_pitcher.m_battersFaced++;
        m_pitcher.m_pitchesThrown++;
        m_pitcher.m_ballsThrown++;
        m_pitcher.m_hitByPitchGiven++;
        m_hitter.m_hitByPitch++;
        m_hitter.m_plateAppearances++;
        // change runners on base
    }
    /******************************************************************
    Wild pitch
        Only counts as a wild pitch if a runner advances a base because
        of the bad pitch. Make sure we know if its a wild pitch or passed
        ball
        LOOK TO PASSED BALL
    ******************************************************************/
    public void wildPitch(){
        m_pitcher.m_wildPitch++;
        // change runners on base
    }
    /******************************************************************
    Hit by pitch
    ******************************************************************/
    public void balk(){
        m_pitcher.m_balks++;
        // advance runners
    }
    /******************************************************************
    *                                                                 *
    *                            HITTING                              *
    *                                                                 *
    *                                                                 *
    ******************************************************************/
    /******************************************************************
    Hit
        Any time a player gets a hit, then each of the following
        statistics are affected: Plate appearances, at bats, hits
        Pitcher's statistics affected: hits given, batters faces,
        pitches thrown, pitch will be a strike.
    ******************************************************************/
    public void hit(){
        m_pitcher.m_hitsGiven++;
        m_pitcher.m_battersFaced++;
        m_pitcher.m_pitchesThrown++;
        m_pitcher.m_strikesThrown++:
        m_hitter.m_plateAppearances++;
        m_hitter.m_atBats++;
        m_hitter.m_hits++;
    }
    /******************************************************************
    Single
        Will call hit function, but there are a few differences betweeen
        singles, doubles, triples, and home runs, which include:
        Hitter- the type of hit, total bases and possible RBI's and runs
        Pitcher- type of hit given, possible RBI's and runs given
    ******************************************************************/
    public void single(){
        hit();
        m_pitcher.m_singlesGiven++;
        m_hitter.m_singles++;
        m_hitter.m_totalBases++;
    }
    /******************************************************************
    Double
    ******************************************************************/
    public void double(){
        hit();
        m_pitcher.m_doublesGiven++;
        m_hitter.m_doubles++;
        m_hitter.m_totalBases += 2;
    }
    /******************************************************************
    Triple
    ******************************************************************/
    public void triple(){
        hit();
        m_pitcher.m_triplesGiven++;
        m_hitter.m_triples++;
        m_hitter.m_totalBases += 3;
    }
    /******************************************************************
    Home Run
        This is the only one of the hit functions that need to access
        RBI's and runs directly.
    ******************************************************************/
    public void homerun(){
        hit();
        m_pitcher.m_homerunsGiven++;
        m_pitcher.m_runsGiven++;
    //  m_pitcher.m_earnedRuns++;
        m_hitter.m_homeruns++;
        m_hitter.m_runs++;
        m_hitter.m_runsBattedIn++;
        m_hitter.m_totalBases += 4;
    }
    /******************************************************************
    Sacrifice Bunt
    ******************************************************************/
    public void sacrificeBunt(){
        m_hitter.m_sacrificeBunt++;
        // advance runner?
        // RBI?
    }
    /******************************************************************
    Sacrifice Fly
    ******************************************************************/  
    public void sacrificeFly(){
        m_hitter.m_sacrificeFly++;
        // advance runner?
        // RBI?
    }
    /******************************************************************
    *                                                                 *
    *                            FIELDING                             *
    *                                                                 *
    *                                                                 *
    ******************************************************************/
    /******************************************************************
    Assist
        Since an assist involves a thrower, then someone must have 
        caught the ball. Therefore, this function includes both an
        assist and a putout.
    ******************************************************************/
    public void assist(Player thrower, Player receiver){
        thrower.m_assists++;
        reciever.m_putOuts++;
    }
    /******************************************************************
    Putout
        This function is for plays where an out is made where a throw is
        not made. EX: Fly ball to the outfield, ground ball to 1st base
        where the first baseman tags the bag (called 3U or 3 unassisted)
    ******************************************************************/
    public void putOut(Player fielder){
        feilder.m_putOuts++;
    }
    /******************************************************************
    Error
        This will be one of our hardest functions. Errors can be very
        complicated at times, so this will most likely be one of the
        last functions we do. This function must:
                 1. Hold each player involved
                 2. Ask who made the error
                 3. Fielding or throwing error
                 4. Ask what happened with other runners
    ******************************************************************/    
    public void error(){

    }
    /******************************************************************
    Passed Ball
        How to access catcher?
        Should this function (as well as wild pitch) be with balls
        and strikes in the first menu, or should it take place seperate
        of that menu by moving the runner over manually?
    ******************************************************************/
    public void passedBall(){

        // m_catcher.m_passedBalls++;
    }

    /******************************************************************
    *                                                                 *
    *                            BASERUNNING                          *
    *                                                                 *
    *                                                                 *
    ******************************************************************/
    /******************************************************************
    Stolen base
        Player will be input to the function
    ******************************************************************/
    public void stolenBase(Player stealer){
        stealer.m_stolenBases++;
        // change position on basepath?
    }
    /******************************************************************
    Caught Stealing
        Player will be input to the function
        Will increment outs
    ******************************************************************/
    public void caughtStealing(Player runnner, Player thrower, Player reciever){
        runnner.m_caughtStealing++;
        assist(thrower, reciever);
        // change position on basepath?
        incrementOut();
    }
}