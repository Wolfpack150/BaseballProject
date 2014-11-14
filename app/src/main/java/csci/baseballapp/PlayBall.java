package csci.baseballapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


public class PlayBall extends Activity {
    Gameplay game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ball);

        Bundle receivePrevExtras = getIntent().getBundleExtra("prevExtras");
        /*
        String inningsString = receivePrevExtras.getString("NumberInnings");
        int innings = Integer.parseInt(inningsString);
        */
        Team homeTeam = (Team) getIntent().getSerializableExtra("HomeTeamClass");
        Team visTeam = (Team) getIntent().getSerializableExtra("VisTeamClass");
        TextView displayInning = (TextView) findViewById(R.id.inningsView);
        displayInning.setText("Innings: " + homeTeam.m_teamName);

        TabHost tabhost = (TabHost) findViewById(R.id.tabHost);
        tabhost.setup();

        TabHost.TabSpec tabSpec = tabhost.newTabSpec("playball");
        tabSpec.setContent(R.id.playBallTab);
        tabSpec.setIndicator("Gameplay");
        tabhost.addTab(tabSpec);

        tabSpec = tabhost.newTabSpec("boxscore");
        tabSpec.setContent(R.id.boxScoreTab);
        tabSpec.setIndicator("Box Score");
        tabhost.addTab(tabSpec);
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
