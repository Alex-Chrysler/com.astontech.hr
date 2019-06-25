package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.ui.Model;

public class VehicleVO {

    private String newVehicle;
    private String[] newVehicleArray;
    private String newVehicleYear;
    private String newVehicleLicensePlate;
    private String newVehicleVin;
    private String newVehicleColor;

    private VehicleMake newMake;
    private VehicleModel newModel;

    public VehicleVO(){}

    public String getNewVehicle() {
        return newVehicle;
    }

    public void setNewVehicle(String newVehicle) {
        this.newVehicle = newVehicle;
    }

    public String[] getNewVehicleArray() {
        return newVehicleArray;
    }

    public void setNewVehicleArray(String[] newVehicleArray) {
        this.newVehicleArray = newVehicleArray;
    }

    public String getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(String newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleVin() {
        return newVehicleVin;
    }

    public void setNewVehicleVin(String newVehicleVin) {
        this.newVehicleVin = newVehicleVin;
    }

    public String getNewVehicleColor() {
        return newVehicleColor;
    }

    public void setNewVehicleColor(String newVehicleColor) {
        this.newVehicleColor = newVehicleColor;
    }

    public VehicleMake getNewMake() {
        return newMake;
    }

    public void setNewMake(VehicleMake newMake) {
        this.newMake = newMake;
    }

    public VehicleModel getNewModel() {
        return newModel;
    }

    public void setNewModel(VehicleModel newModel) {
        this.newModel = newModel;
    }


}
