package com.kamal.orderservice.service;

import com.kamal.orderservice.model.Customer;
import com.kamal.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="inventory-service")
public interface InventoryRestClientService {

    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);
    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();

}
