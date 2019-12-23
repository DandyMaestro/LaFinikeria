package com.danielchioro.lafinikeria.ui.items;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.danielchioro.lafinikeria.models.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItemsViewModel extends ViewModel {
    ItemsNavigator navigator;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    
    // TODO: Implement the ViewModel
    public void getStoreItems() {
        DatabaseReference myRef = mDatabase.child("foods");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Food> items = new ArrayList<>();
                for(DataSnapshot postData : dataSnapshot.getChildren()) {
                    Food foodItem = postData.getValue(Food.class);
                    items.add(foodItem);
                }
                navigator.drawItems(items);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                navigator.showErrorMessage(databaseError.toString());
            }
        });
    }
}
