package csci.baseballapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


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

}
