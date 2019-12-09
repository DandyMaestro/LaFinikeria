package com.danielchioro.lafinikeria.ui.home;

import android.util.Log;

import com.danielchioro.lafinikeria.models.Food;
import com.danielchioro.lafinikeria.models.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static android.content.ContentValues.TAG;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    HomeViewNavigator navigator;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    void retriveOrders() {
        DatabaseReference myRef = mDatabase.child("orders");
        final List<Order> orders = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot postData : dataSnapshot.getChildren()) {
                    Order order = postData.getValue(Order.class);
                    orders.add(order);
                }
                navigator.onOrdersRetrived(orders);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}