package com.danielchioro.lafinikeria.ui.addorder;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.danielchioro.lafinikeria.R;

import java.util.List;

public class AddOrderFragment extends Fragment {

    private AddOrderViewModel mViewModel;

    public static AddOrderFragment newInstance() {
        return new AddOrderFragment();
    }

    private RecyclerView mFoodRecyclerView;
    private Button addOrderButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mFoodRecyclerView = getActivity().findViewById(R.id.food_recyclerView);
        addOrderButton = getActivity().findViewById(R.id.addOrder_button);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        mFoodRecyclerView.setLayoutManager(layout);
        return inflater.inflate(R.layout.add_order_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddOrderViewModel.class);

        mFoodRecyclerView = getActivity().findViewById(R.id.food_recyclerView);
        addOrderButton = getActivity().findViewById(R.id.addOrder_button);

//        List<String> items = null;
//        mFoodRecyclerView.setAdapter(new FoodRecylerViewAdapter(items, new FoodRecylerViewAdapter.Callback() {
//            @Override
//            public void callback() {
//
//            }
//        }));
        // TODO: Use the ViewModel
    }

}
