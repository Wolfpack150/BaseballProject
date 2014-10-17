package csci.baseballapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import org.apache.http.auth.AuthSchemeRegistry;

import java.util.ArrayList;
import java.util.List;


public class team_lineups extends ListActivity {

    private static final int REQUEST_CODE = 100;
    List<Player> Players = new Player().getPlayers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_lineups);

        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>
                    (this, android.R.layout.simple_list_item_1, Players);


        setListAdapter(adapter);

        Players.add(new Player("Test", "Player", "69", "C", 'S', 'L'));


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
        Intent intent = new Intent(team_lineups.this, player_create.class);
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
            Toast.makeText(this, "added "+ FirstName + " " + LastName, Toast.LENGTH_LONG).show();
        }
    }
}
