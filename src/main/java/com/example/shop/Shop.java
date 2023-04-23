package com.example.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

@Entity
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NonNull
    private Long id;
    private String name;
    private String operatingHours;
    private Timestamp startDate;

    public Shop() {
    }
    public Shop(@NonNull Long id, String name, String operatingHours, Timestamp startDate) {
        this.id = id;
        this.name = name;
        this.operatingHours = operatingHours;
        this.startDate = startDate;
    }

}
