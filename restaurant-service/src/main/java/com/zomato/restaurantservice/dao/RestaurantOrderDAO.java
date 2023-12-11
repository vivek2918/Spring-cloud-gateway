package com.zomato.restaurantservice.dao;

import com.zomato.restaurantservice.dto.OrderResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class RestaurantOrderDAO {

    public OrderResponseDTO getOrders(String orderId){
        return generateOrders().get(orderId);
    }
    private Map<String, OrderResponseDTO> generateOrders(){
       Map<String , OrderResponseDTO> orderMap = new HashMap<>();
        orderMap.put("123viv", new OrderResponseDTO("123viv", "VEG-MEALS", 1, 199, new Date(), "READY", 20));
        orderMap.put("456viv", new OrderResponseDTO("456viv", "BIRYANI", 2, 499, new Date(), "PREPARING", 40));
        orderMap.put("789viv", new OrderResponseDTO("789viv", "PUNJABI", 3, 299, new Date(), "DELIVERED", 0));
        return orderMap;
    }
}
