package org.springframework.samples.petclinic.disease;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.exceptions.ResourceNotFoundException;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("/api/v1/diseases")
@SecurityRequirement(name = "bearerAuth")
public class DiseaseController {
    private DiseaseService ds;
    private UserService us;

    public DiseaseController(DiseaseService ds, UserService us){
        this.ds = ds;
        this.us = us;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Disease>> getAllDiseases() {
        return new ResponseEntity<>(ds.findDiseases(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Disease> getDiseaseById(@PathVariable("id") Integer id) {
        Disease d = ds.findDiseaseById(id);
        if(d==null){
            throw new ResourceNotFoundException("No se ha encontrado ninguna enfermedad con esa ID");
        }
        return new ResponseEntity<>(d,HttpStatus.OK);
    }
}
