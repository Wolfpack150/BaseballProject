package csci.baseballapp;

import android.app.Activity;
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
import android.widget.ListAdapter;
import android.widget.Toast;

import org.apache.http.auth.AuthSchemeRegistry;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;


public class TeamLineupHome extends ListActivity {

    private static final int REQUEST_CODE = 100;
    private static final int EDIT_R_CODE=150;
    List<Player> Players = new Player().getPlayers();
    ArrayAdapter<Player> adapter;
    Bundle receivePrevExtras;
    String homeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_lineup_home);
        adapter = new ArrayAdapter<Player>
                    (this, android.R.layout.simple_list_item_1, Players);

        //Players.add(new Player("Test", "PlayerH", "69", "C", "S", "L"));
        Players.add(new Player(1,"Dee", "Gordon", "9", "2B", "L", "R", 3));
        Players.add(new Player(1,"Yasiel", "Puig", "66", "CF", "R", "R", 7));
        Players.add(new Player(1,"Adrian", "Gonzalez", "23", "1B", "L", "L", 2));
        Players.add(new Player(1,"Matt", "Kemp", "27", "RF", "R", "R", 8));
        Players.add(new Player(1,"Hanley", "Ramirez", "13", "SS", "R", "R", 5));
        Players.add(new Player(1,"Carl", "Crawford", "3", "LF", "L", "L", 6));
        Players.add(new Player(1,"Juan", "Uribe", "5", "3B", "R", "R", 4));
        Players.add(new Player(1,"A.J.", "Ellis", "17", "C", "R", "R", 1));
        Players.add(new Player(1,"Clayton", "Kershaw", "22", "P", "L", "L", 0));
        setListAdapter(adapter);

        receivePrevExtras = getIntent().getExtras();
        homeName = receivePrevExtras.getString("HomeTeamName");
        TextView homeNameTextView = (TextView) findViewById(R.id.homeTeamName);
        homeNameTextView.setText("Home Team: " + homeName);
        Button nextLineupButton = (Button) findViewById(R.id.visTeamButton);
        nextLineupButton.setText("Finish " + homeName + " lineup");
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // process click on item #position
        Player item = (Player) l.getItemAtPosition(position);
        Intent intent = new Intent(TeamLineupHome.this, EditPlayer.class);
        intent.putExtra("PlayerInfo",(java.io.Serializable) item);
        intent.putExtra("ListPos" ,position);
        startActivityForResult(intent,EDIT_R_CODE);
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
        Intent intent = new Intent(TeamLineupHome.this, player_create.class);
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
            Player editP = new Player(1,FirstName,LastName,Pnumber,Position,Bats,Hits,PositionArr);
            Players.set(data.getIntExtra("ListPosition",0),editP);
            adapter.notifyDataSetChanged(); //important
        }
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //get the data and save it to a new object
            //push the new object to an array
            String FirstName = data.getStringExtra("FirstN");
            String LastName  = data.getStringExtra("LastN");
            String Pnumber   = data.getStringExtra("Num");
            String Position  = data.getStringExtra("pos");
            String Bats      = data.getStringExtra("Bats");
            String Hits      = data.getStringExtra("Hits");
            int positionNum  = data.getIntExtra("posnum",0);
            //do the test thing
            Toast.makeText(this,
                "added "+ FirstName + " " + LastName +
                " pos: " + Position + " Bats " + Bats + " Hits: " + Hits,
            Toast.LENGTH_LONG).show();
            Players.add(new Player(1,FirstName, LastName, Pnumber, Position, Bats, Hits,positionNum));
            adapter.notifyDataSetChanged();
        }
    }

    public void goToVisitorLineup(View view) {
        Team homeTeam = new Team(homeName, Players, Players.size());

        Intent goToCreateVisitorLineup = new Intent(this, TeamLineupVisitor.class);
        goToCreateVisitorLineup.putExtra("prevExtras", receivePrevExtras);
        goToCreateVisitorLineup.putExtra("HomeTeamClass", (java.io.Serializable) homeTeam);
        startActivity(goToCreateVisitorLineup);
    }
}
