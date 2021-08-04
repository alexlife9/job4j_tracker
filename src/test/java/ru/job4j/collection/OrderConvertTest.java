package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Dress"));
        orders.add(new Order("1", "Face"));
        orders.add(new Order("2", "Code"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("1"), is(new Order("1", "Face")));
        assertThat(map.get("2"), is(new Order("2", "Code")));
    }
}
