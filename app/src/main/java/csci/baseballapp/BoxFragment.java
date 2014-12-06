package csci.baseballapp;

import android.app.ListFragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class BoxFragment extends Fragment {
    Gameplay game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_box, container, false);
        Bundle args = getArguments();
        game = (Gameplay) args.getSerializable("gameBundleKey");
        /*
        MYSQLiteHelper db = new MYSQLiteHelper(this.getActivity());
        db.test();
        for(int i = 0; i < game.m_away.m_roster.size(); i++){
            db.createPlayerStats(game.m_away.m_roster.get(i));
        }
        for(int i = 0; i < game.m_home.m_roster.size(); i++){
            db.createPlayerStats(game.m_home.m_roster.get(i));
        }
        */
        /*
        List<Player> homePlayers = db.getAllPlayersFromTeam(1);
        List<Player> visPlayers = db.getAllPlayersFromTeam(2);
        List<Player> homePitchers = db.getAllPitchersFromTeam(1);
        List<Player> visPitchers = db.getAllPitchersFromTeam(2);
        ArrayAdapter<Player> homeAdapter, visAdapter, homeAdapterPitch, visAdapterPitch;
        */

        List<Player> homePlayers = game.m_home.m_roster;
        List<Player> visPlayers = game.m_away.m_roster;

        /*
        ArrayAdapter<Player> homeAdapter, visAdapter;
        homeAdapter = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, homePlayers);
        visAdapter = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, visPlayers);
        homeAdapterPitch = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, homePitchers);
        visAdapterPitch = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, visPitchers);

        ListView visList = (ListView) rootView.findViewById(R.id.visTeamBox);
        visList.setAdapter(visAdapter);
        ListView homeList = (ListView) rootView.findViewById(R.id.homeTeamBox);
        homeList.setAdapter(homeAdapter);
        ListView visListPitch = (ListView) rootView.findViewById(R.id.visTeamPitchBox);
        visListPitch.setAdapter(visAdapterPitch);
        ListView homeListPitch = (ListView) rootView.findViewById(R.id.homeTeamPitchBox);
        homeListPitch.setAdapter(homeAdapterPitch);
        */
        TextView homeName = (TextView) rootView.findViewById(R.id.homeTeamNameBox);
        homeName.setText(game.m_home.m_teamName);
        TextView visName = (TextView) rootView.findViewById(R.id.visTeamNameBox);
        visName.setText(game.m_away.m_teamName);
        TextView homeNamePitch = (TextView) rootView.findViewById(R.id.homeTeamNamePitchBox);
        homeNamePitch.setText(game.m_home.m_teamName);
        TextView visNamePitch = (TextView) rootView.findViewById(R.id.visTeamNamePitchBox);
        visNamePitch.setText(game.m_away.m_teamName);

        TableLayout visHittingLayout = (TableLayout) rootView.findViewById(R.id.visHitStats);

        //TableRow.LayoutParams parameterLength = new TableRow.LayoutParams();
        //parameterLength.span = 6;

        TableRow dataDisplayedHittingVis = new TableRow(getActivity());

        TextView playerNameVis = new TextView(getActivity());
        playerNameVis.setText("Name");
        TextView playerAtBatsVis = new TextView(getActivity());
        playerAtBatsVis.setText("AB");
        TextView playerHitsVis = new TextView(getActivity());
        playerHitsVis.setText("H");
        TextView playerRunsVis = new TextView(getActivity());
        playerRunsVis.setText("R");
        TextView playerRBIVis = new TextView(getActivity());
        playerRBIVis.setText("RBI");
        TextView playerWalksVis = new TextView(getActivity());
        playerWalksVis.setText("BB");
        TextView playerStrikeOutsVis = new TextView(getActivity());
        playerStrikeOutsVis.setText("SO");



        dataDisplayedHittingVis.addView(playerNameVis);
        dataDisplayedHittingVis.addView(playerAtBatsVis);
        dataDisplayedHittingVis.addView(playerHitsVis);
        dataDisplayedHittingVis.addView(playerRunsVis);
        dataDisplayedHittingVis.addView(playerRBIVis);
        dataDisplayedHittingVis.addView(playerWalksVis);
        dataDisplayedHittingVis.addView(playerStrikeOutsVis);

        visHittingLayout.addView(dataDisplayedHittingVis);
        for(int i = 0; i < visPlayers.size(); i++) {
            TableRow playerDisplayed = new TableRow(getActivity());

            TextView thisPlayerName = new TextView(getActivity());
            thisPlayerName.setText(visPlayers.get(i).m_lastName);
            TextView thisPlayerAtBats = new TextView(getActivity());
            thisPlayerAtBats.setText(visPlayers.get(i).stats.m_atBats + "");
            TextView thisPlayerHits = new TextView(getActivity());
            thisPlayerHits.setText(visPlayers.get(i).stats.m_hits + "");
            TextView thisPlayerRuns = new TextView(getActivity());
            thisPlayerRuns.setText(visPlayers.get(i).stats.m_runs+ "");
            TextView thisPlayerRBI = new TextView(getActivity());
            thisPlayerRBI.setText(visPlayers.get(i).stats.m_runsBattedIn + "");
            TextView thisPlayerWalks = new TextView(getActivity());
            thisPlayerWalks.setText(visPlayers.get(i).stats.m_walks + "");
            TextView thisPlayerStrikeOuts = new TextView(getActivity());
            thisPlayerStrikeOuts.setText(visPlayers.get(i).stats.m_strikeouts + "");

            playerDisplayed.addView(thisPlayerName);
            playerDisplayed.addView(thisPlayerAtBats);
            playerDisplayed.addView(thisPlayerHits);
            playerDisplayed.addView(thisPlayerRuns);
            playerDisplayed.addView(thisPlayerRBI);
            playerDisplayed.addView(thisPlayerWalks);
            playerDisplayed.addView(thisPlayerStrikeOuts);

            visHittingLayout.addView(playerDisplayed);
        }

        TableLayout homeHittingLayout = (TableLayout) rootView.findViewById(R.id.homeHitStats);

        //TableRow.LayoutParams parameterLength = new TableRow.LayoutParams();
        //parameterLength.span = 6;

        TableRow dataDisplayedHittingHome = new TableRow(getActivity());

        TextView playerNameHome = new TextView(getActivity());
        playerNameHome.setText("Name");
        TextView playerAtBatsHome = new TextView(getActivity());
        playerAtBatsHome.setText("At Bats");
        TextView playerHitsHome = new TextView(getActivity());
        playerHitsHome.setText("Hits");
        TextView playerRunsHome = new TextView(getActivity());
        playerRunsHome.setText("R");
        TextView playerRBIHome = new TextView(getActivity());
        playerRBIHome.setText("RBI");
        TextView playerWalksHome = new TextView(getActivity());
        playerWalksHome.setText("BB");
        TextView playerStrikeOutsHome = new TextView(getActivity());
        playerStrikeOutsHome.setText("SO");

        dataDisplayedHittingHome.addView(playerNameHome);
        dataDisplayedHittingHome.addView(playerAtBatsHome);
        dataDisplayedHittingHome.addView(playerHitsHome);
        dataDisplayedHittingHome.addView(playerRunsHome);
        dataDisplayedHittingHome.addView(playerRBIHome);
        dataDisplayedHittingHome.addView(playerWalksHome);
        dataDisplayedHittingHome.addView(playerStrikeOutsHome);

        homeHittingLayout.addView(dataDisplayedHittingHome);
        for(int i = 0; i < homePlayers.size(); i++) {
            TableRow playerDisplayed = new TableRow(getActivity());

            TextView thisPlayerName = new TextView(getActivity());
            thisPlayerName.setText(homePlayers.get(i).m_lastName);
            TextView thisPlayerAtBats = new TextView(getActivity());
            thisPlayerAtBats.setText(homePlayers.get(i).stats.m_atBats + "");
            TextView thisPlayerHits = new TextView(getActivity());
            thisPlayerHits.setText(homePlayers.get(i).stats.m_hits + "");
            TextView thisPlayerRuns = new TextView(getActivity());
            thisPlayerRuns.setText(homePlayers.get(i).stats.m_runs+ "");
            TextView thisPlayerRBI = new TextView(getActivity());
            thisPlayerRBI.setText(homePlayers.get(i).stats.m_runsBattedIn + "");
            TextView thisPlayerWalks = new TextView(getActivity());
            thisPlayerWalks.setText(homePlayers.get(i).stats.m_walks + "");
            TextView thisPlayerStrikeOuts = new TextView(getActivity());
            thisPlayerStrikeOuts.setText(homePlayers.get(i).stats.m_strikeouts + "");

            playerDisplayed.addView(thisPlayerName);
            playerDisplayed.addView(thisPlayerAtBats);
            playerDisplayed.addView(thisPlayerHits);
            playerDisplayed.addView(thisPlayerRuns);
            playerDisplayed.addView(thisPlayerRBI);
            playerDisplayed.addView(thisPlayerWalks);
            playerDisplayed.addView(thisPlayerStrikeOuts);

            homeHittingLayout.addView(playerDisplayed);
        }

        TableLayout visPitchingLayout = (TableLayout) rootView.findViewById(R.id.visPitchStats);

        //TableRow.LayoutParams parameterLength = new TableRow.LayoutParams();
        //parameterLength.span = 6;

        TableRow dataDisplayedPitchingVis = new TableRow(getActivity());

        TextView playerNamePitchingVis = new TextView(getActivity());
        playerNamePitchingVis.setText("Name");
        TextView playerInningsPitchingVis = new TextView(getActivity());
        playerInningsPitchingVis.setText("IP");
        TextView playerHitsPitchingVis = new TextView(getActivity());
        playerHitsPitchingVis.setText("H");
        TextView playerRunsPitchingVis = new TextView(getActivity());
        playerRunsPitchingVis.setText("R");
        TextView playerWalksPitchingVis = new TextView(getActivity());
        playerWalksPitchingVis.setText("BB");
        TextView playerStrikeOutsPitchingVis = new TextView(getActivity());
        playerStrikeOutsPitchingVis.setText("SO");
        TextView playerHomeRunsPitchingVis = new TextView(getActivity());
        playerHomeRunsPitchingVis.setText("HR");



        dataDisplayedPitchingVis.addView(playerNamePitchingVis);
        dataDisplayedPitchingVis.addView(playerInningsPitchingVis);
        dataDisplayedPitchingVis.addView(playerHitsPitchingVis);
        dataDisplayedPitchingVis.addView(playerRunsPitchingVis);
        dataDisplayedPitchingVis.addView(playerWalksPitchingVis);
        dataDisplayedPitchingVis.addView(playerStrikeOutsPitchingVis);
        dataDisplayedPitchingVis.addView(playerHomeRunsPitchingVis);


        visPitchingLayout.addView(dataDisplayedPitchingVis);
        for(int i = 0; i < visPlayers.size(); i++) {
            if(visPlayers.get(i).m_positionArray == 0) {
                TableRow playerDisplayed = new TableRow(getActivity());

                TextView thisPlayerName = new TextView(getActivity());
                thisPlayerName.setText(visPlayers.get(i).m_lastName);
                TextView thisPlayerInnings = new TextView(getActivity());
                thisPlayerInnings.setText(visPlayers.get(i).stats.m_innings + "");
                TextView thisPlayerHits = new TextView(getActivity());
                thisPlayerHits.setText(visPlayers.get(i).stats.m_hitsGiven + "");
                TextView thisPlayerRuns = new TextView(getActivity());
                thisPlayerRuns.setText(visPlayers.get(i).stats.m_runsGiven + "");
                TextView thisPlayerWalks = new TextView(getActivity());
                thisPlayerWalks.setText(visPlayers.get(i).stats.m_walksGiven + "");
                TextView thisPlayerStrikeOuts = new TextView(getActivity());
                thisPlayerStrikeOuts.setText(visPlayers.get(i).stats.m_strikeoutsGiven + "");
                TextView thisPlayerHomeRuns = new TextView(getActivity());
                thisPlayerHomeRuns.setText(visPlayers.get(i).stats.m_homerunsGiven + "");

                playerDisplayed.addView(thisPlayerName);
                playerDisplayed.addView(thisPlayerInnings);
                playerDisplayed.addView(thisPlayerHits);
                playerDisplayed.addView(thisPlayerRuns);
                playerDisplayed.addView(thisPlayerWalks);
                playerDisplayed.addView(thisPlayerStrikeOuts);
                playerDisplayed.addView(thisPlayerHomeRuns);

                visPitchingLayout.addView(playerDisplayed);
            }
        }

        TableLayout homePitchingLayout = (TableLayout) rootView.findViewById(R.id.homePitchStats);

        //TableRow.LayoutParams parameterLength = new TableRow.LayoutParams();
        //parameterLength.span = 6;

        TableRow dataDisplayedPitchingHome = new TableRow(getActivity());

        TextView playerNamePitchingHome = new TextView(getActivity());
        playerNamePitchingHome.setText("Name");
        TextView playerInningsPitchingHome = new TextView(getActivity());
        playerInningsPitchingHome.setText("IP");
        TextView playerHitsPitchingHome = new TextView(getActivity());
        playerHitsPitchingHome.setText("H");
        TextView playerRunsPitchingHome = new TextView(getActivity());
        playerRunsPitchingHome.setText("R");
        TextView playerWalksPitchingHome = new TextView(getActivity());
        playerWalksPitchingHome.setText("BB");
        TextView playerStrikeOutsPitchingHome = new TextView(getActivity());
        playerStrikeOutsPitchingHome.setText("SO");
        TextView playerHomeRunsPitchingHome = new TextView(getActivity());
        playerHomeRunsPitchingHome.setText("HR");

        dataDisplayedPitchingHome.addView(playerNamePitchingHome);
        dataDisplayedPitchingHome.addView(playerInningsPitchingHome);
        dataDisplayedPitchingHome.addView(playerHitsPitchingHome);
        dataDisplayedPitchingHome.addView(playerRunsPitchingHome);
        dataDisplayedPitchingHome.addView(playerWalksPitchingHome);
        dataDisplayedPitchingHome.addView(playerStrikeOutsPitchingHome);
        dataDisplayedPitchingHome.addView(playerHomeRunsPitchingHome);

        homePitchingLayout.addView(dataDisplayedPitchingHome);
        for(int i = 0; i < homePlayers.size(); i++) {
            if(homePlayers.get(i).m_positionArray == 0) {
                TableRow playerDisplayed = new TableRow(getActivity());

                TextView thisPlayerName = new TextView(getActivity());
                thisPlayerName.setText(homePlayers.get(i).m_lastName);
                TextView thisPlayerInnings = new TextView(getActivity());
                thisPlayerInnings.setText(homePlayers.get(i).stats.m_innings + "");
                TextView thisPlayerHits = new TextView(getActivity());
                thisPlayerHits.setText(homePlayers.get(i).stats.m_hitsGiven + "");
                TextView thisPlayerRuns = new TextView(getActivity());
                thisPlayerRuns.setText(homePlayers.get(i).stats.m_runsGiven + "");
                TextView thisPlayerWalks = new TextView(getActivity());
                thisPlayerWalks.setText(homePlayers.get(i).stats.m_walksGiven + "");
                TextView thisPlayerStrikeOuts = new TextView(getActivity());
                thisPlayerStrikeOuts.setText(homePlayers.get(i).stats.m_strikeoutsGiven + "");
                TextView thisPlayerHomeRuns = new TextView(getActivity());
                thisPlayerHomeRuns.setText(homePlayers.get(i).stats.m_homerunsGiven + "");

                playerDisplayed.addView(thisPlayerName);
                playerDisplayed.addView(thisPlayerInnings);
                playerDisplayed.addView(thisPlayerHits);
                playerDisplayed.addView(thisPlayerRuns);
                playerDisplayed.addView(thisPlayerWalks);
                playerDisplayed.addView(thisPlayerStrikeOuts);
                playerDisplayed.addView(thisPlayerHomeRuns);

                homePitchingLayout.addView(playerDisplayed);
            }
        }


        return rootView;
    }

}
