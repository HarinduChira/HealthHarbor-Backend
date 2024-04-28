package com.healthharbor.HealthHarbor.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Products")
public class Products {

    private ObjectId id;

    private String product_id;
    private String name;
    private String category;
    private Double price;
    private String description;
    private String image_url;
    private int stock;
    private String status;
    private List<Review> reviews;
}

