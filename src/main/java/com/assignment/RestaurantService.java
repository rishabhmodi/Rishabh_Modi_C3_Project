package com.assignment;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws RestaurantNotFoundException{
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName().equals(restaurantName)){
                return restaurant;
            }
        }
        throw new RestaurantNotFoundException(restaurantName);
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public void removeRestaurant(String restaurantName) throws RestaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if(restaurantToBeRemoved == null){
            throw new RestaurantNotFoundException(restaurantName);
        }
        restaurants.remove(restaurantToBeRemoved);
    }

    public List<Restaurant> getRestaurants() {
        return Collections.unmodifiableList(restaurants);
    }
}
