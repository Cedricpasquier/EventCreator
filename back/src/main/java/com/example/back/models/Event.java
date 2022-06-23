package com.example.back.models;

import java.util.ArrayList;

public class Event {
    private int id;
    private String nomEvent;
    private String descEvent;
    private String startDate;
    private String endDate;
    private int timezone;

    public Event(){

    }

    public Event(int id, String nomEvent, String descEvent, String startDate, String endDate, int timezone){
        this.id = id;
        this.nomEvent = nomEvent;
        this.descEvent = descEvent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timezone = timezone;
    }

    public int getid(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public String getDescEvent() {
        return descEvent;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setTimezone(int timezone){
        this.timezone = timezone;
    }

    public int getTimezone(){
        return timezone;
    }


}
