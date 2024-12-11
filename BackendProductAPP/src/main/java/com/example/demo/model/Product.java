package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    private Long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String sku;
    private int weight;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private String returnPolicy;
    private int minimumOrderQuantity;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private List<String> images;

    private String thumbnail;

    @Embedded
    private Dimensions dimensions;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Embedded
    private Meta meta;
}

@Embeddable
@Data
class Dimensions {
    private double width;
    private double height;
    private double depth;
}

@Embeddable
@Data
class Meta {
    private String createdAt;
    private String updatedAt;
    private String barcode;
    private String qrCode;
}

@Entity
@Data
class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String comment;
    private String date;
    private String reviewerName;
    private String reviewerEmail;
}
