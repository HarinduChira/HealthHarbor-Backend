package com.healthharbor.HealthHarbor.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "ReqMedicine")
public class ReqMedicine {

    private ObjectId id;

    private String product_id;
    private String name;
    private String image_url;
    private int req_Stock;
    private String status;
}
