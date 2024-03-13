package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.CusLogin;
import com.healthharbor.HealthHarbor.Service.CusLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/CusLogin")
public class CusLoginController {

    @Autowired
    private CusLoginService cusLoginService;

    @GetMapping("/{email}")
    public ResponseEntity<Optional<CusLogin>> getCusByEmail(@PathVariable String email)
    {
        return new ResponseEntity<Optional<CusLogin>>(cusLoginService.getCusLoginDetails(email), HttpStatus.OK);
    }


}
