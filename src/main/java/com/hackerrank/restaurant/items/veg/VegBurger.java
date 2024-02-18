package com.hackerrank.restaurant.items.veg;

import com.hackerrank.restaurant.items.Category;
import com.hackerrank.restaurant.items.Container;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.menu.Menu;

public class VegBurger implements Item{
    /**
     *
     * The item name
     */
    private final String name;

    /**
     *
     * The item cost per unit
     */
    private double cost;

    /**
     *
     * @param name The item name
     * @param cost The item cost per unit
     */
    public VegBurger(String name, double cost) {
        this.name = name;
        this.cost = cost;
        Menu.menu.addItem(this);
    }

    /**
     *
     * @return The item name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return The item cost per unit
     */
    public double getCost() {
        return this.cost;
    }

    /**
     *
     * @param cost The item updated cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     *
     * @return The item category
     */
    public Category getCategory() {
    	return Category.Snacks;
    }

    /**
     *
     * @return The item container
     */
    public Container getContainer() {
    	return Container.Wrapper;
    }
}
