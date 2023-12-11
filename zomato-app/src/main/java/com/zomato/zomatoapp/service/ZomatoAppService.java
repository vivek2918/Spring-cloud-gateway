package com.zomato.zomatoapp.service;

import com.zomato.zomatoapp.client.RestaurantServiceClient;
import com.zomato.zomatoapp.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZomatoAppService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;
    public String greeting(){
        return "Welcome to ZOMATO App Service";
    }

    public OrderResponseDTO checkStatus(String orderId){
        return restaurantServiceClient.fetchStatus(orderId);
    }
}
