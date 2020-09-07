package com.playsafe.converter.controllers;

import com.playsafe.converter.services.DistanceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class DistanceConverterController {

    private final DistanceConverter converter;

    @Autowired
    public DistanceConverterController(DistanceConverter converter) {
        this.converter = converter;
    }

    @GetMapping("/mtok")
    ResponseEntity<Double> toCelsius(@RequestParam double value){
        return ResponseEntity.ok(converter.toKilometer(value));
    }

    @GetMapping("/ktom")
    ResponseEntity<Double> toKelvin(@RequestParam double value){
        return ResponseEntity.ok(converter.toMiles(value));
    }
}
