package csci.baseballapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tim on 9/18/14.
 */

public class Game_type extends Activity {

    EditText homeTeamName, visitorTeamName, numberInnings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_type);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        homeTeamName = (EditText) findViewById(R.id.homeNameInput);
        visitorTeamName = (EditText) findViewById(R.id.visNameInput);
        numberInnings = (EditText) findViewById(R.id.visNameInput);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Game_type.this, team_lineups.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setGametype (View v)
    {
        Gameplay game = new Gameplay();
        Team homeTeam = new Team();
        Team visitorTeam = new Team();

        //Intent intent = new Intent();
        //This gets the data from an EditText field
        String homeName = homeTeamName.getText().toString();
        homeTeam.setTeamName(homeName);
        //intent.putExtra("Home", homeName);
        String visitorName = visitorTeamName.getText().toString();
        //intent.putExtra("Visitor", visitorName);
        visitorTeam.setTeamName(visitorName);
        int innings = Integer.parseInt(numberInnings.getText().toString());
        //intent.putExtra("Innings",innings);
        game.m_numInnings = innings;

        //setResult(RESULT_OK, intent);
        finish();
    }

}