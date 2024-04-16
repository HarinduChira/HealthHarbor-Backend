package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.CustCartList;
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
    public ResponseEntity<List<CustCartList>> getAllCusCartList()
    {
        return new ResponseEntity<List<CustCartList>>(cusCartListService.getCusCartList(), HttpStatus.OK);
    }

    @PostMapping("/addCusCartItem")
    public ResponseEntity<CustCartList> addCusCartItem(@RequestBody CustCartList custCartList)
    {
        return new ResponseEntity<>(cusCartListService.addCusCartList(custCartList),HttpStatus.CREATED);
    }

}
