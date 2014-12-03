package csci.baseballapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class TeamLineupVisitor extends ListActivity {

    private static final int REQUEST_CODE = 100;
    private static final int EDIT_R_CODE = 150;
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
        //Players.add(new Player("Test", "PlayerV", "69", "C", "S", "L"));
        Players.add(new Player("Gregor", "Blanco", "7", "CF", "L", "L", 7));
        Players.add(new Player("Joe", "Panik", "12", "2B", "L", "R", 3));
        Players.add(new Player("Buster", "Posey", "28", "C", "R", "R", 1));
        Players.add(new Player("Pablo", "Sandoval", "48", "3B", "S", "R", 4));
        Players.add(new Player("Hunter", "Pence", "8", "RF", "R", "R", 8));
        Players.add(new Player("Brandon", "Belt", "9", "1B", "L", "L", 2));
        Players.add(new Player("Travis", "Ishikawa", "45", "LF", "L", "L", 6));
        Players.add(new Player("Brandon", "Crawford", "35", "SS", "L", "R", 5));
        Players.add(new Player("Madison", "Bumgarner", "40", "P", "L", "L", 0));
        setListAdapter(adapter);

        receivePrevExtras = getIntent().getBundleExtra("prevExtras");
        homeTeam = (Team) getIntent().getSerializableExtra("HomeTeamClass");
        visName = receivePrevExtras.getString("VisitorTeamName");
        TextView visNameTextView = (TextView) findViewById(R.id.visTeamName);
        visNameTextView.setText("Visitor Team: " + visName);
        Button gameButton = (Button) findViewById(R.id.goToGameButton);
        gameButton.setText("Finish " + visName + " lineup");
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // process click on item #position
        Player item = (Player) l.getItemAtPosition(position);
        Intent intent = new Intent(TeamLineupVisitor.this, EditPlayer.class);
        intent.putExtra("PlayerInfo",(java.io.Serializable) item);
        intent.putExtra("ListPos" ,position);
        startActivityForResult(intent, EDIT_R_CODE);
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
    public void CreateNewPlayer (View view){
        Intent intent = new Intent(TeamLineupVisitor.this, player_create.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDIT_R_CODE && resultCode == RESULT_OK)
        {
            String FirstName = data.getStringExtra("FirstN");
            String LastName = data.getStringExtra("LastN");
            String Pnumber = data.getStringExtra("Num");
            String Position = data.getStringExtra("pos");
            String Bats  = data.getStringExtra("Bats");
            String Hits = data.getStringExtra("Hits");
            int PositionArr = data.getIntExtra("posnum",0);
            Player editP = new Player(FirstName,LastName,Pnumber,Position,Bats,Hits,PositionArr);
            Players.set(data.getIntExtra("ListPosition",0),editP);
            adapter.notifyDataSetChanged();
        }

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //get the data and save it to a new object
            //push the new object to an array
            String FirstName = data.getStringExtra("FirstN");
            String LastName = data.getStringExtra("LastN");
            String Pnumber = data.getStringExtra("Num");
            String Position = data.getStringExtra("pos");
            String Bats  = data.getStringExtra("Bats");
            String Hits = data.getStringExtra("Hits");
            int PositionArr = data.getIntExtra("posnum",0);
            //do the test thing
            Toast.makeText(this,
                    "added "+ FirstName + " " + LastName +
                            " pos: " + Position + " Bats " + Bats + " Hits: " + Hits,
                    Toast.LENGTH_LONG).show();
            Players.add(new Player(FirstName, LastName, Pnumber, Position, Bats, Hits,PositionArr));
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