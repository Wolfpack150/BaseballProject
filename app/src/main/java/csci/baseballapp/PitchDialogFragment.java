package csci.baseballapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by lumpy on 11/20/14.
 */
public class PitchDialogFragment extends DialogFragment {
    Context mContext;
    public PitchDialogFragment() {
        mContext = getActivity();
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        //alertDialogBuilder.setTitle("Really?");
        //alertDialogBuilder.setMessage("Are you sure?");
        //null should be your on click listener
        alertDialogBuilder.setPositiveButton("OK", null);
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        return alertDialogBuilder.create();
    }
}