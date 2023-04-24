package com.example.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getShopById(@PathVariable Long id) {
        Optional<Shop> shop = shopService.getShopById(id);
        return shop.<ResponseEntity<?>>map(value -> ResponseEntity.ok("Shop found: " + value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("No shop found with the given ID"));
    }

    @GetMapping
    public ResponseEntity<String> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        if (shops.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No shops found");
        }
        return ResponseEntity.ok("All shops: " + shops);
    }
    @PostMapping
    public ResponseEntity<String> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.createShop(shop);
        return ResponseEntity.status(HttpStatus.CREATED).body("Shop created: " + createdShop.toString());
    }

    @PutMapping
    public ResponseEntity<String> updateShop(@RequestBody Shop shop) {
        Shop updatedShop = shopService.updateShop(shop);
        return ResponseEntity.ok("Shop updated: " + updatedShop.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.ok("Shop has been deleted");
    }
}
