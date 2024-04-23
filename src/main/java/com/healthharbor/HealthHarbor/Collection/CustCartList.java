package com.healthharbor.HealthHarbor.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "CusCartList")
public class CustCartList {

    private ObjectId id;

    private String cus_email;
    private String product_id;
    private String product_name;
    private double price;
    private String image_url;
    private int quantity;
    private String date;
    private String status;

}
