package com.api.shopingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class ShopingDto {
    @NotBlank
    private String Name;
    @NotBlank
    @Size(max = 10)
    private String Price;
    @NotBlank
    private String Description;
    @NotBlank
    private String category;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRegistrationDate(LocalDateTime utc) {
    }
}

