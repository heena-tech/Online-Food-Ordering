package com.heena.controller;


import com.heena.model.Restaurant;
import com.heena.model.User;
import com.heena.request.CreateRequestRestaurant;
import com.heena.service.RestaurantService;
import com.heena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.awt.*;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(


            @RequestHeader("Authorization") String jwt,
            @RequestParam String  keyword
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);
        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);}

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(


            @RequestHeader("Authorization") String jwt

    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant = restaurantService.getAllRestaurant();
        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);}

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(


            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id

    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);}









}
