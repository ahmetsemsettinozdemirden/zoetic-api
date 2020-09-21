package com.zoetic.ahmetsemsettinozdemidenassigment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Oximeter {

    @Id
    public String id;

    private int spo2;
    private int pulseRate;
    private LocalDateTime date;

    public Oximeter() {}

    public Oximeter(int spo2, int pulseRate, LocalDateTime date) {
        this.spo2 = spo2;
        this.pulseRate = pulseRate;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSpo2() {
        return spo2;
    }

    public void setSpo2(int spo2) {
        this.spo2 = spo2;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
