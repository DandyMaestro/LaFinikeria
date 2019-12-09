package com.danielchioro.lafinikeria.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Order;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderRecylerViewAdapter extends RecyclerView.Adapter<OrderRecylerViewAdapter.mViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<Order> items;

    public OrderRecylerViewAdapter(List<Order> items) {
        this.items = items;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView description;
        public TextView ammount;

        public mViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.orders_id_textView);
            description = view.findViewById(R.id.orders_description_textView);
            ammount = view.findViewById(R.id.orders_ammount_textView);
        }
    }

    @NonNull
    @Override
    public OrderRecylerViewAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_orders_detail, parent, false);
        mViewHolder vh = new mViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.id.setText(items.get(position).getOrderId());
        holder.description.setText(items.get(position).getDetail());
        holder.ammount.setText("Total "+items.get(position).getAmmount()+"  MXN");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface Callback {
        void callback();
    }
}
