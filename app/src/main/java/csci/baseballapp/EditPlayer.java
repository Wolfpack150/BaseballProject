package csci.baseballapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


public class EditPlayer extends Activity {
    Spinner spinner;
    Intent intent = new Intent();
    String[] Positions =
            {
                    "P",
                    "C",
                    "1B",
                    "2B",
                    "3B",
                    "SS",
                    "LF",
                    "CF",
                    "RF",
            };
    Player EditingPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, Positions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        int Arraypos = getIntent().getIntExtra("ListPos",0);
        int rosterpos= getIntent().getIntExtra("arrpos", 0);
        intent.putExtra("arrPosition",rosterpos);
        intent.putExtra("ListPosition", Arraypos);

        EditingPlayer = (Player) getIntent().getSerializableExtra("PlayerInfo");
        EditText FirstName = (EditText) findViewById(R.id.editText);
        FirstName.setText(EditingPlayer.m_firstName);

        EditText LirstName = (EditText) findViewById(R.id.editText2);
        LirstName.setText(EditingPlayer.m_lastName);

        EditText PlayerNumber = (EditText) findViewById(R.id.editText3);
        PlayerNumber.setText(EditingPlayer.m_number);

        spinner.setSelection(EditingPlayer.m_positionArray);

        RadioButton batL = (RadioButton) findViewById(R.id.radioButtonL);
        RadioButton batR = (RadioButton) findViewById(R.id.radioButtonR);
        RadioButton batS = (RadioButton) findViewById(R.id.radioButtonS);
        if(EditingPlayer.m_bats.charAt(0) == 'L') {
            batL.setSelected(true);
            //batL.setActivated(true);
            batL.setChecked(true);
            batS.setChecked(false);
            batR.setChecked(false);
        }
        if(EditingPlayer.m_bats.charAt(0) == 'R') {
            batR.setSelected(true);
            batR.setChecked(true);
            //batR.setActivated(true);
            batL.setChecked(false);
            batS.setChecked(false);
        }
        if (EditingPlayer.m_bats.charAt(0) == 'S') {
            batS.setSelected(true);
            batS.setChecked(true);
            //batS.setActivated(true);
            batL.setChecked(false);
            batR.setChecked(false);
        }

        RadioButton HitsR = (RadioButton) findViewById(R.id.radioButtonHR);
        RadioButton HitsL = (RadioButton) findViewById(R.id.radioButtonHL);

        if(EditingPlayer.m_throws.charAt(0) == 'R'){


            HitsL.setChecked(false);
            HitsR.setChecked(true);
            HitsR.setSelected(true);
            HitsL.setSelected(false);
        }
        if(EditingPlayer.m_throws.charAt(0) == 'L'){

            HitsR.setChecked(false);
            HitsL.setChecked(true);
            HitsL.setSelected(true);
            HitsR.setSelected(false);
        }



        //watches the Spinner's selection in real time and adds the final selection to return intent
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                        String pos = spinner.getSelectedItem().toString();
                        intent.putExtra("pos", pos);
                        intent.putExtra("posnum",arg2);
                        //Toast.makeText
                        // (getApplicationContext(), "You have selected " + pos, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // Do nothing you silly
                    }

                }
        );
        intent.putExtra("Bats", EditingPlayer.m_bats);
        intent.putExtra("Hits", EditingPlayer.m_throws);
    }

    public void BatsClick (View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        String bat = null;
        switch (view.getId())
        {

            case R.id.radioButtonL:
                if (checked)
                    bat = "L";
                intent.putExtra("Bats", bat);
                break;
            case R.id.radioButtonR:
                if (checked)
                    bat = "R";
                intent.putExtra("Bats", bat);
                break;
            case R.id.radioButtonS:
                if (checked)
                    bat = "S";
                intent.putExtra("Bats", bat);
                break;

        }
    }

    public void HitsClick (View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        String hit = null;
        switch (view.getId())
        {

            case R.id.radioButtonHR:
                if (checked)
                    hit = "R";
                intent.putExtra("Hits", hit);
                break;
            case R.id.radioButtonHL:
                if (checked)
                    hit = "L";
                intent.putExtra("Hits", hit);
                break;

        }
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