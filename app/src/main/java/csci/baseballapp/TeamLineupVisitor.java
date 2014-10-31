package csci.baseballapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class TeamLineupVisitor extends ListActivity {

    private static final int REQUEST_CODE = 100;
    List<Player> Players = new Player().getPlayers();
    ArrayAdapter<Player> adapter;
    Bundle receivePrevExtras;
    Team homeTeam;
    String visName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_lineup_visitor);
        adapter = new ArrayAdapter<Player>
                    (this, android.R.layout.simple_list_item_1, Players);
        Players.add(new Player("Test", "Player", "69", "C", "S", "L"));
        setListAdapter(adapter);

        receivePrevExtras = getIntent().getBundleExtra("prevExtras");
        homeTeam = (Team) getIntent().getSerializableExtra("HomeTeamClass");
        visName = receivePrevExtras.getString("VisitorTeamName");
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //get the data and save it to a new object
            //push the new object to an array
            String FirstName = data.getStringExtra("FirstN");
            String LastName = data.getStringExtra("LastN");
            String Pnumber = data.getStringExtra("Num");
            String Position = data.getStringExtra("pos");
            String Bats  = data.getStringExtra("Bats");
            String Hits = data.getStringExtra("Hits");
            //do the test thing
            Toast.makeText(this,
                    "added "+ FirstName + " " + LastName +
                            " pos: " + Position + " Bats " + Bats + " Hits: " + Hits,
                    Toast.LENGTH_LONG).show();
            Players.add(new Player(FirstName, LastName, Pnumber, Position, Bats, Hits));
            adapter.notifyDataSetChanged();
        }
    }

    public void goToGame(View view) {
        Team visTeam = new Team(visName, Players, Players.size());
        Intent goToPlayBall = new Intent(this, PlayBall.class);
        goToPlayBall.putExtra("Innings", receivePrevExtras);
        goToPlayBall.putExtra("HomeTeamClass", homeTeam);
        goToPlayBall.putExtra("VisTeamClass", visTeam);
        startActivity(goToPlayBall);
    }
}