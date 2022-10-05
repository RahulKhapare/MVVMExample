package com.rak_developer.mvvm_example.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rak_developer.mvvm_example.R;
import com.rak_developer.mvvm_example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivity activity = this;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnExampleOne.setText("Login Page Example");
        binding.btnExampleTwo.setText("Recycler Example");
        binding.btnExampleThree.setText("Recycler (Retrofit) Example");
        binding.btnExampleFour.setText("Realm Data Example");
        binding.btnExampleFive.setText("Room Database Example");

        binding.btnExampleOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.btnExampleTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RecyclerActivity.class);
                startActivity(intent);
            }
        });

        binding.btnExampleThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RecyclerRetrofitActivity.class);
                startActivity(intent);
            }
        });

        binding.btnExampleFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DummyActivity.class);
                startActivity(intent);
            }
        });

    }
}