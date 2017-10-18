package runners;

import com.richard.cordbyte.base.Driver;
import com.richard.cordbyte.models.Document;
import com.richard.cordbyte.models.Vehicle;
import com.richard.cordbyte.pages.ConfirmVehiclePage;
import com.richard.cordbyte.pages.FirstPage;
import com.richard.cordbyte.pages.VehicleEnquiryPage;
import com.richard.cordbyte.service.FileService;
import com.richard.cordbyte.utils.ReadFileData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class SeleniumVehicleTest {

    private Driver driver;
    private FirstPage firstPage;
    private FileService fileService;
    private VehicleEnquiryPage vehicleEnquiryPage;
    private ConfirmVehiclePage confirmVehiclePage;


    @Before
    public void setUp() {

        this.fileService = new FileService();
        this.driver = new Driver();

        this.firstPage = new FirstPage(this.driver);
        this.vehicleEnquiryPage = new VehicleEnquiryPage(this.driver);
        this.confirmVehiclePage = new ConfirmVehiclePage(this.driver);

    }

    @Test
    public void verifyVehicle() {

        Document excelData = fileService.getExelDocsFromDirectory("files").get(0);
        String homepage = ReadFileData.getProperties().getProperty("homepage");

        List<Vehicle> vehicles = ReadFileData.getExcelData(excelData.getPath());

        for (Vehicle vehicle : vehicles) {

            firstPage.navigateToPage(homepage);
            firstPage.checkPageTitle("Get vehicle information from DVLA - GOV.UK");
            firstPage.click_btn_start();

            vehicleEnquiryPage.checkPageTitle("Check if a vehicle is taxed and has an MOT");
            vehicleEnquiryPage.enter_registration(vehicle.getRegMark());
            vehicleEnquiryPage.click_continue();

            confirmVehiclePage.checkPageTitle("Check if a vehicle is taxed and has an MOT");
            confirmVehiclePage.confirmRegMark(vehicle.getRegMark());
            confirmVehiclePage.confirmMake(vehicle.getMake());
            confirmVehiclePage.confirmColour(vehicle.getColour());
        }
    }

    @After
    public void tearDown() {

        driver.getDriver().quit();
    }
}
