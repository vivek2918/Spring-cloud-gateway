package com.zomato.zomatoapp.client;

import com.zomato.zomatoapp.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestaurantServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public OrderResponseDTO fetchStatus(String orderId){
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId, OrderResponseDTO.class);
    }
}
