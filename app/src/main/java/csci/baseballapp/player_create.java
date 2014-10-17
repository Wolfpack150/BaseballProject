package csci.baseballapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class player_create extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //populates the postion spinner using strings.xml defined strings
        setContentView(R.layout.activity_player_create);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.position_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.player_create, menu);
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

    public void ReturnPlayer (View v)
    {
        Intent intent = new Intent();
        //This gets the data from an EditText field
        EditText et = (EditText) findViewById(R.id.editText);
        String Fname = et.getText().toString();
        intent.putExtra("FirstN", Fname);

        EditText et2 = (EditText) findViewById(R.id.editText2);
        String Lname = et2.getText().toString();
        intent.putExtra("LastN", Lname);

        EditText et3 = (EditText) findViewById(R.id.editText3);
        String Number = et3.getText().toString();
        intent.putExtra("Num",Number);

        setResult(RESULT_OK, intent);
        finish();
    }

}
