package com.rak_developer.mvvm_example.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.rak_developer.mvvm_example.R;
import com.rak_developer.mvvm_example.adapter.MovieListAdapter;
import com.rak_developer.mvvm_example.adapter.RecyclerViewAdapter;
import com.rak_developer.mvvm_example.databinding.ActivityRecyclerRetrofitBinding;
import com.rak_developer.mvvm_example.model.MovieModel;
import com.rak_developer.mvvm_example.model.MovieViewModel;
import com.rak_developer.mvvm_example.util.ShowToast;

import java.util.List;

import retrofit2.Call;

public class RecyclerRetrofitActivity extends AppCompatActivity implements MovieListAdapter.ItemClickListener {

    private RecyclerRetrofitActivity activity = this;
    private ActivityRecyclerRetrofitBinding binding;

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_retrofit);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setNestedScrollingEnabled(false);
        adapter = new MovieListAdapter(this, movieModelList, this);
        binding.recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if (movieModels != null) {
                    movieModelList = movieModels;
                    adapter.setMovieList(movieModels);
                    binding.txError.setVisibility(View.GONE);
                } else {
                    binding.txError.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCall();

    }

    @Override
    public void onMovieClick(MovieModel movie) {
        ShowToast.show(activity, "Clicked Movie Name is : " + movie.getTitle());
    }
}