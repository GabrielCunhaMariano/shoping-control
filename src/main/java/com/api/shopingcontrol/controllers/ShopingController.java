package com.api.shopingcontrol.controllers;

import com.api.shopingcontrol.dtos.ShopingDto;
import com.api.shopingcontrol.models.ProductsModel;
import com.api.shopingcontrol.services.ShopingService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ShopingController {

final ShopingService shopingService;

    public ShopingController(ShopingService shopingService) {
        this.shopingService = shopingService;
    }

    @PostMapping
    public ResponseEntity<Object> saveShoping(@RequestBody @Valid ShopingDto shopingDto){

        var productsModel = new ProductsModel();
        BeanUtils.copyProperties(shopingDto, productsModel);
        productsModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(shopingService.save(productsModel));
        }

    @GetMapping
    public ResponseEntity<List<ProductsModel>>getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(shopingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneshoping(@PathVariable(value = "id") UUID id){
        Optional<ProductsModel> ProductsModelOptional = shopingService.findById(id);
        if (!ProductsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ProductsModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteShoping(@PathVariable(value = "id") UUID id){
        Optional<ProductsModel> ProductsModelOptional = shopingService.findById(id);
        if (!ProductsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        shopingService.delete(ProductsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateShoping(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ShopingDto shopingDto){
        Optional<ProductsModel> shopingModelOptional = shopingService.findById(id);
        if (!shopingModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var shopingModel  = shopingModelOptional.get();
        shopingModel.setCategory(shopingDto.getCategory());
        shopingModel.setName(shopingDto.getName());
        shopingModel.getDescription(shopingDto.getDescription());
        shopingModel.setPrice(shopingDto.getPrice());
        return ResponseEntity.status(HttpStatus.OK).body(shopingService.save(shopingModel));

    }

}

