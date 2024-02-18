package com.hackerrank.restaurant.order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.hackerrank.restaurant.exceptions.NoSuchOrderException;
import com.hackerrank.restaurant.items.Item;

public class OrderPayment {
    /**
     *
     * The customer id placing the order
     */
    private final long customerId;

    /**
     *
     * The order id
     */
    private final long orderId;

    /**
     *
     * @param customerId The customer id placing the order
     * @param orderId The order id
     */
    public OrderPayment(long customerId, long orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }

    /**
     *
     * @return The total cost of the order
     * @throws NoSuchOrderException When the order does not exist
     */
    public double getPayableAmount() throws NoSuchOrderException {
    	
    	 Order order = PlaceOrder.placeOrder.getOrders(customerId).stream()
                 .filter(o -> o.getId() == orderId)
                 .findFirst()
                 .orElseThrow(() -> new NoSuchOrderException("Order (customer id: " + customerId + ", order id: " + orderId + ") does not exist."));

    	    System.out.println("Order ID: " + orderId);
    	    System.out.println("Order items: " + order.getItems());
    	 double totalCost = order.getItems().entrySet().stream()
                 .mapToDouble(entry -> entry.getKey().getCost() * entry.getValue())
                 .sum();
    	 System.out.println("Total Cost: " + totalCost);
    	 return totalCost;
    }
   
    
}
