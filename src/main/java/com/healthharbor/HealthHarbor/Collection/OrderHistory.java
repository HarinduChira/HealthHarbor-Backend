package com.healthharbor.HealthHarbor.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "OrderHistory")
public class OrderHistory {

    private ObjectId id;

    private String cus_email;
    private int product_id;
    private String name;
    private Double total_price;
    private String description;
    private String image_url;
    private String order_status;
}
