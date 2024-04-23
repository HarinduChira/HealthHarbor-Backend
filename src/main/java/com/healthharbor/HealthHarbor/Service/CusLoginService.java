package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.CusLogin;
import com.healthharbor.HealthHarbor.Repository.CusLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusLoginService {
    @Autowired
    private CusLoginRepository cusLoginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<String> getCusLoginDetails(String email,String password){

        Optional<CusLogin> userOptional = cusLoginRepository.findCusByEmail(email);

        if (userOptional.isPresent())
        {
            CusLogin cusLogin = userOptional.get();

            if (passwordEncoder.matches(password, cusLogin.getPassword())) {
                return Optional.of("Login Success");
            } else {
                return Optional.of("Invalid Password");
            }
        }else
        {
            return Optional.of("Customer Not Found");
        }
    }

    public List<CusLogin> getCusLogin() {
        return cusLoginRepository.findAll();

    }

    public CusLogin addCus(CusLogin cusLogin) {

        CusLogin newCus = cusLogin;

        newCus.setPassword(passwordEncoder.encode(newCus.getPassword()));

        return cusLoginRepository.save(newCus);

    }


}
