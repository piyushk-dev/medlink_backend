package com.medlink.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medlink.services.UserService;

@RestController
public class Hospitals {
    @Autowired
    private UserService uService;

    // Get a single hospital by ID
    @GetMapping("/hospitals/id/{id}")
    public ResponseEntity<?> getHospitalById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(uService.getHospitalById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // Get hospitals by location endpoint
    @GetMapping("/hospitals/{location}")
    public ResponseEntity<?> getHospitals(@PathVariable String location) {
        try {
            return ResponseEntity.ok(uService.getHospitals(location));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch hospitals. Please try again later.");
        }
    }

}
