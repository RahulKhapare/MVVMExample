package com.rak_developer.mvvm_example.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.rak_developer.mvvm_example.R;
import com.rak_developer.mvvm_example.databinding.ActivityLoginBinding;
import com.rak_developer.mvvm_example.model.LoginViewModel;
import com.rak_developer.mvvm_example.util.ShowToast;

public class LoginActivity extends AppCompatActivity {


    private LoginActivity activity = this;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // ViewModel updates the Model
        // after observing changes in the View

        // model will also update the view
        // via the ViewModel
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel(new LoginViewModel());
        binding.executePendingBindings();
    }

    // any change in toastMessage attribute
    // defined on the Button with bind prefix
    // invokes this method
    @BindingAdapter({"toastMessage"})
    public static void toastMessage(View view, String message) {
        if (message != null) {
            ShowToast.show(view.getContext(),message);
        }
    }

    //
    @BindingAdapter({"alertMessage"})
    public static void alertMessage(View view, String message) {
        if (message != null) {
            showAlert(view, message);
        }
    }

    private static void showAlert(View view, String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
        builder1.setMessage(message);
        builder1.setCancelable(false);
        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}