package com.richard.cordbyte.steps;

import com.richard.cordbyte.models.Document;
import com.richard.cordbyte.models.Vehicle;
import com.richard.cordbyte.pages.ConfirmVehiclePage;
import com.richard.cordbyte.pages.HomePage;
import com.richard.cordbyte.pages.VehicleEnquiryPage;
import com.richard.cordbyte.service.FileService;
import com.richard.cordbyte.utils.ReadFileData;
import cucumber.api.java8.En;

public class VehicleInfoSteps implements En {

    Vehicle vehicle;


    public VehicleInfoSteps(HomePage homePage, VehicleEnquiryPage vehicleEnquiryPage, ConfirmVehiclePage confirmVehiclePage, FileService fileService) {

        Document excelData = fileService.getExelDocsFromDirectory("files").get(0);

        Given("^a user opens the vehicle (.*)$", (String page) -> {

            String propUrl = ReadFileData.getProperties().getProperty(page);
            homePage.navigateToPage(propUrl);
            homePage.checkPageTitle("Get vehicle information from DVLA - GOV.UK");
            homePage.click_btn_start();

        });

        When("^the user enters registration number for (.*)$", (String vehicleRow) -> {

            vehicle = ReadFileData.getExcelData(excelData.getPath(), Integer.parseInt(vehicleRow));

            vehicleEnquiryPage.enter_registration(vehicle.getRegMark());
            vehicleEnquiryPage.click_continue();

        });

        Then("^display a page with the vehicle information$", () -> {

            confirmVehiclePage.checkPageTitle("Check if a vehicle is taxed and has an MOT");
            confirmVehiclePage.confirmRegMark(vehicle.getRegMark());
            confirmVehiclePage.confirmMake(vehicle.getMake());
            confirmVehiclePage.confirmColour(vehicle.getColour());

        });


    }
}
