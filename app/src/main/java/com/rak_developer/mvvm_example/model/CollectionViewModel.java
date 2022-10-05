package com.rak_developer.mvvm_example.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rak_developer.mvvm_example.network.APIService;
import com.rak_developer.mvvm_example.network.RetroCallInstance;
import com.rak_developer.mvvm_example.network.RetroInstance;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionViewModel extends ViewModel {

    private MutableLiveData<ResponseBody> moviesList;

    public CollectionViewModel() {
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<ResponseBody> getMoviesListObserver() {
        return moviesList;
    }

    public void makeApiCall() {
        APIService apiService = RetroCallInstance.getRetroClient().create(APIService.class);
        Call<ResponseBody> call = apiService.getCollectionData("a232x0000036zFyAAI");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("TAG", "onResponseRetroOKSuccess: " + response.body().toString());
                moviesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("TAG", "onResponseRetroOKError: " + "null");
                moviesList.postValue(null);
            }
        });
    }
}

