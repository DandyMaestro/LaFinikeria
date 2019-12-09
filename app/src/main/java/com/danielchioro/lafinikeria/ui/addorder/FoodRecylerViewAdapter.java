package com.danielchioro.lafinikeria.ui.addorder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodRecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    public FoodRecylerViewAdapter(List<String> items, @Nullable Callback listener) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            description = description;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface Callback {
        void callback();
    }
}
