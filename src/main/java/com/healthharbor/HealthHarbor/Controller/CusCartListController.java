package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.CusCartList;
import com.healthharbor.HealthHarbor.Service.CusCartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/CusCartList")
public class CusCartListController {

    @Autowired
    private CusCartListService cusCartListService;

    @GetMapping
    public ResponseEntity<List<CusCartList>> getAllCusCartList()
    {
        return new ResponseEntity<List<CusCartList>>(cusCartListService.getCusCartList(), HttpStatus.OK);
    }

    @PostMapping("/addCusCartItem")
    public ResponseEntity<CusCartList> addCusCartItem(@RequestBody CusCartList custCartList)
    {
        return new ResponseEntity<>(cusCartListService.addCusCartList(custCartList),HttpStatus.CREATED);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<Void> deleteItemFromCusCartList(@PathVariable int product_id)
    {
        cusCartListService.deleteItem(product_id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/{product_id}")
//    public ResponseEntity<Void> changeStatusToPending(@PathVariable("product_id") int productId) {
//        cusCartListService.changeStatusToPending(productId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
