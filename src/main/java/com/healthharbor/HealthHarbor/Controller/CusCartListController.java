package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.CusCartList;
import com.healthharbor.HealthHarbor.Service.CusCartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


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
    public ResponseEntity<CusCartList> addCusCartItem(@RequestBody CusCartList cusCartList)
    {
        return new ResponseEntity<>(cusCartListService.addCusCartList(cusCartList),HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteItemFromCusCartList(@PathVariable int productId )
    {
        cusCartListService.deleteItem(productId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/UpdateStatus/{productId},{status}")
    public ResponseEntity<String> updateStatus(@PathVariable int productId, @PathVariable String status) {
        try {
            cusCartListService.updateStatus(productId, status);
            return ResponseEntity.ok("Status updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // Product not found
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status");
        }
    }

}
