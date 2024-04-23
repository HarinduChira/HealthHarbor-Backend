package com.healthharbor.HealthHarbor.Controller;


import com.healthharbor.HealthHarbor.Collection.ReqMedicine;
import com.healthharbor.HealthHarbor.Service.ReqMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ReqMedicine")
public class ReqMedicineController {

    @Autowired
    private ReqMedicineService reqMedicineService;

    @GetMapping
    public ResponseEntity<List<ReqMedicine>> getAllReqMedicine() {
        return new ResponseEntity<List<ReqMedicine>>(reqMedicineService.allReqMedicine(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReqMedicine> addReqMedicineToDb(@RequestBody ReqMedicine reqMedicine) {
        ReqMedicine newReqMedicine = reqMedicineService.addReqMedicine(reqMedicine);

        return new ResponseEntity<>(newReqMedicine, HttpStatus.CREATED);
    }
}
