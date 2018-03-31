package com.android.andi.mytrip.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.andi.mytrip.utils.ProgressSpinner;

/**
 * Created by Andi Xu on 3/30/18.
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressSpinner mProgress;

    public void showProgress() {
        if (!isFinishing()) {
            if (mProgress != null && mProgress.isShowing()) {
                mProgress.dismiss();
            }
            mProgress = ProgressSpinner.show(this, "", "");
            mProgress.setCancelable(true);
            mProgress.setCanceledOnTouchOutside(false);
        }
    }

    public void dismissProgress() {
        try {
            if (!isFinishing() && mProgress != null && mProgress.isShowing()) {
                mProgress.dismiss();
            }
            mProgress = null;
        } catch (Exception e) {

        }
    }

    public void showErrorToast(Context context, String error) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }

    public void showOkAlert(Context context, String title, String message, String btnText) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, btnText,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
