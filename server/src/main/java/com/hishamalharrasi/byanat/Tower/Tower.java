package com.hishamalharrasi.byanat.Tower;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tower {
    @JsonProperty("tower_id")
    @Id
    private Long   id;

    @JsonProperty("tower_type")
    private String towerType;
    
    @JsonProperty("operator")
    private String operator;

    @JsonProperty("address")
    private String address;
    
    @JsonProperty("technology")
    private String technology;
    
    @JsonProperty("height")
    private double height;
    
    @JsonProperty("latitude")
    private double latitude;
    
    @JsonProperty("longitude")
    private double longitude;

    public Tower() {
        
    }
    
    public Tower(Long id, String towerType, String operator, String address, String technology, double height,
            double latitude, double longitude) {
        this.id = id;
        this.towerType = towerType;
        this.operator = operator;
        this.address = address;
        this.technology = technology;
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
    }



    public String ToString(){
        return "Tower{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", address='" + address + '\'' +
                ", towerType='" + towerType + '\'' +
                ", technology='" + technology + '\'' +
                ", height=" + height +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}