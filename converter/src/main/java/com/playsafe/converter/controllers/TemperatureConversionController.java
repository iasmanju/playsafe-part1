package com.playsafe.converter.controllers;

import com.playsafe.converter.services.TempConverter;
import com.playsafe.converter.services.TempConverterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.playsafe.converter.services.TempConverterHandler.CELSIUS;
import static com.playsafe.converter.services.TempConverterHandler.KELVIN;

@RestController
@RequestMapping("/conversions")
public class TemperatureConversionController {

    private final TempConverter tempConverter;

    @Autowired
    public TemperatureConversionController(TempConverter tempConverter) {
        this.tempConverter = tempConverter;
    }

    @GetMapping("/ktoc")
    ResponseEntity<Double> toCelsius(@RequestParam double value){
        return ResponseEntity.ok(tempConverter.toCelsius(value));
    }

    @GetMapping("/ctok")
    ResponseEntity<Double> toKelvin(@RequestParam double value){
        return ResponseEntity.ok(tempConverter.toKelvin(value));
    }
}
