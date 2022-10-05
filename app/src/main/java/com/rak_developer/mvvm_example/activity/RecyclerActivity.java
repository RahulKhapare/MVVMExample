package com.rak_developer.mvvm_example.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rak_developer.mvvm_example.R;
import com.rak_developer.mvvm_example.adapter.RecyclerViewAdapter;
import com.rak_developer.mvvm_example.databinding.ActivityRecyclerBinding;
import com.rak_developer.mvvm_example.model.UserModel;
import com.rak_developer.mvvm_example.model.UserModelView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements LifecycleOwner {

    private RecyclerActivity activity = this;
    private ActivityRecyclerBinding binding;

    private UserModelView viewModel;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setNestedScrollingEnabled(false);
        adapter = new RecyclerViewAdapter();
        binding.recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(activity).get(UserModelView.class);
        viewModel.getUserMutableLiveData().observe(activity, userListUpdateObserver);

    }

    Observer<ArrayList<UserModel>> userListUpdateObserver = new Observer<ArrayList<UserModel>>() {
        @Override
        public void onChanged(ArrayList<UserModel> userArrayList) {
//            binding.recyclerView.updateUserList(userArrayList);
            adapter.updateUserList(userArrayList);
        }
    };
}