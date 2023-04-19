package com.cuisine;

import java.util.Scanner;

abstract class Cuisine {
	 public abstract Cuisine serveFood(String dish);
	}

	class UnservableCuisineRequestException extends Exception {
	    public UnservableCuisineRequestException(String message) {
	        super(message);
	    }
	}
 
	class Italian extends Cuisine{
	    private String dish;

	    public String getDish() {
	        return dish;
	    }

	    public void setDish(String dish) {
	        this.dish = dish;
	    }
	    @Override
	    public Cuisine serveFood(String dish) {
	        setDish(dish);
	        return this;
	    }
	}

	class Polish extends Cuisine{
	    private String dish;

	    public String getDish() {
	        return dish;
	    }

	    public void setDish(String dish) {
	        this.dish = dish;
	    }
	    @Override
	    public Cuisine serveFood(String dish) {
	        setDish(dish);
	        return this;
	    }
	}

	class Japanese extends Cuisine{

	    private String dish;

	    public String getDish() {
	        return dish;
	    }

	    public void setDish(String dish) {
	        this.dish = dish;
	    }
	    @Override
	    public Cuisine serveFood(String dish) {
	        setDish(dish);
	        return this;
	    }
	}

	class Chinese extends Cuisine {
	    private String dish;

	    public String getDish() {
	        return dish;
	    }

	    public void setDish(String dish) {
	        this.dish = dish;
	    }
	    @Override
	    public Cuisine serveFood(String dish) {
	        setDish(dish);
	        return this;
	    }
	}




	class FoodFactoryMain {
		 
			
		 private static final FoodFactoryMain instance = new FoodFactoryMain();

		    static FoodFactoryMain getFactory() {
		        return instance;
		    }

	    java.util.Map<String, Cuisine> cuisines =  new java.util.HashMap<String, Cuisine>();


	    void registerCuisine(String cuisineKey, Cuisine cuisine){
	        cuisines.put(cuisineKey, cuisine.serveFood(cuisineKey));
	    }

	    public Cuisine serveCuisine(String cuisine, String dish) throws UnservableCuisineRequestException {
	        if(!cuisines.containsKey(cuisine)){
	            throw new UnservableCuisineRequestException("Unservable cuisine " + cuisine + "for dish "+ dish);
	        }
	        else {
	            return cuisines.get(cuisine).serveFood(dish);
	        }
	    }
	}

 class Solution {
	

	 public static void main(String[] args) {
		    
		 
	Scanner INPUT_READER = new Scanner(System.in);
	     
	      
	 FoodFactory FOOD_FACTORY = FoodFactory.getFactory();

	  
	        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
	        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
	        FoodFactory.getFactory().registerCuisine("Polish", new Polish());
       
	  
	    int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
	    //INPUT_READER.next();
	  
	    
	
	        while (totalNumberOfOrders-- >0) {
	        	//n-- != 0
	        	
				String[]food= INPUT_READER.nextLine().split(" ");
			
				
				//INPUT_READER.nextLine().split(" ");
				//INPUT_READER.nextLine().split(" ");
			
				 String cuisine = food[0];
				 String dish = food[1];
				 
								
	            try {
	            
	                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
	               	
		
						Cuisine servedFood = FOOD_FACTORY.serverCuisine(cuisine, dish);
						
						
	                    switch (cuisine) {
	                   
	                        case "Italian":
	                            Italian italianDish = (Italian) servedFood;
	                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
	                            break;
	                        case "Japanese":
	                            Japanese japaneseDish = (Japanese) servedFood;
	                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
	                            break;
	                        case "Polish":
	                            Polish polishDish = (Polish) servedFood;
	                            System.out.println("Serving " + polishDish.getDish() + "(Polish)");
	                            break;
	                        default:
	                            break;
	                    }   }
	                
	            } catch (UnservableCuisineRequestException ex) {
	                System.out.println(ex.getMessage());
	            }
	        	}  
			
	 }

	 
	 
	
 } 
