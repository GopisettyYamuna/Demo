package com.hackerrank.restaurant.inventory;

import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.items.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    /**
     *
     * Inventory static instance to access the inventory
     */
    public static final Inventory inventory = new Inventory();

    /**
     *
     * A map to keep track of all the items and the quantity
     */
    private final Map<Item, Integer> itemsCount;

    /**
     *
     * Initializes the items count map
     */
    public Inventory() {
        this.itemsCount = new HashMap<>();
    }

    /**
     *
     * @param item The item to be added in the inventory
     * @param quantity The added quantity
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws DuplicateItemEntryException When adding an existing item in the inventory
     */
    public void addItem(Item item, int quantity) throws BadQuantityException,DuplicateItemEntryException{
    	if (quantity <= 0) {
            throw new BadQuantityException("Quantity must be greater than zero");
        }  
    	if (itemsCount.containsKey(item)) {
            throw new DuplicateItemEntryException("Cannot add duplicate item 'Latte'.");
        }
    	itemsCount.put(item, quantity);

    }

    /**
     *
     * @param item The item to be removed from the inventory
     * @throws NoSuchItemException When the item is not available
     */
    public void removeItem(Item item) throws NoSuchItemException{
    	if(!itemsCount.containsKey(item)) {
    		throw new NoSuchItemException("Item 'Mocha' is not available.");
    	}
    	itemsCount.remove(item);

    }

    /**
     *
     * Remove all the items in the inventory
     */
    public void removeAllItems() {
    	itemsCount.clear();
    }

    /**
     *
     * @return List of all the items in the inventory
     */
    public List<Item> getItems() {
        return new ArrayList<>();
    }

    /**
     *
     * @param item The item in the inventory
     * @return The quantity of the item
     */
    public int getQuantity(Item item) {
    	 return itemsCount.getOrDefault(item, 0);
    }

    /**
     *
     * @param item The item in the order
     * @param quantity The expected quantity of the increment
     * <pre>
     * {@code updatedQuantity = currentQuantity + quantity;}
     * </pre>
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     */
    public void incrementQuantity(Item item, int quantity) throws BadQuantityException,NoSuchItemException{
    	if (quantity <= 0) {
            throw new BadQuantityException("Quantity must be greater than zero");
        }

        if (!itemsCount.containsKey(item)) {
            throw new NoSuchItemException("Item is not available in the order");
        }
        int currentQuantity = itemsCount.get(item);
        int updatedQuantity = currentQuantity + quantity;

    	//int currentQuantity = itemsCount.getOrDefault(item, 0);
        itemsCount.put(item, updatedQuantity);

    }

    /**
     *
     * @param item The item in the inventory
     * @param quantity The expected quantity of the decrement
     * <pre>
     * {@code updatedQuantity = currentQuantity - quantity;}
     * </pre>
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     * @throws NotEnoughItemException When the updated quantity is less than zero
     */
    public void decrementQuantity(Item item, int quantity) throws BadQuantityException,NoSuchItemException,NotEnoughItemException {
    	 
    	 if (quantity <= 0) {
             throw new BadQuantityException("Quantity must be greater than zero");
         }

         if (!itemsCount.containsKey(item)) {
             throw new NoSuchItemException("Item is not available in the order");
         }

         int currentQuantity = itemsCount.get(item);
         int updatedQuantity = currentQuantity - quantity;

         // Ensure updated quantity doesn't go negative
         if (updatedQuantity < 0) {
             throw new NotEnoughItemException("Quantity cannot go negative");
         }
         
      //  int currentQuantity = itemsCount.getOrDefault(item, 0);
         //int newQuantity = Math.max(0, currentQuantity - quantity); // Ensure quantity doesn't go negative
         itemsCount.put(item, updatedQuantity);
    }
}
