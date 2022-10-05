package com.rak_developer.mvvm_example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionMainModel {

    @SerializedName("IsSuccess")
    @Expose
    private boolean IsSuccess;

    @SerializedName("ErrorMessage")
    @Expose
    private String ErrorMessage;

    @SerializedName("ResponseMessage")
    @Expose
    private String ResponseMessage;

    @SerializedName("Param1")
    @Expose
    private boolean Param1;

    @SerializedName("Data")
    @Expose
    private List<DataOneModel> Data = null;

    public boolean isSuccess() {
        return IsSuccess;
    }

    public void setSuccess(boolean success) {
        IsSuccess = success;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }

    public boolean isParam1() {
        return Param1;
    }

    public void setParam1(boolean param1) {
        Param1 = param1;
    }

    public List<DataOneModel> getData() {
        return Data;
    }

    public void setData(List<DataOneModel> data) {
        Data = data;
    }
}
