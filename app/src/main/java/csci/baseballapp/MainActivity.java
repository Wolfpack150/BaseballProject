package csci.baseballapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoGame(View v){  //event handler that allows button
                                   //to move to next screen for game type

        Intent intent = new Intent(this, Game_type.class);
    startActivity(intent);
}
}
