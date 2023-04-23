package com.example.shop;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @NonNull Optional<Shop> findById(@NonNull Long id);
    List<Shop> findByName(String name);

    @Query("SELECT shops FROM Shop shops WHERE shops.operatingHours LIKE %?1%")
    List<Shop> findByOperatingHoursContaining(String operatingHoursFragment);

    @Query("SELECT shops FROM Shop shops WHERE shops.startDate < ?1")
    List<Shop> findShopsStartedBeforeDate(java.sql.Timestamp startDate);
}
