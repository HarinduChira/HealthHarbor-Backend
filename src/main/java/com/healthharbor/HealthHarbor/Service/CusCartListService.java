package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.CusCartList;
import com.healthharbor.HealthHarbor.Repository.CusCartListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CusCartListService {

    @Autowired
    private CusCartListRepository cusCartListRepository;

    public CusCartList addCusCartList(CusCartList cusCartList){
        return cusCartListRepository.save(cusCartList);
    }

    public List<CusCartList> getCusCartList(){
        return cusCartListRepository.findAll();
    }

    public void deleteItem(int productId) {

        cusCartListRepository.deleteItemByID(productId);
    }

    public void updateStatus(int productId, String status) {
        Optional<CusCartList> prevCusCartListOptional = cusCartListRepository.findByProductId(productId);
        if (prevCusCartListOptional.isPresent()) {
            CusCartList prevCusCartList = prevCusCartListOptional.get();
            prevCusCartList.setStatus(status);
            cusCartListRepository.save(prevCusCartList);
        } else {
            throw new NoSuchElementException("Product not found"); // Throw exception if product not found
        }
    }

}
