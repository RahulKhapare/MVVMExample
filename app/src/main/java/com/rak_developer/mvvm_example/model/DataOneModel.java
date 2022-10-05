package com.rak_developer.mvvm_example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataOneModel {

    @SerializedName("Key")
    @Expose
    private String Key;

    @SerializedName("Data")
    @Expose
    private List<DataTwoModel> Data = null;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public List<DataTwoModel> getData() {
        return Data;
    }

    public void setData(List<DataTwoModel> data) {
        Data = data;
    }
}
