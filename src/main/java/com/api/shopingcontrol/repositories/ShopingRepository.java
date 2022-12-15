package com.api.shopingcontrol.repositories;

import com.api.shopingcontrol.models.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShopingRepository extends JpaRepository<ProductsModel, UUID> {

}
