package com.danielchioro.lafinikeria.ui.items;

import com.danielchioro.lafinikeria.models.Food;

import java.util.List;

public interface ItemsNavigator {
    void drawItems(List<Food> items);
    void showErrorMessage(String message);
}
