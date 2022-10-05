package com.rak_developer.mvvm_example.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.rak_developer.mvvm_example.R;
import com.rak_developer.mvvm_example.databinding.ActivityDummyBinding;
import com.rak_developer.mvvm_example.model.CollectionMainModel;
import com.rak_developer.mvvm_example.model.CollectionViewModel;
import com.rak_developer.mvvm_example.model.MovieModel;
import com.rak_developer.mvvm_example.model.MovieViewModel;
import com.rak_developer.mvvm_example.network.APIService;
import com.rak_developer.mvvm_example.network.RetroCallInstance;
import com.rak_developer.mvvm_example.network.RetroInstance;
import com.rak_developer.mvvm_example.util.ShowToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DummyActivity extends AppCompatActivity {

    private DummyActivity activity = this;
    private ActivityDummyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dummy);

        CollectionViewModel viewModel = ViewModelProviders.of(this).get(CollectionViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<ResponseBody>() {
            @Override
            public void onChanged(ResponseBody body) {
                if (body != null) {
                    ShowToast.show(activity, new Gson().toJson(body));
                } else {
                    ShowToast.show(activity, "Error");
                }
            }
        });
        viewModel.makeApiCall();

    }

}