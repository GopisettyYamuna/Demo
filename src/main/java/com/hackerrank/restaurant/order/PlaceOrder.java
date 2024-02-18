package com.hackerrank.restaurant.order;

import com.hackerrank.restaurant.exceptions.EmptyOrderException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class PlaceOrder {

    /**
     *
     * PlaceOrder static instance to access all the placed orders and
     * placing orders
     */
    public static final PlaceOrder placeOrder = new PlaceOrder();
   

    /**
     *
     * A map to keep track of all the orders placed by customers
     */
    private final Map<Long, List<Order>> orders;

    /**
     *
     * Initialize the orders map
     */
    public PlaceOrder() {
        this.orders = new HashMap<>();
    }

    /**
     *
     * @param customerId The customer id placing the order
     * @param order The order
     * @throws EmptyOrderException When there are no items in the order
     */
    public void placeOrder(long customerId, Order order) throws EmptyOrderException{
    	if (order.getItems().isEmpty()) {
            throw new EmptyOrderException("Cannot place order (id: 9) with no items.");
        }  
    	orders.computeIfAbsent(customerId, k -> new ArrayList<>()).add(order);
    }

    /**
     *
     * @param customerId The customer id
     * @return List of all the orders placed by the customer
     */
    public List<Order> getOrders(long customerId) {
    	return orders.getOrDefault(customerId, new ArrayList<>());
    }

    /**
     *
     * @param customerId The customer id
     * @return All the orders in the string representation
     * (refer {@link Order#printOrder()}) separated by
     * five dashes each on a separate line. For example,
     * <pre>
     * {@code
     * Chicken Sausage Pizza 1 $7.25 $7.25
     * Jalapeno Margarita 1 $3.48 $3.48
     * Kimchi Burger 1 $4.50 $4.50
     * Razzy Blue Smoothie 1 $4.24 $4.24
     * -----
     * Latte 1 $3.78 $3.78
     * Mocha 1 $3.94 $3.94
     * }
     * </pre>
     */
    public String printOrders(long customerId) {
    	StringBuilder sb = new StringBuilder();
    	
    	 
    	List<Order> customerOrders = getOrders(customerId);
    	for (Order order : customerOrders) {
            
                 sb.append(order.printOrder());
             
         }
    	

         // Remove the trailing newline character if there are orders
         if (sb.length() > 0) {
             sb.deleteCharAt(sb.length() - 1);
         }

         return sb.toString();
    }
}
