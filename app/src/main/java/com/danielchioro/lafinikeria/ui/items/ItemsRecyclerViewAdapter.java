package com.danielchioro.lafinikeria.ui.items;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_item, parent, false);
        ItemsRecyclerViewAdapter.mViewHolder vh = new ItemsRecyclerViewAdapter.mViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.description.setText(items.get(position).getDescription());
        holder.price.setText("Precio " + items.get(position).getPrice() + "  MXN");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;

        public mViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.item_recyclerView_item_name_textView);
            description = view.findViewById(R.id.item_recyclerView_item_description_textView);
            price = view.findViewById(R.id.item_recyclerView_item_price_textView);
        }
    }

}
