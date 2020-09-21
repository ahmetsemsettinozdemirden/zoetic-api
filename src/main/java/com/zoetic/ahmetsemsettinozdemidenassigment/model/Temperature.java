package com.zoetic.ahmetsemsettinozdemidenassigment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Temperature {

    @Id
    public String id;

    private double temperature;
    private LocalDateTime date;

    public Temperature() {}

    public Temperature(double temperature, LocalDateTime date) {
        this.temperature = temperature;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
