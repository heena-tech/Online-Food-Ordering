package com.heena.controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.heena.model.Restaurant;
import com.heena.model.User;
import com.heena.request.CreateRequestRestaurant;
import com.heena.response.MessageResponse;
import com.heena.service.RestaurantService;
import com.heena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;
@PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(

            @RequestBody CreateRequestRestaurant req,
            @RequestHeader("Authorization") String jwt
            ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.createRestaurant(req,user);
        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);}

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(

            @RequestBody CreateRequestRestaurant req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.updateRestaurant(id,req);
        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);}

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(


            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        restaurantService.deleteRestaurant(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("restaurant deleted successfully");
        return  new ResponseEntity<>(res, HttpStatus.OK);}

    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(


            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.updateRestaurantStatus(id);

        return  new ResponseEntity<>(restaurant, HttpStatus.OK);}

    @PutMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(

            @RequestHeader("Authorization") String jwt

    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());

        return  new ResponseEntity<>(restaurant, HttpStatus.OK);}













}



