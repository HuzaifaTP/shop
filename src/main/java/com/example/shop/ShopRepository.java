package com.example.shop;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT shop FROM Shop shop WHERE shop.id = ?1")
    @NonNull
    Optional<Shop> findById(@NonNull Long id);

    @Query("SELECT shop FROM Shop shop")
    @NonNull
    List<Shop> findAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Shop shop WHERE shop.id = ?1")
    void deleteShop(Long id);


}
