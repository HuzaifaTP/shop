package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Optional<Shop> getShopById(Long id){
        return shopRepository.findById(id);
    }
    public List<Shop> getAllShops(){
        return shopRepository.findAll();
    }

    public Shop createShop(Shop shop){
        return shopRepository.save(shop);
    }
    public Shop updateShop(Shop shop){
        return shopRepository.save(shop);
    }
    public void deleteShop(Long id){
        shopRepository.deleteShop(id);
    }
}
