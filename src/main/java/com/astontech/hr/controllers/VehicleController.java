package com.astontech.hr.controllers;


import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;





    @RequestMapping(value = "admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model){
        saveVehiclefromVO(vehicleVO);

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model){
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id, Model model){
        Vehicle vehicle = vehicleService.getVehicleById(id);

        model.addAttribute("vehicle", vehicle);
        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle, Model model) {

        vehicleMakeService.saveVehicleMake(vehicle.getVehicleModel().getVehicleMake());
        vehicleModelService.saveVehicleModel(vehicle.getVehicleModel());
        vehicleService.saveVehicle(vehicle);
        return "redirect:/admin/vehicle/edit/" + vehicle.getId();
    }

    @RequestMapping( value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id){
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicle/list";
    }


    private void saveVehiclefromVO(VehicleVO vehicleVO){
        Vehicle newVehicle = new Vehicle(vehicleVO.getNewVehicle());
        newVehicle.setColor(vehicleVO.getNewVehicleColor());
        newVehicle.setLicensePlate(vehicleVO.getNewVehicleLicensePlate());
        newVehicle.setVin(vehicleVO.getNewVehicleVin());
        newVehicle.setYear(vehicleVO.getNewVehicleYear());
        newVehicle.setVehicleModel(vehicleVO.getNewModel());
        newVehicle.getVehicleModel().setVehicleMake(vehicleVO.getNewMake());

         vehicleService.saveVehicle(newVehicle);


    }


}
