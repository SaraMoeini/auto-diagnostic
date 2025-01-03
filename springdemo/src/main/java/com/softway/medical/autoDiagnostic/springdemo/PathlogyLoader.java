package com.softway.medical.autoDiagnostic.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PathlogyLoader {

    public List<Pathology> getPathology(Integer healthIndex) {
        List<Pathology> pathologies= new ArrayList<>();

        if(healthIndex % 5 == 0)    
            pathologies.add(new Pathology(null,"Traumatologie"));
        if(healthIndex % 3 == 0)    
            pathologies.add(new Pathology(null,"Cardiologie"));
        if(healthIndex % 5 != 0 && healthIndex % 3 != 0)
            pathologies.add(new Pathology(null, "Nothing"));

        return pathologies;
    }
}
