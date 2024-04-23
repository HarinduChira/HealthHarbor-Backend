package com.healthharbor.HealthHarbor.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "CusLogin")
public class CusLogin {

    private ObjectId id;

    private String name;
    private String email;
    private String password;
    private String address;
    private String contactNo;
}
