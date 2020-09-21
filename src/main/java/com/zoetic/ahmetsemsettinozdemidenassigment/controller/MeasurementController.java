package com.zoetic.ahmetsemsettinozdemidenassigment.controller;

import com.zoetic.ahmetsemsettinozdemidenassigment.dto.MeasurementDTO;
import com.zoetic.ahmetsemsettinozdemidenassigment.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public MeasurementDTO getMeasurement(
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return measurementService.getMeasurement(date);
    }

    @PostMapping
    public void addMeasurement(@RequestBody MeasurementDTO measurementDTO) {
        measurementService.addMeasurement(measurementDTO);
    }

}
