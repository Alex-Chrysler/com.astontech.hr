package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelID")
    private Integer vehicleMakeId;

    @Version
    private Integer version;

    private String vehicleMakeName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<VehicleModel> vehicleModelList;

    public VehicleMake(){}

    public VehicleMake( String vehicleMakeName){
        this.vehicleMakeName = vehicleMakeName;
    }

    public Integer getVehicleMakeId() {
        return vehicleMakeId;
    }

    public void setVehicleMakeId(Integer vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }


    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }
}
