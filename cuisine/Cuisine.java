package com.java.cuisine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Cuisine {
	abstract Cuisine serveFood(String dish);

}

class UnservableCuisineRequestException extends Exception {
	public UnservableCuisineRequestException(String message) {
		super(message);
	}
}

class Italian extends Cuisine {
	String dish;

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	@Override
	Cuisine serveFood(String dish) {
		setDish(dish);
		return this;
	}

}

class Japanese extends Cuisine {
	String dish;

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	@Override
	Cuisine serveFood(String dish) {
		setDish(dish);
		return this;
	}

}

class Chinese extends Cuisine {
	String dish;

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	@Override
	Cuisine serveFood(String dish) {
		setDish(dish);
		return this;
	}

}

class Mexican extends Cuisine {
	String dish;

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	@Override
	Cuisine serveFood(String dish) {
		setDish(dish);
		return this;
	}

}

class FoodFactory {
	 private static final FoodFactory instance = new FoodFactory();

	static FoodFactory getFactory() {
		return instance;
	}

	Map<String, Cuisine> cuisi = new HashMap<String, Cuisine>();

	void registerCuisine(String cuisineKey, Cuisine cuisine) {
		cuisi.put(cuisineKey, cuisine.serveFood(cuisineKey));
	}

	public Cuisine serveCuisine(String cuisine, String dish) throws UnservableCuisineRequestException {
		if (!cuisi.containsKey(cuisine)) {
			throw new UnservableCuisineRequestException("UnservableCuisine" + cuisine + "for dish" + dish);
		} else {
			return cuisi.get(cuisine).serveFood(dish);
		}

	}

}

class Demo {

	static Scanner sc = new Scanner(System.in);
	static FoodFactory Ff = FoodFactory.getFactory();

	static {
		FoodFactory.getFactory().registerCuisine("Italian", new Italian());
		FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
		FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
		FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
	}

	public static void main(String[] args) {
		int totalNUmberOfOrders = Integer.parseInt(sc.nextLine());
		while (totalNUmberOfOrders-- > 0) {
			String[] food = sc.nextLine().split("");
			String cuisine = food[3];
			String dish = food[3];
			try {
				if (Ff.equals(FoodFactory.getFactory())) {
					Cuisine servedFood = Ff.serveCuisine(cuisine, dish);
		switch(cuisine) {
		case "Italian":
			Italian italianDish = (Italian) servedFood;
			System.out.println("Serving " + italianDish.getDish() + "(Italian)");
			break;
		case "Japanese":
			Japanese japaneseDish = (Japanese) servedFood;
			System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
			break;
		
		case "Chinese":
			Chinese chineseDish = (Chinese) servedFood;
			System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
			break;
				
		case "Mexican":
			Mexican mexicanDish = (Mexican) servedFood;
			System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
			break;
			}
}
}catch(

	UnservableCuisineRequestException e)
	{
		System.out.println(e.getMessage());

	}
}

}}
