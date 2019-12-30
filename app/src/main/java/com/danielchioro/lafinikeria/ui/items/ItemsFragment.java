package com.danielchioro.lafinikeria.ui.items;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Canvas;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.models.Food;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static androidx.recyclerview.widget.ItemTouchHelper.LEFT;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;

public class ItemsFragment extends Fragment implements ItemsNavigator {

    private ItemsViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdatper;
    private FloatingActionButton AddItemsButton;

    public static ItemsFragment newInstance() {
        return new ItemsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.items_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupFragment();
        mViewModel.getStoreItems();
    }

    private void setupFragment() {
        mRecyclerView = getActivity().findViewById(R.id.items_RecyclerView);
        RecyclerView.LayoutManager mManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);

        ItemsSwipeController swipeController = new ItemsSwipeController();
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(mRecyclerView);

        AddItemsButton = getActivity().findViewById(R.id.items_addItem_floatingActionButton);
        mViewModel = ViewModelProviders.of(this).get(ItemsViewModel.class);
        mViewModel.navigator = this;
    }

    @Override
    public void drawItems(List<Food> items) {
        mAdatper = new ItemsRecyclerViewAdapter(items);
        mRecyclerView.setAdapter(mAdatper);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }
}
