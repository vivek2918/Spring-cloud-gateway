package com.zomato.restaurantservice.service;

import com.zomato.restaurantservice.dao.RestaurantOrderDAO;
import com.zomato.restaurantservice.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin
public class RestaurantService {
    @Autowired
    private RestaurantOrderDAO restaurantOrderDAO;

    public String greeting(){
        return "Welcome to ZOMATO Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId){
        return restaurantOrderDAO.getOrders(orderId);
    }
}
