package com.rak_developer.mvvm_example.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ShowToast {

    public static void show(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
