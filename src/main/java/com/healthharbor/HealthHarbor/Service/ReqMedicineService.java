package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.ReqMedicine;
import com.healthharbor.HealthHarbor.Repository.ReqMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReqMedicineService {

    @Autowired
    private ReqMedicineRepository reqMedicineRepository;

    public List<ReqMedicine> allReqMedicine()
    {
        return reqMedicineRepository.findAll();
    }
    public ReqMedicine addReqMedicine(ReqMedicine reqMedicine) {
        return reqMedicineRepository.save(reqMedicine);
    }
}
