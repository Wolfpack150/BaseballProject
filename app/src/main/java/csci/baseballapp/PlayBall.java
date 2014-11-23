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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


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

        //receivePrevExtras = getIntent().getBundleExtra("prevExtras");
        /*
        String inningsString = receivePrevExtras.getString("NumberInnings");
        int innings = Integer.parseInt(inningsString);
        */
        //TextView displayInning = (TextView) findViewById(R.id.inningsView);
        //displayInning.setText("Innings: " + homeTeam.m_teamName);
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
    public void showDialog(View view){
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
                        pitchListener1(i);
                    }
                });

                return alertDialogBuilder.create();
            }

        }
        PitchDialogFragment pitchDialog = new PitchDialogFragment();
        pitchDialog.show(getFragmentManager(), "Pitch Dialog");
    }
    private void pitchListener1(int result) {
        switch (result) {
            case 0:
                game.incrementBall();
                updateGameView();
                break;
            case 1:
                game.incrementStrike();
                updateGameView();
                break;
            case 2:
                game.foulball();
                updateGameView();
                break;
            case 3:
                break;
            case 4:
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
    }
}

