package com.api.shopingcontrol.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50)
    private String Name;
    @Column(nullable = false, unique = true, length = 10)
    private String Price;
    @Column(nullable = false, length = 70)
    private String Description;
    @Column(nullable = false, length = 70)
    private String category;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getDescription(String description) {
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
