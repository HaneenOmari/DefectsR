package com.example.Defects.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Defects.domain.DefectInstance;
import com.example.Defects.domain.Defect_InstanceRepository;

@RestController
public class defController { 
	 @Autowired
     private Defect_InstanceRepository repository;

    @RequestMapping("/defect")
    public Iterable<DefectInstance> getDef_id() {
    	 return repository.findAll();
    }

}

