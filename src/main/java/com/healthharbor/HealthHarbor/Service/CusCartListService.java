package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.CusCartList;
import com.healthharbor.HealthHarbor.Repository.CusCartListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusCartListService {

    @Autowired
    private CusCartListRepository cusCartListRepository;

    public CusCartList addCusCartList(CusCartList custCartList){
        return cusCartListRepository.save(custCartList);
    }

    public List<CusCartList> getCusCartList(){
        return cusCartListRepository.findAll();
    }

    public void deleteItem(int productId) {

        cusCartListRepository.deleteItemByID(productId);
    }
}
