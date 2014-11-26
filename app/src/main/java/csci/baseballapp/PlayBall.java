package csci.baseballapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
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
                alertDialogBuilder.setTitle("Pick");
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
                alertDialogBuilder.setTitle("Pick");
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
                alertDialogBuilder.setTitle("Pick");
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
                alertDialogBuilder.setTitle("Pick");
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
                alertDialogBuilder.setTitle("Pick");
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
                alertDialogBuilder.setTitle("Pick");
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
                alertDialogBuilder.setTitle("Pick");
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

    private void pitchListener(int result) {
        switch (result) {
            case 0:
                game.incrementBall();
                if(game.m_balls != 0) showPitchDialogRefined();
                else game.nextBatter();
                updateGameView();
                break;
            case 1:
                game.incrementStrike();
                if(game.m_strikes != 0) showPitchDialogRefined();
                else game.nextBatter();
                updateGameView();
                break;
            case 2:
                game.foulball();
                updateGameView();
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
                game.singles();
                break;
            case 1:
                game.doubles();
                break;
            case 2:
                game.triples();
                break;
            case 3:
                game.homeruns();
                break;
            case 4:
                game.error();
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
                break;
            case 2:
                // catchers interference
                break;
            case 3:
                game.balk();
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
        currHitter.setText(game.m_hitter.m_firstName + " " + game.m_hitter.m_lastName + " " + game.m_hitter.m_number);
        Button currPitcher = (Button) findViewById(R.id.currPitcherButton);
        currPitcher.setText(game.m_pitcher.m_firstName + " " + game.m_pitcher.m_lastName + " " + game.m_pitcher.m_number);
    }
}

