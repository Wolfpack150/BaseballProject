package csci.baseballapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;


public class PlayBall extends Activity {
    Gameplay game;
    //Bundle receivePrevExtras;
    ActionBar.Tab GameTab, BoxTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ball);
        Team homeTeam = (Team) getIntent().getSerializableExtra("HomeTeamClass");
        Team visTeam = (Team) getIntent().getSerializableExtra("VisTeamClass");
        game = new Gameplay(homeTeam, visTeam, 9);
        Fragment gamefragmenttab = new PitchByPitchFragment();
        Bundle gameBundle = new Bundle();
        gameBundle.putSerializable("gameBundleKey", game);
        gamefragmenttab.setArguments(gameBundle);

        Fragment boxfragmenttab = new BoxFragment();
        //gamefragmenttab.setArguments(gameBundle);

        ActionBar gameplayBar = getActionBar();
        gameplayBar.setDisplayShowHomeEnabled(false);
        gameplayBar.setDisplayShowTitleEnabled(false);
        gameplayBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        GameTab = gameplayBar.newTab().setText("Game View");
        BoxTab = gameplayBar.newTab().setText("Box Score");

        GameTab.setTabListener(new TabListener(gamefragmenttab));
        BoxTab.setTabListener(new TabListener(boxfragmenttab));

        gameplayBar.addTab(GameTab);
        gameplayBar.addTab(BoxTab);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play_ball, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPitchDialog(View view){
        class PitchDialogFragment extends DialogFragment {
            public PitchDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Pitch resulted in a...");
                alertDialogBuilder.setItems(R.array.pitchList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        pitchListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        PitchDialogFragment pitchDialog = new PitchDialogFragment();
        pitchDialog.show(getFragmentManager(), "Pitch Dialog");
    }

    public void showPitchDialogRefined(){
        class PitchDialogFragment extends DialogFragment {
            public PitchDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Pitch resulted in a...");
                alertDialogBuilder.setItems(R.array.pitchList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        pitchListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        PitchDialogFragment pitchDialog = new PitchDialogFragment();
        pitchDialog.show(getFragmentManager(), "Pitch Dialog");
    }

    public void showInPlayDialog(){
        class InPlayDialogFragment extends DialogFragment {
            public InPlayDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Batter hit a...");
                alertDialogBuilder.setItems(R.array.inPlayList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        inPlayListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        InPlayDialogFragment inPlayDialog = new InPlayDialogFragment();
        inPlayDialog.show(getFragmentManager(), "In Play Dialog");
    }

    public void showSafeOutDialog(){
        class SafeOutDialogFragment extends DialogFragment {
            public SafeOutDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Batter was...");
                alertDialogBuilder.setItems(R.array.safeOutList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        safeOutListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        SafeOutDialogFragment safeOutDialog = new SafeOutDialogFragment();
        safeOutDialog.show(getFragmentManager(), "Safe Out Dialog");
    }

    public void showSafeDialog(){
        class SafeDialogFragment extends DialogFragment {
            public SafeDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("How did the batter get on base?");
                alertDialogBuilder.setItems(R.array.safeList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        safeListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        SafeDialogFragment safeDialog = new SafeDialogFragment();
        safeDialog.show(getFragmentManager(), "Safe Dialog");
    }

    public void showOtherDialogWithBall(){
        class OtherDialogFragmentBall extends DialogFragment {
            public OtherDialogFragmentBall() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Pitch resulted in a...");
                alertDialogBuilder.setItems(R.array.otherOptionsListBall, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        otherListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        OtherDialogFragmentBall otherDialogBall = new OtherDialogFragmentBall();
        otherDialogBall.show(getFragmentManager(), "Other Dialog With Ball");
    }

    public void showOtherDialogWithWalk(){
        class OtherDialogFragmentWalk extends DialogFragment {
            public OtherDialogFragmentWalk() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Pitch resulted in a...");
                alertDialogBuilder.setItems(R.array.otherOptionsListWalk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        otherListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        OtherDialogFragmentWalk otherDialogWalk = new OtherDialogFragmentWalk();
        otherDialogWalk.show(getFragmentManager(), "Other Dialog With Walk");
    }

    public void showBaseMoveFirstDialog(){
        class BaseMoveFirstDialogFragment extends DialogFragment {
            public BaseMoveFirstDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Runner moved from 1st to...");
                alertDialogBuilder.setItems(R.array.firstBaseList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        baseMoveFirstListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        BaseMoveFirstDialogFragment baseMoveFirstDialog = new BaseMoveFirstDialogFragment();
        baseMoveFirstDialog.show(getFragmentManager(), "Base Move First Dialog");
    }

    public void showBaseMoveSecondDialog(){
        class BaseMoveSecondDialogFragment extends DialogFragment {
            public BaseMoveSecondDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Runner moved from 2nd to...");
                alertDialogBuilder.setItems(R.array.secondBaseList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        baseMoveSecondListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        BaseMoveSecondDialogFragment baseMoveSecondDialog = new BaseMoveSecondDialogFragment();
        baseMoveSecondDialog.show(getFragmentManager(), "Base Move Second Dialog");
    }

    public void showBaseMoveSecondForceDialog(){
        class BaseMoveSecondForceDialogFragment extends DialogFragment {
            public BaseMoveSecondForceDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Runner moved from 2nd to...");
                alertDialogBuilder.setItems(R.array.secondBaseListForce, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        baseMoveSecondForceListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        BaseMoveSecondForceDialogFragment baseMoveSecondForceDialog = new BaseMoveSecondForceDialogFragment();
        baseMoveSecondForceDialog.show(getFragmentManager(), "Base Move Second Force Dialog");
    }

    public void showBaseMoveThirdDialog(){
        class BaseMoveThirdDialogFragment extends DialogFragment {
            public BaseMoveThirdDialogFragment() {}
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Runner moved from 3rd to...");
                alertDialogBuilder.setItems(R.array.thirdBaseList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
                        baseMoveThirdListener(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        BaseMoveThirdDialogFragment baseMoveThirdDialog = new BaseMoveThirdDialogFragment();
        baseMoveThirdDialog.show(getFragmentManager(), "Base Move Third Dialog");
    }

    private void pitchListener(int result) {
        switch (result) {
            case 0:
                game.incrementBall();
                if(game.m_balls != 0) showPitchDialogRefined();
                else game.nextBatter();
                break;
            case 1:
                game.incrementStrike();
                if(game.m_strikes != 0) showPitchDialogRefined();
                else game.nextBatter();
                break;
            case 2:
                game.foulball();
                showPitchDialogRefined();
                break;
            case 3:
                showInPlayDialog();
                break;
            case 4:
                if(game.m_balls != 3)
                showOtherDialogWithBall();
                else showOtherDialogWithWalk();
                break;
        }
        updateGameView();
    }

    private void inPlayListener(int result) {
        switch (result) {
            case 0: case 1: case 2: case 3: case 4:
                showSafeOutDialog();
                break;
        }
    }

    private void safeOutListener(int result) {
        switch (result) {
            case 0:
                showSafeDialog();
                break;
            case 1:
                // ask where out was
                game.incrementOut();
                updateGameView();
                break;
        }
    }

    private void safeListener(int result) {
        switch (result) {
            case 0:
                askWheretoMove();
                game.singles();
                game.nextBatter();
                updateGameView();
                break;
            case 1:
                askWheretoMove();
                game.doubles();
                game.nextBatter();
                updateGameView();
                break;
            case 2:
                askWheretoMove();
                game.triples();
                game.nextBatter();
                updateGameView();
                break;
            case 3:
                game.homeruns();
                game.nextBatter();
                updateGameView();
                break;
            case 4:
                //askWheretoMove();
                game.error();
                game.nextBatter();
                updateGameView();
                break;
            case 5:
                //fielders choice
                break;
        }
    }



    private void otherListener(int result) {
        switch (result) {
            case 0:
                game.incrementIntentionalBall();
                updateGameView();
                if(game.m_balls != 0) showPitchDialogRefined();
                break;
            case 1:
                game.hitByPitch();
                game.nextBatter();
                updateGameView();
                break;
            case 2:
                // catchers interference
                game.nextBatter();
                updateGameView();
                break;
            case 3:
                game.balk();
                break;
        }
    }

    private void baseMoveFirstListener(int result) {
        switch (result) {
            case 0:
                game.move(game.basePosition[1], 1, 2);
                updateGameView();
                break;
            case 1:
                game.move(game.basePosition[1], 1, 3);
                updateGameView();
                break;
            case 2:
                game.move(game.basePosition[1], 1, 4);
                updateGameView();
                break;
        }
    }

    private void baseMoveSecondListener(int result) {
        switch (result) {
            case 0:
                // Should not move // game.move(game.basePosition[2], 2, 2);
                updateGameView();
                break;
            case 1:
                game.move(game.basePosition[2], 2, 3);
                updateGameView();
                break;
            case 2:
                game.move(game.basePosition[2], 2, 4);
                updateGameView();
                break;
        }
    }

    private void baseMoveSecondForceListener(int result) {
        switch (result) {
            case 0:
                game.move(game.basePosition[2], 2, 3);
                updateGameView();
                break;
            case 1:
                game.move(game.basePosition[2], 2, 4);
                updateGameView();
                break;
        }
    }

    private void baseMoveThirdListener(int result) {
        switch (result) {
            case 0:
                // should not move // game.move(game.basePosition[3], 3, 3);
                updateGameView();
                break;
            case 1:
                game.move(game.basePosition[3], 3, 4);
                updateGameView();
                break;
        }
    }

    private void updateGameView(){
        TextView visName = (TextView) findViewById(R.id.visName);
        visName.setText(game.m_away.m_teamName);
        TextView homeName = (TextView) findViewById(R.id.homeName);
        homeName.setText(game.m_home.m_teamName);
        TextView inningType = (TextView) findViewById(R.id.innTypeView);
        inningType.setText(game.inningToString());
        TextView currentInning = (TextView) findViewById(R.id.innCurrView);
        currentInning.setText(String.valueOf((int) game.m_inning));
        TextView homeScore = (TextView) findViewById(R.id.homeScore);
        homeScore.setText(String.valueOf(game.m_home_score));
        TextView visScore = (TextView) findViewById(R.id.visScore);
        visScore.setText(String.valueOf(game.m_away_score));
        TextView ballCount = (TextView) findViewById(R.id.ballCountView);
        ballCount.setText(String.valueOf(game.m_balls));
        TextView strikeCount = (TextView) findViewById(R.id.strikeCountView);
        strikeCount.setText(String.valueOf(game.m_strikes));
        TextView outCount = (TextView) findViewById(R.id.outCountView);
        outCount.setText(String.valueOf(game.m_outs));

        Button currHitter = (Button) findViewById(R.id.currHitterButton);
        currHitter.setText("At Bat:\n" + game.m_hitter.m_firstName + " " + game.m_hitter.m_lastName + " " + game.m_hitter.m_number);
        Button onDeckHitter = (Button) findViewById(R.id.onDeckHitterButton);
        onDeckHitter.setText("On Deck:\n");// + game.m_hitter.m_firstName + " " + game.m_hitter.m_lastName + " " + game.m_hitter.m_number);
        Button inHoleHitter = (Button) findViewById(R.id.inTheHoleHitterButton);
        inHoleHitter.setText("In The Hole:\n");// + game.m_hitter.m_firstName + " " + game.m_hitter.m_lastName + " " + game.m_hitter.m_number);

        Button currPitcher = (Button) findViewById(R.id.currPitcherButton);
        currPitcher.setText("Pitcher:\n" + game.m_pitcher.m_firstName + " " + game.m_pitcher.m_lastName + " " + game.m_pitcher.m_number);
        TextView pitchCountAmount = (TextView) findViewById(R.id.pitchCountAmountView);
        pitchCountAmount.setText(String.valueOf(game.m_pitcher.stats.m_pitchesThrown));

        Button firstBaseButton = (Button) findViewById(R.id.firstBaseButton);
        firstBaseButton.setBackgroundColor(Color.WHITE);
        Button secondBaseButton = (Button) findViewById(R.id.secondBaseButton);
        secondBaseButton.setBackgroundColor(Color.WHITE);
        Button thirdBaseButton = (Button) findViewById(R.id.thirdBaseButton);
        thirdBaseButton.setBackgroundColor(Color.WHITE);

        if(game.basePosition[1] != null)
            firstBaseButton.setBackgroundColor(Color.BLUE);
        else
            firstBaseButton.setBackgroundColor(Color.WHITE);

        if(game.basePosition[2] != null)
            secondBaseButton.setBackgroundColor(Color.BLUE);
        else
            secondBaseButton.setBackgroundColor(Color.WHITE);

        if(game.basePosition[3] != null)
            thirdBaseButton.setBackgroundColor(Color.BLUE);
        else
            thirdBaseButton.setBackgroundColor(Color.WHITE);
        if(game.m_inningtype == 0) {
            TextView pitcherName = (TextView) findViewById(R.id.pitcherText);
            pitcherName.setText(game.m_home.searchPlayer("P"));
            TextView catcherName = (TextView) findViewById(R.id.catcherText);
            catcherName.setText(game.m_home.searchPlayer("C"));
            TextView firstBaseName = (TextView) findViewById(R.id.fbText);
            firstBaseName.setText(game.m_home.searchPlayer("1B"));
            TextView secondBaseName = (TextView) findViewById(R.id.sbText);
            secondBaseName.setText(game.m_home.searchPlayer("2B"));
            TextView thirdBaseName = (TextView) findViewById(R.id.tbText);
            thirdBaseName.setText(game.m_home.searchPlayer("3B"));
            TextView shortStopName = (TextView) findViewById(R.id.ssText);
            shortStopName.setText(game.m_home.searchPlayer("SS"));
            TextView leftFieldName = (TextView) findViewById(R.id.lfText);
            leftFieldName.setText(game.m_home.searchPlayer("LF"));
            TextView centerFieldName = (TextView) findViewById(R.id.cfText);
            centerFieldName.setText(game.m_home.searchPlayer("CF"));
            TextView rightFieldName = (TextView) findViewById(R.id.rfText);
            rightFieldName.setText(game.m_home.searchPlayer("RF"));
        }
        else {
            TextView pitcherName = (TextView) findViewById(R.id.pitcherText);
            pitcherName.setText(game.m_away.searchPlayer("P"));
            TextView catcherName = (TextView) findViewById(R.id.catcherText);
            catcherName.setText(game.m_away.searchPlayer("C"));
            TextView firstBaseName = (TextView) findViewById(R.id.fbText);
            firstBaseName.setText(game.m_away.searchPlayer("1B"));
            TextView secondBaseName = (TextView) findViewById(R.id.sbText);
            secondBaseName.setText(game.m_away.searchPlayer("2B"));
            TextView thirdBaseName = (TextView) findViewById(R.id.tbText);
            thirdBaseName.setText(game.m_away.searchPlayer("3B"));
            TextView shortStopName = (TextView) findViewById(R.id.ssText);
            shortStopName.setText(game.m_away.searchPlayer("SS"));
            TextView leftFieldName = (TextView) findViewById(R.id.lfText);
            leftFieldName.setText(game.m_away.searchPlayer("LF"));
            TextView centerFieldName = (TextView) findViewById(R.id.cfText);
            centerFieldName.setText(game.m_away.searchPlayer("CF"));
            TextView rightFieldName = (TextView) findViewById(R.id.rfText);
            rightFieldName.setText(game.m_away.searchPlayer("RF"));
        }
    }

    public void askWheretoMove() {
        for (int i = 3; i > 0; i--) {
            if (game.basePosition[i] != null) {
                switch (i) {
                    case 3:
                        //if (game.basePosition[1] != null && game.basePosition[2] != null)
                        //    game.move(game.basePosition[3],3,4);
                        //else
                        showBaseMoveThirdDialog();
                        break;
                    case 2:
                        if (game.basePosition[1] != null)
                            showBaseMoveSecondForceDialog();
                        else
                            showBaseMoveSecondDialog();
                        break;
                    case 1:
                        showBaseMoveFirstDialog();
                        break;
                 }
            }
            updateGameView();
        }
    }


}

