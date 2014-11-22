package csci.baseballapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by lumpy on 11/20/14.
 */
public class PitchDialogFragment extends DialogFragment {
    public PitchDialogFragment() {}
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        //alertDialogBuilder.setTitle("Really?");
        //alertDialogBuilder.setMessage("Are you sure?");
        //null should be your on click listener
        alertDialogBuilder.setTitle("Pick");
        alertDialogBuilder.setItems(R.array.pitchList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Item was selected " + i, Toast.LENGTH_SHORT).show();
            }
        });
       /*
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Negative", Toast.LENGTH_SHORT).show();
                    }
            //dismiss
        });
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Positive", Toast.LENGTH_SHORT).show();
            }
            //dismiss
        });
        */



        return alertDialogBuilder.create();
    }
}