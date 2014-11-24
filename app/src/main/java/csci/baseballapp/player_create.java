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
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class player_create extends Activity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //populates the postion spinner using "Positions" string array
        setContentView(R.layout.activity_player_create);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, Positions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //watches the Spinner's selection in real time and adds the final selection to return intent

        RadioButton R1 = (RadioButton) findViewById(R.id.radioButtonR);
        R1.setSelected(true);
        RadioButton RH = (RadioButton) findViewById(R.id.radioButtonHR);
        RH.setSelected(true);
        RadioButton RL = (RadioButton) findViewById(R.id.radioButtonHL);
        RL.setSelected(false);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                        String pos = spinner.getSelectedItem().toString();
                        intent.putExtra("pos", pos);
                        //Toast.makeText
                        // (getApplicationContext(), "You have selected " + pos, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // Do nothing you silly
                    }

                }
        );
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View view = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (view instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            if (event.getAction() == MotionEvent.ACTION_UP
                    && (x < w.getLeft() || x >= w.getRight()
                    || y < w.getTop() || y > w.getBottom()) ) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }

}
