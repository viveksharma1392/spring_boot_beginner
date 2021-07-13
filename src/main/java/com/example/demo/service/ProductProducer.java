package com.example.demo.service;

import com.example.demo.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;

@Service
public class ProductProducer {
    private static final String TOPIC="Product_Topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ProductService productService;

    private ObjectMapper mapper = new ObjectMapper();

    public void writeMessage(Long id){
        Product product = productService.getProductById(id);
        String productString = null;
        try {
            productString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        this.kafkaTemplate.send(TOPIC, productString);
    }
}
