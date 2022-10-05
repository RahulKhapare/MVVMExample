package com.rak_developer.mvvm_example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataTwoModel {

    @SerializedName("Id")
    @Expose
    private String Id;

    @SerializedName("Protocol_Type")
    @Expose
    private String Protocol_Type;

    @SerializedName("Protocol_Action")
    @Expose
    private String Protocol_Action;

    @SerializedName("Input_Type")
    @Expose
    private String Input_Type;

    @SerializedName("IsMandatory")
    @Expose
    private boolean IsMandatory;

    @SerializedName("IsImageRequired")
    @Expose
    private boolean IsImageRequired;

    @SerializedName("SequenceNo")
    @Expose
    private int SequenceNo;

    @SerializedName("Created_By")
    @Expose
    private String Created_By;

    @SerializedName("Creared_On")
    @Expose
    private String Creared_On;

    @SerializedName("Protocol_Seq")
    @Expose
    private int Protocol_Seq;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProtocol_Type() {
        return Protocol_Type;
    }

    public void setProtocol_Type(String protocol_Type) {
        Protocol_Type = protocol_Type;
    }

    public String getProtocol_Action() {
        return Protocol_Action;
    }

    public void setProtocol_Action(String protocol_Action) {
        Protocol_Action = protocol_Action;
    }

    public String getInput_Type() {
        return Input_Type;
    }

    public void setInput_Type(String input_Type) {
        Input_Type = input_Type;
    }

    public boolean isMandatory() {
        return IsMandatory;
    }

    public void setMandatory(boolean mandatory) {
        IsMandatory = mandatory;
    }

    public boolean isImageRequired() {
        return IsImageRequired;
    }

    public void setImageRequired(boolean imageRequired) {
        IsImageRequired = imageRequired;
    }

    public int getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        SequenceNo = sequenceNo;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public String getCreared_On() {
        return Creared_On;
    }

    public void setCreared_On(String creared_On) {
        Creared_On = creared_On;
    }

    public int getProtocol_Seq() {
        return Protocol_Seq;
    }

    public void setProtocol_Seq(int protocol_Seq) {
        Protocol_Seq = protocol_Seq;
    }
}
