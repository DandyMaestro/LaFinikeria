package com.danielchioro.lafinikeria.ui.home;

import com.danielchioro.lafinikeria.models.Order;
import java.util.List;

interface HomeViewNavigator {
    void onOrdersRetrived(List<Order> orders);
}
