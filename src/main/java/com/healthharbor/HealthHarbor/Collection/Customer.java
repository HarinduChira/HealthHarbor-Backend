package com.healthharbor.HealthHarbor.Collection;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Customer")
public class Customer {

    private ObjectId id;

    private String name;
    private String email;
    private String password;
    private String address;
    private String contactNo;

}
