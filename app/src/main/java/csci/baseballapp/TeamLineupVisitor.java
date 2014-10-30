package csci.baseballapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class TeamLineupVisitor extends ListActivity {

    private static final int REQUEST_CODE = 100;
    List<Player> Players = new Player().getPlayers();
    ArrayAdapter<Player> adapter;
    Bundle receivePrevExtras = getIntent().getBundleExtra();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_lineup_visitor);
        adapter = new ArrayAdapter<Player>
                (this, android.R.layout.simple_list_item_1, Players);
        Players.add(new Player("Test", "Player", "69", "C", "S", "L"));
        setListAdapter(adapter);

        receivePrevExtras = getIntent().getExtras();
        String visName = receivePrevExtras.getString("VisitorTeamName");
        TextView visNameTextView = (TextView) findViewById(R.id.visTeamName);
        visNameTextView.setText("Visitor Team: " + visName);
        Button gameButton = (Button) findViewById(R.id.goToGameButton);
        gameButton.setText("Finish " + visName + " lineup");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.team_lineups, menu);
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
    //this guy opens the creates the player activity expecting a result returned from it
    public void CreateNewPlayer (MenuItem m){
        Intent intent = new Intent(TeamLineupVisitor.this, player_create.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}