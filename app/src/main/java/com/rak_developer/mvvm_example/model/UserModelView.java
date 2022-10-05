package com.rak_developer.mvvm_example.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rak_developer.mvvm_example.model.UserModel;

import java.util.ArrayList;

public class UserModelView extends ViewModel {

    MutableLiveData<ArrayList<UserModel>> userLiveData;
    ArrayList<UserModel> userArrayList;

    public UserModelView() {
        userLiveData = new MutableLiveData<>();
        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<UserModel>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init() {
        populateList();
        userLiveData.setValue(userArrayList);
    }

    public void populateList() {

        UserModel user = new UserModel();
        user.setTitle("Title");
        user.setDescription("here will be the description");

        userArrayList = new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);

    }
}
