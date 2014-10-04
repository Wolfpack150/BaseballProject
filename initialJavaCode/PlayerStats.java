/*	Authors: Lumpy
	File Name: PlayerStats.java
	Date: 22 Sept 2014
*/

public class PlayerStats {
    // Pitchers Statistics
    public double m_innings;
    public int m_hitsGiven;
    public int m_runsGiven;
    public int m_earnedRuns;
    public int m_walksGiven;
    public int m_intentionalWalksGiven;
    public int m_hitByPitchGiven;
    public int m_strikeoutsGiven;
    public int m_singlesGiven;
    public int m_doublesGiven;
    public int m_triplesGiven;
    public int m_homerunsGiven;
    public int m_wildPitch;
    public int m_wins;
    public int m_losses;
    public int m_saves;
    public int m_battersFaced;
    public int m_pitchesThrown;
    public int m_strikesThrown;
    public int m_ballsThrown;
    public int m_intentionalBallsThrown;
    public int m_balks;

    // Hitters Statisticss
    public int m_plateAppearances;
    public int m_atBats;
    public int m_hits;
    public int m_runs;
    public int m_walks;
    public int m_intentionalWalks;
    public int m_hitByPitch;
    public int m_strikeouts;
    public int m_singles;
    public int m_doubles;
    public int m_triples;
    public int m_homeruns;
    public int m_runsBattedIn;
    public int m_totalBases;
 	public int m_sacrificeBunt;
 	public int m_sacrificeFly;
 	// public int fieldersChoice; <- Not needed
 	// public int catchersInterference; <- Not needed

 	// Fielding Statistics
 	public int m_assists;
 	public int m_putOuts;
 	public int m_errors;
 	public int m_passedBalls; // Catchers Only!

 	// Baserunning Statistics
 	public int m_stolenBases;
 	public int m_caughtStealing;
 	// public int defensiveIndifferences; <- Not needed

    //Default constructor
    /*********************************************	
        The default constructor for this class 
        will set the value of every value to zero 
    ***********************************************/

    public PlayerStats(){
    	    this.m_innings = 0;
		    this.m_hitsGiven = 0;
		    this.m_runsGiven = 0;
		    this.m_earnedRuns = 0;
		    this.m_walksGiven = 0;
		    this.m_intentionalWalksGiven = 0;
		    this.m_hitByPitchGiven = 0;
		    this.m_strikeoutsGiven = 0;
		    this.m_singlesGiven = 0;
		    this.m_doublesGiven = 0;
		    this.m_triplesGiven = 0;
		    this.m_homerunsGiven = 0;
		    this.m_wildPitch = 0;
		    this.m_wins = 0;
		    this.m_losses = 0;
		    this.m_saves = 0;
		    this.m_battersFaced = 0;
		    this.m_pitchesThrown = 0;
		    this.m_strikesThrown = 0;
		    this.m_ballsThrown = 0;
		    this.m_intentionalBallsThrown = 0;
		    this.m_balks = 0;

		    // Hitters Statistics
		    this.m_plateAppearances = 0;
		    this.m_atBats = 0;
		    this.m_hits = 0;
		    this.m_runs = 0;
		    this.m_walks = 0;
		    this.m_intentionalWalks = 0;
		    this.m_hitByPitch = 0;
		    this.m_strikeouts = 0;
		    this.m_singles = 0;
		    this.m_doubles = 0;
		    this.m_triples = 0;
		    this.m_homeruns = 0;
		    this.m_runsBattedIn = 0;
		    this.m_totalBases = 0;
		 	this.m_sacrificeBunt = 0;
		 	this.m_sacrificeFly = 0;

		 	// Fielding Statistics
		 	this.m_assists = 0;
		 	this.m_putOuts = 0;
		 	this.m_errors = 0;
		 	this.m_passedBalls = 0;

		 	// Baserunning Statistics
		 	this.m_stolenBases = 0;
		 	this.m_caughtStealing = 0;

    }

    //Overload constructor:
    /************************************************************
        This class should not have an overloading constructor.
        A Player's PlayerStats will only be created when the
        Player is created, meaning that they have not played any
    	games yet, so he has no statistics
    **************************************************************/


    // NOTE:
    /*

    */
}