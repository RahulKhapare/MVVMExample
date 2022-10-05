package com.rak_developer.mvvm_example.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rak_developer.mvvm_example.R;
import com.rak_developer.mvvm_example.databinding.ActivityRecyclerListBgBinding;
import com.rak_developer.mvvm_example.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<UserModel> userArrayList;

    public RecyclerViewAdapter() {
        this.userArrayList = new ArrayList<UserModel>();
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityRecyclerListBgBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.activity_recycler_list_bg, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserModel model = userArrayList.get(position);
        holder.binding.txtTitle.setText(model.getTitle());
        holder.binding.txtDescription.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ActivityRecyclerListBgBinding binding;

        public ViewHolder(@NonNull ActivityRecyclerListBgBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void updateUserList(final ArrayList<UserModel> userArrayList) {
        this.userArrayList.clear();
        this.userArrayList = userArrayList;
        notifyDataSetChanged();
    }

}
