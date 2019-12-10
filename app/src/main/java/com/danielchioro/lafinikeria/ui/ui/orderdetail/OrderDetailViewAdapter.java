package com.danielchioro.lafinikeria.ui.ui.orderdetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Food;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class OrderDetailViewAdapter extends RecyclerView.Adapter<OrderDetailViewAdapter.mViewHolder> {

    private List<Food> items;

    public OrderDetailViewAdapter(List<Food> detail) {
        items = detail;
    }

    @NonNull
    @Override
    public OrderDetailViewAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_orderdetail_detail, parent, false);
        mViewHolder vh = new mViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        final int mPosition = position;

        holder.name.setText(items.get(position).getName());
        holder.description.setText(items.get(position).getDescription());
        holder.price.setText(items.get(position).getPrice() + "MXN");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class mViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView description;
        public TextView price;

        public mViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_orderdetail_textView);
            description = view.findViewById(R.id.description_orderdetail_textView);
            price = view.findViewById(R.id.price_orderdetail_textView);
        }
    }
}
