package csci.baseballapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PitchByPitchFragment extends Fragment {
    Gameplay game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pitch_by_pitch, container, false);
        Bundle args = getArguments();
        game = (Gameplay) args.getSerializable("gameBundleKey");

        // Text views to populate upper bar of the fragment


        TextView visName = (TextView) rootView.findViewById(R.id.visName);
        visName.setText(game.m_away.m_teamName);
        TextView homeName = (TextView) rootView.findViewById(R.id.homeName);
        homeName.setText(game.m_home.m_teamName);
        TextView inningType = (TextView) rootView.findViewById(R.id.innTypeView);
        inningType.setText(game.inningToString());
        TextView currentInning = (TextView) rootView.findViewById(R.id.innCurrView);
        currentInning.setText(String.valueOf((int) game.m_inning));
        TextView homeScore = (TextView) rootView.findViewById(R.id.homeScore);
        homeScore.setText(String.valueOf(game.m_home_score));
        TextView visScore = (TextView) rootView.findViewById(R.id.visScore);
        visScore.setText(String.valueOf(game.m_away_score));
        TextView ballCount = (TextView) rootView.findViewById(R.id.ballCountView);
        ballCount.setText(String.valueOf(game.m_balls));
        TextView strikeCount = (TextView) rootView.findViewById(R.id.strikeCountView);
        strikeCount.setText(String.valueOf(game.m_strikes));
        TextView outCount = (TextView) rootView.findViewById(R.id.outCountView);
        outCount.setText(String.valueOf(game.m_outs));

        Button currHitter = (Button) rootView.findViewById(R.id.currHitterButton);
        currHitter.setText("At Bat:\n" + game.m_hitter.m_firstName + " " + game.m_hitter.m_lastName + " " + game.m_hitter.m_number + "\nBats: " + game.m_hitter.m_bats);
        Button onDeckHitter = (Button) rootView.findViewById(R.id.onDeckHitterButton);
        onDeckHitter.setText("On Deck:\n" + game.m_onDeck.m_firstName + " " + game.m_onDeck.m_lastName + " " + game.m_onDeck.m_number + "\nBats: " + game.m_onDeck.m_bats);
        Button inHoleHitter = (Button) rootView.findViewById(R.id.inTheHoleHitterButton);
        inHoleHitter.setText("In The Hole:\n" + game.m_inHole.m_firstName + " " + game.m_inHole.m_lastName + " " + game.m_inHole.m_number + "\nBats: " + game.m_inHole.m_bats);

        Button currPitcher = (Button) rootView.findViewById(R.id.currPitcherButton);
        currPitcher.setText("Pitcher:\n" + game.m_pitcher.m_firstName + " " + game.m_pitcher.m_lastName + " " + game.m_pitcher.m_number + "\nThrows: " + game.m_pitcher.m_throws);
        TextView pitchCount = (TextView) rootView.findViewById(R.id.pitchCountView);
        pitchCount.setText("Pitch\nCount: ");
        TextView pitchCountAmount = (TextView) rootView.findViewById(R.id.pitchCountAmountView);
        pitchCountAmount.setText(String.valueOf(game.m_pitcher.stats.m_pitchesThrown));

        if(game.basePosition[1] != null){
            Button firstBaseButton = (Button) rootView.findViewById(R.id.firstBaseButton);
            firstBaseButton.setBackgroundColor(Color.BLUE);
        }
        else {
            Button firstBaseButton = (Button) rootView.findViewById(R.id.firstBaseButton);
            firstBaseButton.setBackgroundColor(Color.WHITE);
        }
        if(game.basePosition[2] != null){
            Button secondBaseButton = (Button) rootView.findViewById(R.id.secondBaseButton);
            secondBaseButton.setBackgroundColor(Color.BLUE);
        }
        else{
            Button secondBaseButton = (Button) rootView.findViewById(R.id.secondBaseButton);
            secondBaseButton.setBackgroundColor(Color.WHITE);
        }
        if(game.basePosition[3] != null){
            Button thirdBaseButton = (Button) rootView.findViewById(R.id.thirdBaseButton);
            thirdBaseButton.setBackgroundColor(Color.BLUE);
        }
        else{
            Button thirdBaseButton = (Button) rootView.findViewById(R.id.thirdBaseButton);
            thirdBaseButton.setBackgroundColor(Color.WHITE);
        }

        TextView pitcherName = (TextView) rootView.findViewById(R.id.pitcherText);
        pitcherName.setText(game.m_home.searchPlayer("P"));
        TextView catcherName = (TextView) rootView.findViewById(R.id.catcherText);
        catcherName.setText(game.m_home.searchPlayer("C"));
        TextView firstBaseName = (TextView) rootView.findViewById(R.id.fbText);
        firstBaseName.setText(game.m_home.searchPlayer("1B"));
        TextView secondBaseName = (TextView) rootView.findViewById(R.id.sbText);
        secondBaseName.setText(game.m_home.searchPlayer("2B"));
        TextView thirdBaseName = (TextView) rootView.findViewById(R.id.tbText);
        thirdBaseName.setText(game.m_home.searchPlayer("3B"));
        TextView shortStopName = (TextView) rootView.findViewById(R.id.ssText);
        shortStopName.setText(game.m_home.searchPlayer("SS"));
        TextView leftFieldName = (TextView) rootView.findViewById(R.id.lfText);
        leftFieldName.setText(game.m_home.searchPlayer("LF"));
        TextView centerFieldName = (TextView) rootView.findViewById(R.id.cfText);
        centerFieldName.setText(game.m_home.searchPlayer("CF"));
        TextView rightFieldName = (TextView) rootView.findViewById(R.id.rfText);
        rightFieldName.setText(game.m_home.searchPlayer("RF"));
        
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



}

