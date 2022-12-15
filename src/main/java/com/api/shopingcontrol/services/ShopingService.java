package com.api.shopingcontrol.services;

import com.api.shopingcontrol.dtos.ShopingDto;
import com.api.shopingcontrol.models.ProductsModel;
import com.api.shopingcontrol.repositories.ShopingRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShopingService {

  final ShopingRepository shopingRepository;

  public ShopingService(ShopingRepository shopingRepository) {
      this.shopingRepository = shopingRepository;
  }

@Transactional
    public ProductsModel save(ProductsModel productsModel) {
      return shopingRepository.save(productsModel);
    }
    public List<ProductsModel> findAll(){
      return shopingRepository.findAll();
    }

    public Optional<ProductsModel> findById(UUID id) {
      return shopingRepository.findById(id);
    }

    @Transactional
    public void delete (ProductsModel productsModel) {
      shopingRepository.delete(productsModel);
    }
}
