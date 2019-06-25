package com.astontech.hr.bootstrap;


import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sun.swing.SwingUtilities2;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        generateElementAndElementTypes();
//        generateEmployeeAndProjects();
//        generateContactAndAddress();
    }

    private void generateElementAndElementTypes() {

        //Ford Make + Models
        VehicleMake fordType = new VehicleMake("Ford");

        List<VehicleModel> vehicleModelList = new ArrayList<>();
        vehicleModelList.add(new VehicleModel("F150"));
        vehicleModelList.add(new VehicleModel("Focus"));
        vehicleModelList.add(new VehicleModel("Equinox"));

        fordType.setVehicleModelList(vehicleModelList);
        vehicleMakeService.saveVehicleMake(fordType);

        //Honda Make + Models
        VehicleMake hondaType = new VehicleMake("Honda");

        List<VehicleModel> vehicleModelList2 = new ArrayList<>();
        vehicleModelList2.add(new VehicleModel("Civic"));
        vehicleModelList2.add(new VehicleModel("Fit"));
        vehicleModelList2.add(new VehicleModel("Accord"));

        hondaType.setVehicleModelList(vehicleModelList2);
        vehicleMakeService.saveVehicleMake(hondaType);



        //Laptop
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);
        elementTypeService.saveElementType(laptopType);


        //Phone
        ElementType phoneList = new ElementType("Phone");

        List<Element> elementList2 = new ArrayList<>();
        elementList2.add(new Element("Iphone"));
        elementList2.add(new Element("Motorolla"));
        elementList2.add(new Element("Galaxy"));
        elementList2.add(new Element("BendPhone"));
        elementList2.add(new Element("Sony"));

        phoneList.setElementList(elementList2);
        elementTypeService.saveElementType(phoneList);

        //GameConsole
        ElementType consoleList = new ElementType("GameConsole");

        List<Element> elementList3 = new ArrayList<>();
        elementList3.add(new Element("GameCube"));
        elementList3.add(new Element("Xbox"));
        elementList3.add(new Element("PlayStation"));
        elementList3.add(new Element("Wii"));
        elementList3.add(new Element("GameBoy"));

        consoleList.setElementList(elementList3);
        elementTypeService.saveElementType(consoleList);

        //email
        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();
        emailList.add(new Element("Work"));
        emailList.add(new Element("Personal"));
        emailList.add(new Element("Delegated"));

        emailType.setElementList(emailList);
        elementTypeService.saveElementType(emailType);


    }

    private void generateEmployeeAndProjects(){

        Employee employee = new Employee();
        employee.setFirstName("Bipin");
        employee.setLastName("Butala");
        employee.setBackground("Java Devloper");
        employeeService.saveEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Alex");
        employee1.setLastName("Chrysler");
        employee1.setBackground("Java Devloper as well");
        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Tony");
        employee2.setLastName("Gardner");
        employee2.setBackground("Dot net Devloper");
        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Dwight");
        employee3.setLastName("Schrute");
        employee3.setBackground("Salesforce Devloper");
        employeeService.saveEmployee(employee3);

    }

    private void generateContactAndAddress(){
        Contact contact = new Contact();
        Address address = new Address();

        address.setAddressNumber("123");
        address.setStreet("Wells Fargo Lane");
        address.setCity("Bloomington");
        address.setState("Minnesota");
        address.setZipCode("55125");
        addressService.saveAddress(address);

        contact.setCompanyName("Wells Fargo");
        contact.setAddress(address);
        contactService.saveContact(contact);


        Contact contact2 = new Contact();
        Address address2 = new Address();

        address2.setAddressNumber("3127");
        address2.setStreet("Best Buy Blvd");
        address2.setCity("St. Paul");
        address2.setState("Wisconsin");
        address2.setZipCode("55125");
        addressService.saveAddress(address2);

        contact2.setCompanyName("Best Buy");
        contact2.setAddress(address2);
        contactService.saveContact(contact2);


        Contact contact3 = new Contact();
        Address address3 = new Address();

        address3.setAddressNumber("611");
        address3.setStreet("Old Town Road");
        address3.setCity("Houston");
        address3.setState("Texas");
        address3.setZipCode("12345");
        addressService.saveAddress(address3);

        contact3.setCompanyName("Old Town Road Inc");
        contact3.setAddress(address3);
        contactService.saveContact(contact3);

    }


}
