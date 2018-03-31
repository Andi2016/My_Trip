package com.android.andi.mytrip.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.andi.mytrip.R;

/**
 * Created by Andi Xu on 3/30/18.
 */

public class ProgressSpinner extends Dialog {

    public static ProgressSpinner show(Context context, CharSequence title,
                                       CharSequence message) {
        return show(context, title, message, false);
    }

    public static ProgressSpinner show(Context context, CharSequence title,
                                       boolean cancelable) {
        return show(context, cancelable);
    }

    public static ProgressSpinner show(Context context, CharSequence title,
                                       CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    public static ProgressSpinner show(Context context, CharSequence title,
                                       CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    public static ProgressSpinner show(Context context, CharSequence title,
                                       CharSequence message, boolean indeterminate,
                                       boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        ProgressSpinner dialog = new ProgressSpinner(context);
        dialog.setTitle(title);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(cancelListener);
            /* The next line will add the ProgressBar to the dialog. */
        dialog.addContentView(new ProgressBar(context), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        dialog.show();

        return dialog;
    }

    public static ProgressSpinner show(Context context, boolean cancelable) {
        ProgressSpinner dialog = new ProgressSpinner(context);
        dialog.setCancelable(cancelable);
            /* The next line will add the ProgressBar to the dialog. */
        dialog.addContentView(new ProgressBar(context), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        dialog.show();

        return dialog;
    }

    public ProgressSpinner(Context context) {
        super(context, R.style.ProgressSpinner);
    }
}
