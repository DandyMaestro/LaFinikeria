package com.danielchioro.lafinikeria.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.ui.ui.orderdetail.OrderDetailFragment;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OrderDetailFragment.newInstance())
                    .commitNow();
        }
    }
}
