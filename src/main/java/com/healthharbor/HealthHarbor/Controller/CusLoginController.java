package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.CusLogin;
import com.healthharbor.HealthHarbor.Service.CusLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/CusLogin")
public class CusLoginController {

    @Autowired
    private CusLoginService cusLoginService;



    @GetMapping("/{email},{password}")
    public ResponseEntity<Optional<String>> getCusByEmail(@PathVariable String email,@PathVariable String password)
    {
        return new ResponseEntity<Optional<String>>(cusLoginService.getCusLoginDetails(email,password), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CusLogin>> getAllCusLogin()
    {
        return new ResponseEntity<List<CusLogin>>(cusLoginService.getCusLogin(), HttpStatus.OK);
    }

    @PostMapping("/AddCus")
    public ResponseEntity<CusLogin> cusSignUp(@RequestBody CusLogin cusLogin)
    {
        return new ResponseEntity<>(cusLoginService.addCus(cusLogin),HttpStatus.CREATED);
    }




}
