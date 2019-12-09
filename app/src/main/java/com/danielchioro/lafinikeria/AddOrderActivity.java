package com.danielchioro.lafinikeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.danielchioro.lafinikeria.ui.addorder.AddOrderFragment;

public class AddOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_order_activity);
        if (savedInstanceState == null) {
            
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddOrderFragment.newInstance())
                    .commitNow();
        }
    }
}
