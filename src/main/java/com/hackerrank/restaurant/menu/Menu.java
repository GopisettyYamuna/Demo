package com.hackerrank.restaurant.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.items.veg.VegBurger;

public class Menu {

    /**
     *
     * Menu static instance to access the menu
     */
    public static final Menu menu = new Menu();
    private final List<Item> items;
    private Menu() {
        this.items = new ArrayList<>();
    }

    /**
     *
     * @param item The item to check the availability for
     * @return Whether the item is available or not
     */
    public boolean isItemAvailable(Item item) {
    	 return items.contains(item);
    }
    public void addItem(Item item) {
        items.add(item);
        Collections.sort(items, (item1, item2) -> item1.getName().compareTo(item2.getName()));
    }

    
    public void removeItem(Item item) {
        items.remove(item);
    }
    /**
     *
     * @return All the items name in the lexicographical order separated by
     * a comma followed by a space. For example,
     * <pre>
     * {@code Cappuccino, Chai, Latte, Mocha}
     * </pre>
     */
    public String displayItems() {
    	StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).getName());
            if (i < items.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

	
}
