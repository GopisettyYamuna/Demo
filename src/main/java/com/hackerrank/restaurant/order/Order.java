package com.hackerrank.restaurant.order;

import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.items.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Order {
    /**
     *
     * The order id
     */
    private final long id;

    /**
     *
     * A map to keep track of all the items in the order and the quantity
     */
    private final Map<Item, Integer> items;

    /**
     *
     * @param id The order id
     */
    public Order(long id) {
        this.id = id;
        this.items = new HashMap<>();
    }

    /**
     *
     * @return The order id
     */
    public long getId() {
        return this.id;
    }

    /**
     *
     * @param item The item to be added in the order
     * @param quantity The added quantity
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     * @throws NotEnoughItemException When the updated quantity is greater than the quantity in the inventory
     * @throws DuplicateItemEntryException When adding an existing item in the order
     */
    public void addItem(Item item, int quantity) throws BadQuantityException, NoSuchItemException, NotEnoughItemException, DuplicateItemEntryException {
        if (quantity <= 0) {
            throw new BadQuantityException("Quantity must be greater than zero");
        }

        if (Inventory.inventory.getItems().contains(item)) {
            throw new NoSuchItemException("Item does not exist in the inventory");
        }

        int currentQuantity = items.getOrDefault(item, 0);
        int newQuantity = currentQuantity + quantity;
        
        if (newQuantity > Inventory.inventory.getQuantity(item)) {
            throw new NotEnoughItemException("Not enough items in inventory to fulfill the order");
        }

        if (items.containsKey(item)) {
            throw new DuplicateItemEntryException("Item already exists in the order");
        }

        items.put(item, quantity);
    }

    /**
     *
     * @param item The item to be removed from the order
     * @throws NoSuchItemException When the item is not available
     */
    public void removeItem(Item item) throws NoSuchItemException {
        if (!items.containsKey(item)) {
            throw new NoSuchItemException("Item is not available in the order");
        }
        items.remove(item);
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
     * @throws NotEnoughItemException When the updated quantity is greater than the quantity in the inventory
     */
    public void incrementQuantity(Item item, int quantity) throws BadQuantityException, NoSuchItemException, NotEnoughItemException {
        if (quantity <= 0) {
            throw new BadQuantityException("Quantity must be greater than zero");
        }

        if (!items.containsKey(item)) {
            throw new NoSuchItemException("Item is not available in the order");
        }

        int currentQuantity = items.get(item);
        int updatedQuantity = currentQuantity + quantity;

        // Check if the updated quantity exceeds the inventory quantity
        if (updatedQuantity > Inventory.inventory.getQuantity(item)) {
            throw new NotEnoughItemException("Not enough " + item.getName() + " available in the inventory");
        }

        items.put(item, updatedQuantity);
    }

    /**
     *
     * @param item The item in the order
     * @param quantity The expected quantity of the decrement
     * <pre>
     * {@code updatedQuantity = currentQuantity - quantity;}
     * </pre>
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     * @throws NotEnoughItemException When the updated quantity is less than zero
     */
    public void decrementQuantity(Item item, int quantity) throws BadQuantityException, NoSuchItemException, NotEnoughItemException {
        if (quantity <= 0) {
            throw new BadQuantityException("Quantity must be greater than zero");
        }

        if (!items.containsKey(item)) {
            throw new NoSuchItemException("Item is not available in the order");
        }

        int currentQuantity = items.get(item);
        int updatedQuantity = currentQuantity - quantity;

        // Ensure updated quantity doesn't go negative
        if (updatedQuantity < 0) {
            throw new NotEnoughItemException("Quantity cannot go negative");
        }

        items.put(item, updatedQuantity);
    }

    /**
     *
     * @return All the items and added quantity
     */
    public Map<Item, Integer> getItems() {
        return this.items;
    }

    /**
     *
     * @return All the items name, quantity, cost per unit, and total cost
     * separated by space each on a separate line. The items on each line must
     * be in the lexicographical order. For example,
     * <pre>
     * {@code
     * Latte 3 $3.78 $11.34
     * Mulled Cider 2 $3.32 $6.64
     * Spicy Apple Cider 2 $3.21 $6.42
     * }
     * </pre>
     */
   /* public String printOrder() {
    	 StringBuilder sb = new StringBuilder();
         sb.append("Order ID: ").append(id).append("\n");
         sb.append("Items:\n");
         for (Map.Entry<Item, Integer> entry : items.entrySet()) {
             Item item = entry.getKey();
             int quantity = entry.getValue();
             sb.append("- ").append(item.getName()).append(": ").append(quantity).append("\n");
         }
         return sb.toString();
    }*/
    public String printOrder() {
        StringBuilder sb = new StringBuilder();

        // Create a TreeMap to store items sorted by name
        Map<String, Item> sortedItems = new TreeMap<>();
        for (Item item : items.keySet()) {
            sortedItems.put(item.getName(), item);
        }

        // Iterate over sorted items and append details to StringBuilder
        for (Item item : sortedItems.values()) {
            int quantity = items.get(item);
            double costPerUnit = item.getCost();
            double totalCost = quantity * costPerUnit;
            sb.append(item.getName()).append("").append(quantity).append(" $").append(costPerUnit).append(" $").append(totalCost).append("\n");
        }

        return sb.toString();
    }
}
