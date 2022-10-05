package com.rak_developer.mvvm_example.network;

import com.rak_developer.mvvm_example.model.CollectionMainModel;
import com.rak_developer.mvvm_example.model.MovieModel;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {


    @GET("volley_array.json")
    Call<List<MovieModel>> getMovieList();


    //    ComplaintProtocol/GetComplaintProtocolList?taskId=a232x0000036zFyAAI
    @GET("/ComplaintProtocol/GetComplaintProtocolList/{taskId}")
    void otp(@Path("taskId") String taskID,
             Callback<CollectionMainModel> callback);

    @GET("ComplaintProtocol/GetComplaintProtocolList")
    Call<ResponseBody> getCollectionData(@Query("taskId") String taskId);

}
