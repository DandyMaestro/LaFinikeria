package com.danielchioro.lafinikeria.ui.addorder;

import com.danielchioro.lafinikeria.models.Food;
import java.util.List;

public interface AddOrderNavigator {
    void onDataRetrieve(List<Food> items);
    void onOrderCreated();
}
