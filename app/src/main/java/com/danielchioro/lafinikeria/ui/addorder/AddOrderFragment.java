package com.danielchioro.lafinikeria.ui.addorder;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Food;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AddOrderFragment extends Fragment  implements AddOrderNavigator{

    private AddOrderViewModel mViewModel;

    public static AddOrderFragment newInstance() {
        return new AddOrderFragment();
    }

    private RecyclerView mFoodRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private Button addOrderButton;
    private TextView totalCount;
    private TextView itemCount;
    private float mTotalCount;
    private int mItemCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_order_fragment, container, false);
        mFoodRecyclerView = view.findViewById(R.id.food_recyclerView);
        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(getContext());
        mFoodRecyclerView.setLayoutManager(linearLayout);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddOrderViewModel.class);
        mViewModel.navigator = this;
        addOrderButton = getActivity().findViewById(R.id.addOrder_button);
        itemCount = getActivity().findViewById(R.id.noTacos_textView);
        totalCount = getActivity().findViewById(R.id.totalCount_textView);
        mViewModel.retriveOrders();
    }

    @Override
    public void onDataRetrieve(List<Food> items) {
        mAdapter = new AddOrderRecyclerViewAdapter(items, new AddOrderRecyclerViewAdapter.AgregarFood() {
            @Override
            public void onAgregarFood(float price) {
                mTotalCount += price;
                mItemCount ++;
                itemCount.setText("No. de Tacos " + mItemCount);
                totalCount.setText("Total: "+ mTotalCount +" MXN");
                Log.w(TAG, "The price is: " );
            }
        });
        mFoodRecyclerView.setAdapter(mAdapter);
    }
}
