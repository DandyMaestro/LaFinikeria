package com.danielchioro.lafinikeria.ui.addorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Food;
import com.danielchioro.lafinikeria.models.Order;
import com.danielchioro.lafinikeria.ui.home.OrderRecylerViewAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddOrderRecyclerViewAdapter extends RecyclerView.Adapter<AddOrderRecyclerViewAdapter.mViewHolder>  {

    private List<Food> foodItems;
    private AgregarFood mAddFoodAction;

    public AddOrderRecyclerViewAdapter(List<Food> items, AgregarFood a) {
        this.mAddFoodAction = a;
        this.foodItems = items;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_addorder_detail, parent, false);
        AddOrderRecyclerViewAdapter.mViewHolder vh = new AddOrderRecyclerViewAdapter.mViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        final int mPosition = position;
        holder.name.setText(foodItems.get(position).getName());
        holder.description.setText(foodItems.get(position).getDescription());
        holder.price.setText("Precio " + foodItems.get(position).getPrice() + "  MXN");
        holder.addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddFoodAction.onAgregarFood(foodItems.get(mPosition).getPrice(), foodItems.get(mPosition));
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView description;
        public TextView price;
        public Button addFood;

        public mViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.foodname_textView);
            description = view.findViewById(R.id.fooddescription_textView);
            price = view.findViewById(R.id.foodprice_textView);
            addFood = view.findViewById(R.id.addfood_button);
        }
    }

    public interface AgregarFood {
        void onAgregarFood(float price, Food item);
    }

}
