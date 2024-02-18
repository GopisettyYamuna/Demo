package com.hackerrank.restaurant.tests;

import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.exceptions.EmptyOrderException;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.items.beverages.Cider;
import com.hackerrank.restaurant.items.beverages.Coffee;
import com.hackerrank.restaurant.items.beverages.Margarita;
import com.hackerrank.restaurant.items.beverages.Smoothie;
import com.hackerrank.restaurant.items.nonveg.NonVegPizza;
import com.hackerrank.restaurant.items.veg.VegBurger;
import com.hackerrank.restaurant.items.veg.VegPizza;
import com.hackerrank.restaurant.menu.Menu;
import com.hackerrank.restaurant.order.Order;
import com.hackerrank.restaurant.order.PlaceOrder;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantPlaceOrderJUnitTest {
    private Item mulledCider;
    private Item spicyAppleCider;

    private Item latte;
    private Item mocha;

    private Item jalapenoMargarita;
    private Item strawberryMargarita;

    private Item razzyBlueSmoothie;
    private Item spaCucumberSmoothie;

    private Item kimchiBurger;
    private Item riceBurger;

    private Item buffaloBurger;
    private Item steakBurger;

    private Item farmHousePizza;
    private Item margheritaPizza;

    private Item chickenSausagePizza;
    private Item chickenTikkaPizza;

    /**
     *
     * Before running the tests:
     * <ul>
     *      <li>Remove all the items from the inventory</li>
     *      <li>Create items and add in the inventory</li>
     * </ul>
     */
    @Before
    public void setUp() {
        Inventory.inventory.removeAllItems();

        this.mulledCider = new Cider("Mulled Cider", 3.32);
        this.spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        this.latte = new Coffee("Latte", 3.78);
        this.mocha = new Coffee("Mocha", 3.94);

        this.jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        this.strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        this.razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        this.spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        this.kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        this.riceBurger = new VegBurger("Rice Burger", 4.50);

        this.buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        this.steakBurger = new VegBurger("Steak Burger", 4.75);

        this.farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        this.margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        this.chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        this.chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        Inventory.inventory.addItem(this.mulledCider, 10);
        Inventory.inventory.addItem(this.spicyAppleCider, 10);
        Inventory.inventory.addItem(this.latte, 10);
        Inventory.inventory.addItem(this.mocha, 10);
        Inventory.inventory.addItem(this.jalapenoMargarita, 10);
        Inventory.inventory.addItem(this.strawberryMargarita, 10);
        Inventory.inventory.addItem(this.razzyBlueSmoothie, 10);
        Inventory.inventory.addItem(this.spaCucumberSmoothie, 10);
        Inventory.inventory.addItem(this.kimchiBurger, 10);
        Inventory.inventory.addItem(this.riceBurger, 10);
        Inventory.inventory.addItem(this.buffaloBurger, 10);
        Inventory.inventory.addItem(this.steakBurger, 10);
        Inventory.inventory.addItem(this.farmHousePizza, 10);
        Inventory.inventory.addItem(this.margheritaPizza, 10);
        Inventory.inventory.addItem(this.chickenSausagePizza, 10);
        Inventory.inventory.addItem(this.chickenTikkaPizza, 10);
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Adding items in the orders</li>
     *      <li>Placing orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void placeOrderAndValidateOrdersAndValidateInventoryQuantityAndValidateMenu() {
        long firstCustomerId = 3;
        long secondCustomerId = 4;
        long thirdCustomerId = 5;

        Order firstOrder = new Order(5);

        firstOrder.addItem(this.chickenSausagePizza, 1);
        firstOrder.addItem(this.jalapenoMargarita, 1);
        firstOrder.addItem(this.kimchiBurger, 1);
        firstOrder.addItem(this.razzyBlueSmoothie, 1);

        PlaceOrder.placeOrder.placeOrder(firstCustomerId, firstOrder);

        assertThat(
                PlaceOrder.placeOrder.printOrders(firstCustomerId),
                is(String.join("\n",
                        "Chicken Sausage Pizza 1 $7.25 $7.25",
                        "Jalapeno Margarita 1 $3.48 $3.48",
                        "Kimchi Burger 1 $4.50 $4.50",
                        "Razzy Blue Smoothie 1 $4.24 $4.24"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(10));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(10));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(9));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(9));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(9));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(9));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        Order secondOrder = new Order(6);

        secondOrder.addItem(this.mocha, 1);
        secondOrder.addItem(this.latte, 1);

        PlaceOrder.placeOrder.placeOrder(firstCustomerId, secondOrder);

        assertThat(
                PlaceOrder.placeOrder.printOrders(firstCustomerId),
                is(String.join("\n",
                        "Chicken Sausage Pizza 1 $7.25 $7.25",
                        "Jalapeno Margarita 1 $3.48 $3.48",
                        "Kimchi Burger 1 $4.50 $4.50",
                        "Razzy Blue Smoothie 1 $4.24 $4.24",
                        "-----",
                        "Latte 1 $3.78 $3.78",
                        "Mocha 1 $3.94 $3.94"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(9));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(9));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(9));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(9));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(9));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        this.riceBurger.setCost(5.00);
        this.mulledCider.setCost(3.40);

        Order thirdOrder = new Order(7);

        thirdOrder.addItem(this.riceBurger, 2);
        thirdOrder.addItem(this.mulledCider, 2);

        PlaceOrder.placeOrder.placeOrder(secondCustomerId, thirdOrder);

        assertThat(
                PlaceOrder.placeOrder.printOrders(secondCustomerId),
                is(String.join("\n",
                        "Mulled Cider 2 $3.40 $6.80",
                        "Rice Burger 2 $5.00 $10.00"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(9));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(9));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(9));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(9));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(8));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(9));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        Order fourthOrder = new Order(8);

        fourthOrder.addItem(this.mulledCider, 2);
        fourthOrder.addItem(this.riceBurger, 2);

        PlaceOrder.placeOrder.placeOrder(firstCustomerId, fourthOrder);

        assertThat(PlaceOrder.placeOrder.printOrders(
                firstCustomerId),
                is(String.join("\n",
                        "Chicken Sausage Pizza 1 $7.25 $7.25",
                        "Jalapeno Margarita 1 $3.48 $3.48",
                        "Kimchi Burger 1 $4.50 $4.50",
                        "Razzy Blue Smoothie 1 $4.24 $4.24",
                        "-----",
                        "Latte 1 $3.78 $3.78",
                        "Mocha 1 $3.94 $3.94",
                        "-----",
                        "Mulled Cider 2 $3.40 $6.80",
                        "Rice Burger 2 $5.00 $10.00"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(6));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(9));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(9));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(9));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(9));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(6));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(9));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        assertThat(PlaceOrder.placeOrder.printOrders(thirdCustomerId), is(""));
    }

    /**
     *
     * It tests for placing orders with no items
     */
    @Test
    public void placeEmptyOrderAndValidateOrders() {
        long customerId = 6;

        Order order = new Order(9);

        String exceptionMessage = "";

        try {
            PlaceOrder.placeOrder.placeOrder(customerId, order);
        } catch (EmptyOrderException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Cannot place order (id: 9) with no items."));
    }
}
