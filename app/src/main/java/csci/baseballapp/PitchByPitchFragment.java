package csci.baseballapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PitchByPitchFragment extends Fragment {
    Gameplay game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pitch_by_pitch, container, false);
        Bundle args = getArguments();
        game = (Gameplay) args.getSerializable("gameBundleKey");

        // Text views to populate upper bar of the fragment


        TextView visName = (TextView) rootView.findViewById(R.id.visName);
        visName.setText(game.m_away.m_teamName);
        TextView homeName = (TextView) rootView.findViewById(R.id.homeName);
        homeName.setText(game.m_home.m_teamName);
        TextView inningType = (TextView) rootView.findViewById(R.id.innTypeView);
        inningType.setText(game.inningToString());
        TextView currentInning = (TextView) rootView.findViewById(R.id.innCurrView);
        currentInning.setText(String.valueOf((int) game.m_inning));
        TextView homeScore = (TextView) rootView.findViewById(R.id.homeScore);
        homeScore.setText(String.valueOf(game.m_home_score));
        TextView visScore = (TextView) rootView.findViewById(R.id.visScore);
        visScore.setText(String.valueOf(game.m_away_score));
        TextView ballCount = (TextView) rootView.findViewById(R.id.ballCountView);
        ballCount.setText(String.valueOf(game.m_balls));
        TextView strikeCount = (TextView) rootView.findViewById(R.id.strikeCountView);
        strikeCount.setText(String.valueOf(game.m_strikes));
        TextView outCount = (TextView) rootView.findViewById(R.id.outCountView);
        outCount.setText(String.valueOf(game.m_outs));
        Button pitchButton = (Button) rootView.findViewById(R.id.pitchButton1);
        /*pitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPitchOptions(view);

            }
            private void openPitchOptions(View view){
                //AlertDialog alertDialogBuilder = new PitchDialogFragment().show(getFragmentManager(), "MyDialog");
                DialogFragment df = new DialogFragment();
                df.getActivity();
                df.setCancelable(false);


            }
        });*/
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}

