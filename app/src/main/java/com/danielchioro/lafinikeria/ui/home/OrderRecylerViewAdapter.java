package com.danielchioro.lafinikeria.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Order;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderRecylerViewAdapter extends RecyclerView.Adapter<OrderRecylerViewAdapter.mViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<Order> items;

    public OrderRecylerViewAdapter(List<Order> items) {
        this.items = items;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView ammount;

        public mViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.orders_id_textView);
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
        Long currentMili = Long.parseLong(items.get(position).getOrderId());
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date orderDate = new Date(currentMili*1000);
        holder.id.setText(sdf.format(orderDate));
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
