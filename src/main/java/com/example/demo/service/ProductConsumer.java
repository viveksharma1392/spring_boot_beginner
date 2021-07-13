package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {

    @KafkaListener(topics="Product_Topic", groupId = "Product_Group_Id")
    public void getMessage(String productString){
        System.out.println(productString);
    }
}
