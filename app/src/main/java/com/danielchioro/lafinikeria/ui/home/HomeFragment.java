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

public class HomeFragment extends Fragment {

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

        List<Order> items = new ArrayList<Order>();
        Order item1 = new Order("1", "chiles", "23");
        Order item2 = new Order("2", "tacos de pastor", "32");
        items.add(item1);
        items.add(item2);
        mAdapter = new OrderRecylerViewAdapter(items);
        mOrdersRecycler.setAdapter(mAdapter);
    }
}