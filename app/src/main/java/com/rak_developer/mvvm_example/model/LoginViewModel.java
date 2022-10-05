package com.rak_developer.mvvm_example.model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.rak_developer.mvvm_example.BR;
import com.rak_developer.mvvm_example.model.LoginModel;

public class LoginViewModel extends BaseObservable {

    // creating object of Model class
    private LoginModel model;

    @Bindable
    // string variable for
    // toast message
    private String toastMessage = null;

    @Bindable
    private String alertMessage = null;

    // getter and setter methods
    // for toast message
    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    private void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
        notifyPropertyChanged(BR.alertMessage);
    }

    // getter and setter methods
    // for email variable
    @Bindable
    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserPassword() {
        return model.getPassword();
    }

    public void setUserPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    // constructor of ViewModel class
    public LoginViewModel() {
        // instantiating object of
        // model class
        model = new LoginModel("", "");
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onButtonClicked() {
        if (TextUtils.isEmpty(getUserEmail())) {
            setToastMessage("Enter email");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()) {
            setToastMessage("Email not valid");
        } else if (TextUtils.isEmpty(getUserPassword())) {
            setToastMessage("Enter password");
        } else if (getUserPassword().length() < 6) {
            setToastMessage("Enter 6 digit password");
        } else {
            setAlertMessage("Login successfully");
        }
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }

}
