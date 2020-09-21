package com.zoetic.ahmetsemsettinozdemidenassigment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class BloodPressure {

    @Id
    public String id;

    private int systolicPressure;
    private int diastolicPressure;
    private LocalDateTime date;

//    public Blood() {}

    public BloodPressure(int systolicPressure, int diastolicPressure, LocalDateTime date) {
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
