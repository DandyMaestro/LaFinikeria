package com.danielchioro.lafinikeria.ui.items;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Food;
import com.danielchioro.lafinikeria.ui.addorder.AddOrderRecyclerViewAdapter;

import java.util.List;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.mViewHolder> {

    private List<Food> items;

    public ItemsRecyclerViewAdapter(List<Food> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        public mViewHolder(View view) {
            super(view);

        }
    }

}
