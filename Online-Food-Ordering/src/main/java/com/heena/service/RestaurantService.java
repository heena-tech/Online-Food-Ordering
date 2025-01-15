package com.heena.service;

import com.heena.dto.RestaurantDto;
import com.heena.model.Restaurant;
import com.heena.model.User;
import com.heena.request.CreateRequestRestaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(CreateRequestRestaurant req, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRequestRestaurant updatedRestaurant) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;




}

