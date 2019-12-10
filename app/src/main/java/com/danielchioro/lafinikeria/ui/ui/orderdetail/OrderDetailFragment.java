package com.danielchioro.lafinikeria.ui.ui.orderdetail;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Food;

import java.util.List;

public class OrderDetailFragment extends Fragment {

    private OrderDetailViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private TextView mTotal;
    public static OrderDetailFragment newInstance() {
        return new OrderDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.order_detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OrderDetailViewModel.class);

        mRecyclerView = getActivity().findViewById(R.id.order_detail_fragment_recyclerView);
        mTotal = getActivity().findViewById(R.id.orderdetail_total_textView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        Intent intent = getActivity().getIntent();
        float total = intent.getFloatExtra("total", 0);
        mTotal.setText("Total " + total + " MXN");
        List<Food> detail = (List<Food>) intent.getSerializableExtra("details");
        mAdapter = new OrderDetailViewAdapter(detail);
        mRecyclerView.setAdapter(mAdapter);
        // TODO: Use the ViewModel
    }

}
