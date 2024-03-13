package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.CusLogin;
import com.healthharbor.HealthHarbor.Repository.CusLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CusLoginService {
    @Autowired
    private CusLoginRepository cusLoginRepository;

    public Optional<CusLogin> getCusLoginDetails(String email){
        return cusLoginRepository.findCusByEmail(email);
    }

}
