package com.danielchioro.lafinikeria.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Order;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeViewNavigator {

    private HomeViewModel homeViewModel;
    private RecyclerView mOrdersRecycler;
    private RecyclerView.Adapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView.LayoutManager linerLayout = new LinearLayoutManager(getActivity());
        mOrdersRecycler = root.findViewById(R.id.orders_RecyclerView);
        mOrdersRecycler.setLayoutManager(linerLayout);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.navigator = this;
        homeViewModel.retriveOrders();
    }

    @Override
    public void onOrdersRetrived(List<Order> orders) {
        mAdapter = new OrderRecylerViewAdapter(orders);
        mOrdersRecycler.setAdapter(mAdapter);
    }
}