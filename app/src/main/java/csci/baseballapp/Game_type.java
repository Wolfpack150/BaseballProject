package csci.baseballapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tim on 9/18/14.
 */

public class Game_type extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_type);
        getActionBar().setDisplayHomeAsUpEnabled(true);



    }
        /*
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Game_type.this, team_lineups.class);
                startActivity(intent);
            }
        });*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotoLineup(View view) {
        EditText homeTeamName, visitorTeamName, numberInnings;

        homeTeamName = (EditText) findViewById(R.id.homeNameInput);
        visitorTeamName = (EditText) findViewById(R.id.visNameInput);
        numberInnings = (EditText) findViewById(R.id.visNameInput);

        String homeName, visName, gameInnings;
        homeName = String.valueOf(homeTeamName.getText());
        visName = String.valueOf(visitorTeamName.getText());
        gameInnings = String.valueOf(numberInnings.getText());

        Intent goToCreateLineup = new Intent(this, team_lineups.class);
        goToCreateLineup.putExtra("HomeTeamName", homeName);
        goToCreateLineup.putExtra("VisitorTeamName", visName);
        goToCreateLineup.putExtra("NumberInnings", gameInnings);

        setResult(RESULT_OK, goToCreateLineup);
    }
}