package com.danielchioro.lafinikeria.ui.addorder;

import android.provider.ContactsContract;
import android.util.Log;

import com.danielchioro.lafinikeria.models.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


import androidx.lifecycle.ViewModel;

import static android.content.ContentValues.TAG;
import static java.lang.System.in;

public class AddOrderViewModel extends ViewModel {

    public AddOrderNavigator navigator;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef = mDatabase.child("foods");

    void retriveOrders() {
        final List<Food> food = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot postData : dataSnapshot.getChildren()) {
                    Food foodItem = postData.getValue(Food.class);
                    food.add(foodItem);
                }
                    navigator.onDataRetrieve(food);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
